package com.porto.login.social.sso.dto;

import java.util.List;

public class Person {
	
	private String fullName; //	private String cn;
	private String lastName; //	private String sn;
	private String description;
	private List<String> idRedesocial; //	private String caption;	
	private String documentIdentifier; // private String uid;	
	private String givenName;
	private String loginTimes;
	private String mail;
	private String organizationalStatus;
	private String psAdmissiondate;
	private String pspwdChange;
	private String snpsRole;
	private Object userPassword;		

	
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getOrganizationalStatus() {
		return organizationalStatus;
	}
	public void setOrganizationalStatus(String organizationalStatus) {
		this.organizationalStatus = organizationalStatus;
	}
	public String getPsAdmissiondate() {
		return psAdmissiondate;
	}
	public void setPsAdmissiondate(String psAdmissiondate) {
		this.psAdmissiondate = psAdmissiondate;
	}
	public String getPspwdChange() {
		return pspwdChange;
	}
	public void setPspwdChange(String pspwdChange) {
		this.pspwdChange = pspwdChange;
	}
	public String getSnpsRole() {
		return snpsRole;
	}
	public void setSnpsRole(String snpsRole) {
		this.snpsRole = snpsRole;
	}
	public Object getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(Object userPassword) {
		this.userPassword = userPassword;
	}
	public List<String> getIdRedesocial() {
		return idRedesocial;
	}
	public void setIdRedesocial(List<String> idRedesocial) {
		this.idRedesocial = idRedesocial;
	}
	public String getDocumentIdentifier() {
		return documentIdentifier;
	}
	public void setDocumentIdentifier(String documentIdentifier) {
		this.documentIdentifier = documentIdentifier;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Person [, fullName=" + fullName + ", lastName=" + lastName + ", description="
				+ description + ", idRedesocial=" + idRedesocial + ", documentIdentifier=" + documentIdentifier
				+ ", givenName=" + givenName + ", loginTimes=" + loginTimes + ", mail=" + mail
				+ ", organizationalStatus=" + organizationalStatus + ", psAdmissiondate=" + psAdmissiondate
				+ ", pspwdChange=" + pspwdChange + ", snpsRole=" + snpsRole + ", userPassword=" + userPassword + "]";
	}


	
}