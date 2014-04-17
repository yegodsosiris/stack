package com.rdfgroup.example.common.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rdfgroup.example.common.domain.LogEntry;
import com.stack.repository.BaseMongoRepositoryImpl;

@Repository
public class AuditRepositoryImpl extends BaseMongoRepositoryImpl implements	AuditRepository {
	
	@Override
	public void info(String msg, String userName) {
		log(msg, "info", userName);
	}

	private void log(String msg, String info, String userName) {
		LogEntry status = new LogEntry();
		status.setLevel(info);
		status.setMessage(msg);
		status.setUserName(userName);
		saveOrUpdate(status);
	}

	@Override
	public List<LogEntry> getLogs() {
		return list(LogEntry.class);
	}

	@Override
	public void clearLogs() {
		mongoTemplate.dropCollection(LogEntry.class);
	}

	@Override
	public void error(String msg, String userName) {
		log(msg, "error", userName);
	}

	@Override
	public void warning(String msg, String userName) {
		log(msg, "warning", userName);
	}

}
