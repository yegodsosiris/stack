package com.rdfgroup.example.finance.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rdfgroup.example.finance.domain.FinanceRecord;
import com.stack.domain.BaseMongoEntity;
import com.stack.repository.BaseMongoRepositoryImpl;

@Repository
public class FinanceRepositoryImpl extends BaseMongoRepositoryImpl implements	FinanceRepository {



	@Override
	public FinanceRecord getRecord(String id) {
		return (FinanceRecord) get(FinanceRecord.class, id);
	}
	
	@Override
	public List<FinanceRecord> getRecords() {
		return list(FinanceRecord.class);
	}

	@Override
	public void saveRecord(FinanceRecord record) {
		saveOrUpdate(record);
	}
	
	@Override
	public void deleteRecord(String id) {
		BaseMongoEntity financeRecord = get(FinanceRecord.class, id);
		delete(financeRecord);
	}

}
