package com.rdfgroup.example.common.service;

import java.util.List;

import com.rdfgroup.example.common.domain.LogEntry;

public interface AuditService {
	List<LogEntry> getLogs();
	void info(String msg);
	void error(String msg);
	void warning(String msg);
	void clearLogs();
}
