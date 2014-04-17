package com.rdfgroup.example.finance.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfgroup.example.common.service.AuditService;
import com.rdfgroup.example.finance.domain.FinanceRecord;
import com.rdfgroup.example.finance.repository.FinanceRepository;
import com.stack.util.LogExecTime;


@Service
public class FinanceServiceImpl implements FinanceService {

	protected static final Log logger = LogFactory.getLog(FinanceServiceImpl.class);

	@Autowired
	FinanceRepository financeRepository;
	
	@Autowired
	AuditService auditService;


	@Override
	public FinanceRecord getRecord(String id) {
		auditService.info("Fetching "+id);
		return financeRepository.getRecord(id);
	}
	
	@Override
	@LogExecTime
	public List<FinanceRecord> getRecords() {
		return financeRepository.getRecords();
	}

	@Override
	public void saveRecord(FinanceRecord record) {
		financeRepository.saveRecord(record);
	}
	
	@Override
	public void deleteRecord(String id) {
		auditService.info("Deleteing "+id);
		financeRepository.deleteRecord(id);
	}
	
}
