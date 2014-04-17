package com.rdfgroup.example.common.domain;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import com.stack.domain.BaseMongoEntity;

@Document
public class LogEntry extends BaseMongoEntity implements Comparable<LogEntry> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7076027467622761740L;
	private String message, level, date;
	private String userName;

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		date = new DateTime().toString("dd/MM/yyyy hh:mm:ss");
		message = msg;
	}

	@Override
	public int compareTo(LogEntry o) {
		return getCreated().compareTo(o.getCreated());
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	public String getUserName() {
		return userName;
	}
}
