package com.porto.login.social.sso.type;

import java.util.List;

public class PersonRequestType {
	
	private String documentIdentifier;
	private String idRedesocial;
	private String cpfCnpj;
	private String idApp;
	
	@Override
	public String toString() {
		return "PersonRequestType [documentIdentifier=" + documentIdentifier + ", idRedesocial=" + idRedesocial
				+ ", cpfCnpj=" + cpfCnpj + ", idApp=" + idApp + "]";
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getIdApp() {
		return idApp;
	}
	public void setIdApp(String idApp) {
		this.idApp = idApp;
	}
	public String getDocumentIdentifier() {
		return documentIdentifier;
	}
	public void setDocumentIdentifier(String documentIdentifier) {
		this.documentIdentifier = documentIdentifier;
	}
	public String getIdRedesocial() {
		return idRedesocial;
	}
	public void setIdRedesocial(String list) {
		this.idRedesocial = list;
	}
	
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((documentIdentifier == null) ? 0 : documentIdentifier.hashCode());
//		result = prime * result + ((idRedesocial == null) ? 0 : idRedesocial.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PersonRequestType other = (PersonRequestType) obj;
//		if (documentIdentifier == null) {
//			if (other.documentIdentifier != null)
//				return false;
//		} else if (!documentIdentifier.equals(other.documentIdentifier))
//			return false;
//		if (idRedesocial == null) {
//			if (other.idRedesocial != null)
//				return false;
//		} else if (!idRedesocial.equals(other.idRedesocial))
//			return false;
//		return true;
//	}
	
	
}
