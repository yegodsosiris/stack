package com.rdfgroup.example.common.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfgroup.example.common.domain.LogEntry;
import com.rdfgroup.example.common.repository.AuditRepository;
import com.stack.util.SecurityHelper;

@Service
public class AuditServiceImpl implements AuditService {
	
	@Autowired
	AuditRepository auditRepository;
	
	@Autowired
	SecurityHelper securityHelper;

	@Override
	public List<LogEntry> getLogs() {
		List<LogEntry> status = auditRepository.getLogs();
		Collections.sort(status); 
		return status;
	} 

	@Override
	public void info(String msg) {
		auditRepository.info(msg, securityHelper.getLoggedInUser());
	}
	
	@Override
	public void clearLogs() {
		auditRepository.clearLogs();
	}

	@Override
	public void error(String msg) {
		auditRepository.error(msg, securityHelper.getLoggedInUser());
	}

	@Override
	public void warning(String msg) {
		auditRepository.warning(msg, securityHelper.getLoggedInUser());
	}
	
	public void setSecurityHelper(SecurityHelper securityHelper) {
		this.securityHelper = securityHelper;
	}
	
	public void setAuditRepository(AuditRepository auditRepository) {
		this.auditRepository = auditRepository;
	}
	
	
	

}
