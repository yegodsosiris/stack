package com.stack.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.stack.util.JacksonHelper;

@SuppressWarnings("serial")
public abstract class BaseMongoEntity implements Serializable{

	@Id
	protected String id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	protected Date created;

	protected Date updated;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return JacksonHelper.convertToJSON(this);
	}

	public boolean isPersisted() {
		return id!=null;
	}
	
}
