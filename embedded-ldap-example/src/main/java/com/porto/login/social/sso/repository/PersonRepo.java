package com.porto.login.social.sso.repository;

import java.util.List;

import com.porto.login.social.sso.dto.Person;
import com.porto.login.social.sso.type.PersonRequestType;
import com.porto.login.social.sso.type.PersonType;

public interface PersonRepo {

	public List<Person> getAllPersons();
	public List<String> getAllPersonNames();
	public PersonType getPersonByIdRedesocial(String idRedesocial);
	public PersonType getPersonByDocumentIdentifier(String documentIdentifier);
	public List<Person> retrieve();
   // public String create(Person p);
    public String update(Person p);
    public String insert(Person p);
    public String remove(String userId);
    public String addIdRedeSocial(PersonRequestType person);
}