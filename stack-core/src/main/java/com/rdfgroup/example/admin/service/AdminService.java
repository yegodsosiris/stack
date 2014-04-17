package com.rdfgroup.example.admin.service;

import java.util.List;

import com.rdfgroup.example.common.domain.Setting;


public interface AdminService {
	

	List<Setting> getSettings();

	Setting getSetting(String id);

	void saveSetting(Setting setting);

	void deleteSetting(String id);

}
