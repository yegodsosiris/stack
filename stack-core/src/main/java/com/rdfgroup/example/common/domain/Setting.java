package com.rdfgroup.example.common.domain;



import org.springframework.data.mongodb.core.mapping.Document;

import com.stack.domain.BaseMongoEntity;

@SuppressWarnings("serial")
@Document
public class Setting extends BaseMongoEntity  implements Comparable<Setting>{


	private String name, value, description, environment;
	
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
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
	@Override
	public int compareTo(Setting o) {
		return name.compareTo(o.getName());
	}
	
}
