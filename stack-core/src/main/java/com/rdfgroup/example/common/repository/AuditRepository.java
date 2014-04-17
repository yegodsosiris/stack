package com.rdfgroup.example.common.repository;

import java.util.List;

import com.rdfgroup.example.common.domain.LogEntry;


public interface AuditRepository {

	List<LogEntry> getLogs();
	void info(String msg, String userName);
	void error(String msg, String userName);
	void warning(String msg, String userName);
	void clearLogs();
}
