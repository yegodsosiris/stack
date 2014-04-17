package com.rdfgroup.example.common.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rdfgroup.example.common.domain.LogEntry;
import com.rdfgroup.example.common.domain.Setting;
import com.stack.repository.BaseMongoRepositoryImpl;

@Repository
public class ConfigRepositoryImpl extends BaseMongoRepositoryImpl implements ConfigRepository {
	
	@Autowired
	AuditRepository auditRepository;
	
	public String getValue(String name) {
		Setting byKeyValue = getByKeyValue(Setting.class, "name", name);
		if (byKeyValue==null) {
			auditRepository.error("unable to locate "+name, "SYSTEM");
			return "";
		}
		return byKeyValue.getValue();
	}
	

	@Override
	public List<Setting> getSettings() {
		List<Setting> list = list(Setting.class);
		return list;
	}

	@Override
	public Setting getSetting(String id) {
		return load(Setting.class, id);
	}

	@Override
	public void saveSetting(Setting setting) {
		saveOrUpdate(setting);
	}


	@Override
	public void deleteSetting(String id) {
		findAndDelete(Setting.class, id);
	}

	@Override
	public int getMaxLogSize() {
		String value = getValue("max.log.size");
		if(StringUtils.isBlank(value)) {
			return 50;
		}
		return Integer.valueOf(value);
	}

	@Override
	public void deleteLogEntry(LogEntry logEntry) {
		delete(logEntry);
	}


}
