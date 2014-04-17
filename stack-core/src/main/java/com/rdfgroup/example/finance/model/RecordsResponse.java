package com.rdfgroup.example.finance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecordsResponse implements Serializable{

	private static final long serialVersionUID = 1081698163936759509L;
	
	List<FinanceRecordModel> records = new ArrayList<FinanceRecordModel>();
	
	public void setRecords(List<FinanceRecordModel> records) {
		this.records = records;
	}
	
	public List<FinanceRecordModel> getRecords() {
		return records;
	}
}
