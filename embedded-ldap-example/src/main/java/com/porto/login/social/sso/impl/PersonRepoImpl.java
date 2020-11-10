package com.porto.login.social.sso.impl;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Service;

import com.porto.login.social.sso.dto.Person;
import com.porto.login.social.sso.mapper.PersonAttributeMapper;
import com.porto.login.social.sso.mapper.PersonAttributesMapper;
import com.porto.login.social.sso.mapper.PersonNameAttributesMapper;
import com.porto.login.social.sso.repository.PersonRepo;
import com.porto.login.social.sso.type.PersonRequestType;
import com.porto.login.social.sso.type.PersonType;
import com.porto.login.social.sso.type.converter.PersonTypeConverter;

@Service
public class PersonRepoImpl implements PersonRepo {

	public static final String BASE_DN = "ou=people,dc=asb,dc=com";

	@Autowired
	private LdapTemplate ldapTemplate;

	@Override
	public List<String> getAllPersonNames() {
		List<String> list = ldapTemplate.search(query().where("objectclass").is("person"),
				new PersonNameAttributesMapper());
		return list;
	}

	@Override
	public List<Person> getAllPersons() {
		return ldapTemplate.search(query().where("objectclass").is("person"), new PersonAttributesMapper());
	}

	@Override
	public PersonType getPersonByIdRedesocial(String idRedesocial) {
		List<Person> people = ldapTemplate.search(query().where("caption").is(idRedesocial),
				new PersonAttributeMapper());

		List<PersonType> retornoConverter = PersonTypeConverter.convertToType(people);
		return ((null != retornoConverter && !retornoConverter.isEmpty()) ? retornoConverter.get(0) : null);
	}

	@Override
	public PersonType getPersonByDocumentIdentifier(String documentIdentifier) {
		List<Person> people = ldapTemplate.search(query().where("uid").is(documentIdentifier),
				new PersonAttributeMapper());

		List<PersonType> retornoConverter = PersonTypeConverter.convertToType(people);
		return ((null != retornoConverter && !retornoConverter.isEmpty()) ? retornoConverter.get(0) : null);
	}

//	@Override
//	public String create(Person p) {
//		Name dn = buildDn(p.getDocumentIdentifier());
//		ldapTemplate.bind(dn, null, buildAttributes(p));
//		return p.getIdRedesocial() + " created successfully";
//	}

	@Override
	public String update(Person p) {
		Name dn = buildDn(p.getDocumentIdentifier());
		ldapTemplate.rebind(dn, null, buildAttributes(p));
		return p.getIdRedesocial() + " updated successfully";
	}

	private void displayAttributes(Attributes attributes) throws javax.naming.NamingException {
		if (attributes != null) {
			try {
				for (NamingEnumeration e = attributes.getAll(); e.hasMore();) {
					Attribute attr = (Attribute) e.next();
					System.out.println("Attribute name: " + attr.getID());

					for (NamingEnumeration n = attr.getAll(); n.hasMore(); System.out.println("value: " + n.next()))
						;
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String addIdRedeSocial(PersonRequestType person) {
			
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY,
			"com.sun.jndi.ldap.LdapCtxFactory");
			properties.put(Context.PROVIDER_URL, "ldap://localhost:123");
			properties.put(Context.SECURITY_PRINCIPAL, "uid=admin");			 

			properties.put(Context.SECURITY_CREDENTIALS, "secret");
			try {
			DirContext context = new InitialDirContext(properties);
			Attributes attributes = context
			.getAttributes("uid="+person.getDocumentIdentifier()+","+BASE_DN);
			System.out.println("Before adding new attribute..");
			displayAttributes(attributes);
			System.out.println("Inserting new attribute : " + "");
			Attribute attribute = new BasicAttribute("caption", person.getIdRedesocial());
			ModificationItem[] item = new ModificationItem[1];
			item[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, attribute);
			attributes.put(attribute);

			context.modifyAttributes(
					"uid="+person.getDocumentIdentifier()+","+BASE_DN, item);
			System.out.println("After addition of new attribute..");
			Attributes attributes1 = context
			.getAttributes("uid="+person.getDocumentIdentifier()+","+BASE_DN);
			displayAttributes(attributes1);
			ldapTemplate.rebind("uid="+person.getDocumentIdentifier()+","+BASE_DN, null, attributes1);
			return attributes1.getAll().toString();

		} catch (javax.naming.NamingException e) {
			return e.getMessage();
		}
	}

	@Override
	public String remove(String userId) {
		Name dn = buildDn(userId);
		// ldapTemplate.unbind(dn, true); //Remove recursively all entries
		ldapTemplate.unbind(dn);
		return userId + " removed successfully";
	}

//    Mapeando tudos os atributos ou campos do LDAP
	private Attributes buildAttributes(Person p) {

		BasicAttribute ocattr = new BasicAttribute("objectclass");
		ocattr.add("top");
		ocattr.add("person");

		Attributes attrs = new BasicAttributes();
		attrs.put(ocattr);
		attrs.put("cn", p.getFullName());
		attrs.put("sn", p.getLastName());
		attrs.put("caption", p.getIdRedesocial());
		attrs.put("description", p.getDescription());
		attrs.put("uid", p.getDocumentIdentifier());
		attrs.put("givenName", p.getGivenName());
		attrs.put("loginTimes", p.getLoginTimes());
		attrs.put("mail", p.getMail());
		attrs.put("organizationalStatus", p.getOrganizationalStatus());
		attrs.put("psAdmissiondate", p.getPsAdmissiondate());
		attrs.put("pspwdChange", p.getPspwdChange());
		attrs.put("snpsRole", p.getSnpsRole());
		attrs.put("userPassword", new String(p.getUserPassword().toString()));
		return attrs;
	}

	public Name buildDn(String userId) {
		return LdapNameBuilder.newInstance().add(buildBaseDn()).add("uid", userId).build();
	}

	public Name buildBaseDn() {
		return LdapNameBuilder.newInstance().add(BASE_DN).build();
	}

	@Override
	public List<Person> retrieve() {
		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		List<Person> people = ldapTemplate.search(query().where("objectclass").is("person"),
				new PersonAttributeMapper());
		return people;
	}

	@Override
	public String insert(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

}