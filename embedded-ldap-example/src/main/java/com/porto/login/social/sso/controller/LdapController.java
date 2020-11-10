package com.porto.login.social.sso.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.porto.login.social.sso.dto.Person;
import com.porto.login.social.sso.exception.PersonException;
import com.porto.login.social.sso.repository.PersonRepo;
import com.porto.login.social.sso.type.PersonRequestType;
import com.porto.login.social.sso.type.PersonType;

@RestController
public class LdapController {
	private static final Logger LOGGER = LogManager.getLogger(LdapController.class);
	@Autowired
	private PersonRepo personRepo;

	@GetMapping("/get-user-names")
	public ResponseEntity<List<String>> getLdapUserNames() {
		return new ResponseEntity<>(personRepo.getAllPersonNames(), HttpStatus.OK);
	}

	@GetMapping("/get-users")
	public ResponseEntity<List<Person>> getLdapUsers() {
		return new ResponseEntity<>(personRepo.getAllPersons(), HttpStatus.OK);
	}

	@GetMapping("/get-user")
	public ResponseEntity<PersonType> findLdapPerson(
			@RequestParam(name = "idRedesocial", required = false) String idRedesocial,
			@RequestParam(name = "documentIdentifier", required = false) String documentIdentifier)
			throws PersonException {

		try {

			if ((documentIdentifier != null && idRedesocial != null)
					&& (!idRedesocial.isEmpty() && !documentIdentifier.isEmpty())) {
				return new ResponseEntity("Deve passar somente um parametro", HttpStatus.BAD_REQUEST);
			}

			if ((idRedesocial != null && !idRedesocial.isEmpty())) {
				return new ResponseEntity<>(personRepo.getPersonByIdRedesocial(idRedesocial), HttpStatus.OK);
			} else if ((documentIdentifier != null && !documentIdentifier.isEmpty())) {
				return new ResponseEntity<>(personRepo.getPersonByDocumentIdentifier(documentIdentifier),
						HttpStatus.OK);
			}
			return new ResponseEntity("Tipo de pessoa inválido", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error("Erro ao consultarPeson: " + e.getMessage(), e);
			throw new PersonException("Erro ao consultarPeson: " + e.getMessage(), e);
		}

	}
	
	/* add-user com o mínimo do parámetros obrigatorios */
//	@PostMapping("/add-user")
//	public ResponseEntity<String> bindLdapPerson(@RequestBody(required = true) Person person) {
//
//		if (person.getIdRedesocial() == null || person.getDocumentIdentifier() == null) {
//			return new ResponseEntity<String>("Parámetros insuficientes", HttpStatus.BAD_REQUEST);
//		}
//		if (person.getIdRedesocial().isEmpty() || person.getDocumentIdentifier().isEmpty()) {
//			return new ResponseEntity<String>("Parámetros insuficientes", HttpStatus.BAD_REQUEST);
//		} else {
//			try {
//				String result = personRepo.create(person);
//				return new ResponseEntity<>(result, HttpStatus.OK);
//
//			} catch (Exception e) {
//				return new ResponseEntity<>(person.getDocumentIdentifier() + ": ja está registrado",
//						HttpStatus.BAD_REQUEST);
//			}
//		}
//	}
	
	@PostMapping("/add-entry")
	public ResponseEntity<String> insertLdapFieldsPerson(@RequestBody(required = true) PersonRequestType person) {

//		if (person.getIdRedesocial() == null || person.getDocumentIdentifier() == null) {
//			return new ResponseEntity<String>("Parámetros insuficientes", HttpStatus.BAD_REQUEST);
//		}
//		if (person.getIdRedesocial().isEmpty() || person.getDocumentIdentifier().isEmpty()) {
//			return new ResponseEntity<String>("Parámetros insuficientes", HttpStatus.BAD_REQUEST);
//		} else {
			try {
				String result = personRepo.addIdRedeSocial(person);
				return new ResponseEntity<>(result, HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<>(person.getDocumentIdentifier() + ": ja está registrado",
						HttpStatus.BAD_REQUEST);
			}
		}
//	}

	//Método add-user com tudos os parámetros orbigatorios
//	@PostMapping("/add-user")
//	public ResponseEntity<String> bindLdapPerson(@RequestBody(required = true) Person person) {
//
//		if (person.getFullName() == null || person.getLastName() == null || person.getDescription() == null
//				|| person.getIdRedesocial() == null || person.getDocumentIdentifier() == null
//				|| person.getGivenName() == null || person.getLoginTimes() == null || person.getMail() == null
//				|| person.getOrganizationalStatus() == null || person.getPsAdmissiondate() == null
//				|| person.getPspwdChange() == null || person.getSnpsRole() == null
//				|| person.getUserPassword() == null) {
//			return new ResponseEntity<String>("Parámetros insuficientes", HttpStatus.BAD_REQUEST);
//		}
//		if (person.getFullName().isEmpty() || person.getLastName().isEmpty() || person.getDescription().isEmpty()
//				|| person.getIdRedesocial().isEmpty() || person.getDocumentIdentifier().isEmpty()
//				|| person.getGivenName().isEmpty() || person.getLoginTimes().isEmpty() || person.getMail().isEmpty()
//				|| person.getOrganizationalStatus().isEmpty() || person.getPsAdmissiondate().isEmpty()
//				|| person.getPspwdChange().isEmpty() || person.getSnpsRole().isEmpty()
//				|| person.getUserPassword().toString().isEmpty()) {
//			return new ResponseEntity<String>("Parámetros insuficientes", HttpStatus.BAD_REQUEST);
//		} else {
//			try {
//				String result = personRepo.create(person);
//				return new ResponseEntity<>(result, HttpStatus.OK);
//
//			} catch (Exception e) {
//				return new ResponseEntity<>(person.getDocumentIdentifier() + ": ja está registrado",
//						HttpStatus.BAD_REQUEST);
//			}
//		}
//	}

	@GetMapping("/remove-user")
	public ResponseEntity<String> unbindLdapPerson(
			@RequestParam(name = "idRedesocial", required = false) String idRedesocial,
			@RequestParam(name = "documentIdentifier", required = false) String documentIdentifier) {
		String result = personRepo.remove(idRedesocial);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/update-user")
	public ResponseEntity<String> rebindLdapPerson(@RequestBody Person person) {
		String result = personRepo.update(person);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/retrieve-users")
	public ResponseEntity<List<Person>> retrieve() {
		return new ResponseEntity<List<Person>>(personRepo.retrieve(), HttpStatus.OK);
	}

}