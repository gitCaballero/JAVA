package com.porto.login.social.sso.type.converter;

import java.util.ArrayList;
import java.util.List;

import com.porto.login.social.sso.dto.Person;
import com.porto.login.social.sso.type.PersonType;

public class PersonTypeConverter {

	public static PersonType convertToType(Person person) {
		PersonType retorno = null;
		if (person != null) {
			retorno = new PersonType();
			retorno.setDocumentIdentifier(person.getDocumentIdentifier());
			retorno.setIdRedesocial(person.getIdRedesocial());
		}
		return retorno;
	}
	
	public static List<PersonType> convertToType(List<Person> persons) {
		ArrayList<PersonType> retorno = new ArrayList<>();
		
		
		for (Person person : persons) {
			retorno.add(convertToType(person));
		}
		
		return retorno;
	}
	
}
