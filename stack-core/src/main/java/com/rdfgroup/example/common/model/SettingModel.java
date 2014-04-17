package com.rdfgroup.example.common.model;

public class SettingModel {

	private String UUID, name, value, description, id, environment;
	boolean oAuth;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public boolean isoAuth() {
		return oAuth;
	}

	public void setoAuth(boolean oAuth) {
		this.oAuth = oAuth;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	public String getUUID() {
		return UUID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
