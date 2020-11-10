package com.porto.login.social.sso.exception;

import java.io.Serializable;

public class PersonException extends Exception implements Serializable {
	private static final long serialVersionUID = 1L;

	public PersonException() {
		super();
	}

	public PersonException(String msg) {
		super(msg);
	}

	public PersonException(String msg, Exception e) {
		super(msg, e);
	}

	public PersonException(Exception e) {
		super(e);
	}
}
