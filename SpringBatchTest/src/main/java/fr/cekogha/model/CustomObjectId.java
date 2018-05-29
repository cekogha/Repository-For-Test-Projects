package fr.cekogha.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomObjectId {

	@JsonProperty("$oid")
	private String oid;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
}
