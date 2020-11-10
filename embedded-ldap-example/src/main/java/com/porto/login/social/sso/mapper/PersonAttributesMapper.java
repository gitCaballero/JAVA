package com.porto.login.social.sso.mapper;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.porto.login.social.sso.dto.Person;

public class PersonAttributesMapper implements AttributesMapper<Person> {
	public Person mapFromAttributes(Attributes attrs) throws NamingException {
		Person person = new Person();
		person.setDocumentIdentifier(null != attrs.get("uid") ? (String) attrs.get("uid").get() : null);
		person.setIdRedesocial(null != attrs.get("caption") ? (List<String>) attrs.get("caption").get() : null);
		person.setFullName(null != attrs.get("cn") ? (String) attrs.get("cn").get() : null);
		person.setDescription(null != attrs.get("description") ? (String) attrs.get("description").get() : null);
		person.setGivenName(null != attrs.get("givenName") ? (String) attrs.get("givenName").get() : null);
		person.setLoginTimes(null != attrs.get("loginTimes") ? (String) attrs.get("loginTimes").get() : null);
		person.setMail(null != attrs.get("mail") ? (String) attrs.get("mail").get() : null);
		person.setOrganizationalStatus(null != attrs.get("organizationalStatus") ? (String) attrs.get("organizationalStatus").get(): null);
		person.setPsAdmissiondate(null != attrs.get("psAdmissiondate") ? (String) attrs.get("psAdmissiondate").get() : null);
		person.setPspwdChange(null != attrs.get("pspwdChange") ? (String) attrs.get("pspwdChange").get() : null);
		person.setSnpsRole(null != attrs.get("snpsRole") ? (String) attrs.get("snpsRole").get() : null);
		person.setLastName(null != attrs.get("sn") ? (String) attrs.get("sn").get() : null);
		person.setUserPassword(null != attrs.get("userPassword") ? (Object) attrs.get("userPassword").get() : null);
		return person;
	}
}