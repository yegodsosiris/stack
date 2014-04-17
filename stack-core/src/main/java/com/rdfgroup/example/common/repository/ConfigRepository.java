package com.rdfgroup.example.common.repository;

import java.util.List;

import com.rdfgroup.example.common.domain.LogEntry;
import com.rdfgroup.example.common.domain.Setting;

public interface ConfigRepository {
	
	List<Setting> getSettings();
	
	Setting getSetting(String id);
	
	void saveSetting(Setting setting);
	
	public void deleteSetting(String id);

	int getMaxLogSize();

	void deleteLogEntry(LogEntry logEntry);
	
	
}
