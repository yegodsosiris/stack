package com.rdfgroup.example.admin.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rdfgroup.example.common.domain.Setting;
import com.rdfgroup.example.common.repository.ConfigRepository;

@Component
public class AdminServiceImpl implements AdminService { 

	
	@Autowired
	ConfigRepository configRepository;

	@Override
	public List<Setting> getSettings() {
		List<Setting> settings = configRepository.getSettings();  
		Collections.sort(settings);
		return settings;
	}
 
	@Override
	public Setting getSetting(String id) {
		return configRepository.getSetting(id);
	}

	@Override
	public void saveSetting(Setting setting) {
		configRepository.saveSetting(setting);
	}
	
	public void setConfigRepository(ConfigRepository configRepository) {
		this.configRepository = configRepository;
	}
	@Override
	public void deleteSetting(String id) {
		configRepository.deleteSetting(id);
	}


}
