package com.porto.login.social.sso.mapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

public class PersonNameAttributesMapper implements AttributesMapper<String> {
	public String mapFromAttributes(Attributes attrs) throws NamingException {
		return attrs.get("cn").get().toString();
	}
}
