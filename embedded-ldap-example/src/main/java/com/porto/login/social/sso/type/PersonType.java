package com.porto.login.social.sso.type;

import java.util.List;

public class PersonType {
	
	private String documentIdentifier;
	private List<String> idRedesocial;
	
	public String getDocumentIdentifier() {
		return documentIdentifier;
	}
	public void setDocumentIdentifier(String documentIdentifier) {
		this.documentIdentifier = documentIdentifier;
	}
	public List<String> getIdRedesocial() {
		return idRedesocial;
	}
	public void setIdRedesocial(List<String> list) {
		this.idRedesocial = list;
	}
	@Override
	public String toString() {
		return "PersonType [documentIdentifier=" + documentIdentifier + ", idRedesocial=" + idRedesocial + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentIdentifier == null) ? 0 : documentIdentifier.hashCode());
		result = prime * result + ((idRedesocial == null) ? 0 : idRedesocial.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonType other = (PersonType) obj;
		if (documentIdentifier == null) {
			if (other.documentIdentifier != null)
				return false;
		} else if (!documentIdentifier.equals(other.documentIdentifier))
			return false;
		if (idRedesocial == null) {
			if (other.idRedesocial != null)
				return false;
		} else if (!idRedesocial.equals(other.idRedesocial))
			return false;
		return true;
	}
	
	
}
