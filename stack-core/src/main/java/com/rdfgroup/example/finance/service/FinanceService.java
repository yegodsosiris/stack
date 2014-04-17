package com.rdfgroup.example.finance.service;

import java.util.List;

import com.rdfgroup.example.finance.domain.FinanceRecord;



public interface FinanceService {

	FinanceRecord getRecord(String id);

	List<FinanceRecord> getRecords();

	void saveRecord(FinanceRecord record);
	
	void deleteRecord(String id);

}
