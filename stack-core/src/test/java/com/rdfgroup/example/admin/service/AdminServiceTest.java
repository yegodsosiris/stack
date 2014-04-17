package com.rdfgroup.example.admin.service;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.rdfgroup.example.admin.service.AdminServiceImpl;
import com.rdfgroup.example.common.domain.Setting;
import com.rdfgroup.example.common.repository.ConfigRepository;
import com.rdfgroup.example.common.service.AuditService;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {

	AdminServiceImpl adminService;

	@Mock
	AuditService auditService;

	@Mock
	ConfigRepository configRepository;
	
	
	@Before()
	public void init() 
	{
		adminService = new AdminServiceImpl();
		adminService.setConfigRepository(configRepository);
	}

	
	
	@Test
	public void testGetSettings() 
	{
		List<Setting> jsp = adminService.getSettings();
		List<Setting> jsp2 = new ArrayList<Setting>();
		verify(configRepository , Mockito.atMost(1)).getSettings();
		Assert.assertEquals(jsp2, jsp);
		
		
	}
	
	@Test
	public void testGetSetting() 
	{
		String id ="123";
		Setting jsp2 = new Setting();
		
		doReturn(jsp2).when(configRepository).getSetting(id);
		
		Setting jsp = adminService.getSetting(id);
		
		verify(configRepository , Mockito.atMost(1)).getSetting(id);
		Assert.assertEquals(jsp2, jsp);
		
		
	}
	
	@Test
	public void testSaveSetting() 
	{
		final ArgumentCaptor<Setting> set = ArgumentCaptor.forClass(Setting.class);
		Setting setting = new Setting();
		adminService.saveSetting(setting);
		
		Setting jsp = new Setting();
		verify(configRepository , Mockito.atMost(1)).saveSetting(set.capture());
		jsp = set.getValue();
		Assert.assertEquals(setting, jsp);
	}
	
	@Test
	public void testDeleteSetting() 
	{
		final ArgumentCaptor<String> set = ArgumentCaptor.forClass(String.class);
		String id="123";
		adminService.deleteSetting(id);
		
		verify(configRepository , Mockito.atMost(1)).deleteSetting(set.capture());
		String jsp = set.getValue();
		Assert.assertEquals("123", jsp);
	}
	
}
