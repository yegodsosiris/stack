package com.rdfgroup.example.finance.repository;

import java.util.List;

import com.rdfgroup.example.finance.domain.FinanceRecord;


public interface FinanceRepository {

	
	FinanceRecord getRecord(String id);

	List<FinanceRecord> getRecords();

	void saveRecord(FinanceRecord record);
	
	void deleteRecord(String id);
}
