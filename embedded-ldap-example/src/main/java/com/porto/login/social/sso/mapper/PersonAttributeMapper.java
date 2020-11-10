package com.porto.login.social.sso.mapper;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.porto.login.social.sso.dto.Person;

public class PersonAttributeMapper implements AttributesMapper<Person> {
	@Override
	public Person mapFromAttributes(Attributes attributes) throws NamingException {
		Person person = new Person();
		person.setDocumentIdentifier(null != attributes.get("uid") ? (String) attributes.get("uid").get() : null);
		person.setIdRedesocial(null != attributes.get("caption") ? (List<String>) attributes.get("caption").get() : null);
		person.setFullName(null != attributes.get("cn") ? (String) attributes.get("cn").get() : null);
		person.setDescription(null != attributes.get("description") ? (String) attributes.get("description").get() : null);
		//person.setDocumentIdentifier(null != attributes.get("documentIdentifier") ? (String) attributes.get("documentIdentifier").get() : null);
		person.setGivenName(null != attributes.get("givenName") ? (String) attributes.get("givenName").get() : null);
		person.setLoginTimes(null != attributes.get("loginTimes") ? (String) attributes.get("loginTimes").get() : null);
		person.setMail(null != attributes.get("mail") ? (String) attributes.get("mail").get() : null);
		person.setOrganizationalStatus(null != attributes.get("organizationalStatus") ? (String) attributes.get("organizationalStatus").get(): null);
		person.setPsAdmissiondate(null != attributes.get("psAdmissiondate") ? (String) attributes.get("psAdmissiondate").get() : null);
		person.setPspwdChange(null != attributes.get("pspwdChange") ? (String) attributes.get("pspwdChange").get() : null);
		person.setSnpsRole(null != attributes.get("snpsRole") ? (String) attributes.get("snpsRole").get() : null);
		person.setLastName(null != attributes.get("sn") ? (String) attributes.get("sn").get() : null);
		person.setUserPassword(null != attributes.get("userPassword") ? (Object) attributes.get("userPassword").get() : null);
		return person;
	}
	
}