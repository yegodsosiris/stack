package com.rdfgroup.example.admin.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.rdfgroup.example.admin.controller.AdminController;
import com.rdfgroup.example.admin.service.AdminServiceImpl;
import com.rdfgroup.example.common.domain.LogEntry;
import com.rdfgroup.example.common.domain.Setting;
import com.rdfgroup.example.common.model.SettingModel;
import com.rdfgroup.example.common.repository.AuditRepository;
import com.rdfgroup.example.common.repository.ConfigRepositoryImpl;
import com.rdfgroup.example.common.service.AuditServiceImpl;
import com.stack.domain.Role;
import com.stack.domain.User;
import com.stack.services.service.UserServiceImpl;
import com.stack.util.SecurityHelper;


@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest 
{

	AdminController adminController;
	
	@Mock
	AdminServiceImpl adminService;

	@Mock
	AuditServiceImpl auditService;

	@Mock
	UserServiceImpl userService;
	
	@Mock
	ConfigRepositoryImpl configRepository;
	
	@Mock
	AuditRepository auditRepository;
	
	@Mock
	SecurityHelper securityHelper;

	
	@Before
	public void init() 
 	{
	 	adminController = new AdminController();
	 	adminController.setAdminService(adminService);
	 	adminController.setAuditService(auditService);
	 	adminController.setUserService(userService);
	 	adminController.setMapper(new DozerBeanMapper());
	
	 	adminService.setConfigRepository(configRepository);
	 	
	 	auditService.setAuditRepository(auditRepository);
	 	auditService.setSecurityHelper(securityHelper);
 	}


	
	@Test
	public void saveSettingWithNoIDTest()
	{
		final ArgumentCaptor<Setting> settings = ArgumentCaptor.forClass(Setting.class);
		SettingModel s = new SettingModel();
		/*s.setCreated(a.getCreated());
		s.setDescription("this is a test settings description");
		s.setId(a.getId());
		s.setName("billy");
		s.setUpdated(a.getUpdated());
		s.setValue("what is the value");*/
		
		String jsp = adminController.saveSetting(s,null);
		Mockito.verify(adminService).saveSetting(settings.capture());
		
		Setting st = settings.getValue();
		Assert.assertEquals(null, st.getId());
		Assert.assertEquals("redirect:settings", jsp);
		
	
	
		
	}

	
	
	@Test
	public void saveUserTest()
	{
		final ArgumentCaptor<User> saveUser = ArgumentCaptor.forClass(User.class);
		final ArgumentCaptor<String> log = ArgumentCaptor.forClass(String.class);
		User user1 = new User();
		user1.setCreated(new Date());
		user1.setEmail("testing@rdfgroup.com");
		user1.setFirstname("Billy");
		user1.setId("123");
		user1.setPassword("testpassword");
		Set<Role> roles = new HashSet<Role>();
		 roles.add(Role.Admin);
		 roles.add(Role.Finance);
		user1.setRoles(roles);
		user1.setSurname("Sneddon");
		user1.setUpdated(new Date());
		
		String jsp = adminController.saveUser(user1,null);
		
		verify(userService, times(1)).updateUser(saveUser.capture());
		
		Assert.assertEquals(saveUser.getValue().getEmail(), user1.getEmail());
		
		verify(auditService, Mockito.atMost(1)).info(log.capture());
		String value = log.getValue();
		String oneway = "Finance, Admin";
		String anotherway = "Admin, Finance";
		String f = value.contains(oneway) ? oneway : anotherway;
 
		Assert.assertEquals("User testing@rdfgroup.com saved/updated with roles ["+f+"]", value);               
		Assert.assertEquals("redirect:users", jsp);
		
	}  
	
	
	
	
	@Test
	public void newUserTest()
	{
		final ArgumentCaptor<String> log = ArgumentCaptor.forClass(String.class);
		
		//Creating a Mock user
		User user = new User();
		user.setCreated(new Date());
		user.setEmail("testing@rdfgroup.com");
		user.setFirstname("Billy");
		user.setId("123");
		user.setPassword("testpassword"); 
		user.setSurname("Sneddon");
		user.setUpdated(new Date());
		//user.getRoles().add(Role.User);
		
		Model m = new ExtendedModelMap();
		String jsp = adminController.newUser(m); 
		
		//Map<String, Object> asMap = m.asMap();
		//Object j = asMap.get("jobs");
		//Assert.assertEquals(user, j); 
		verify(auditService, Mockito.atMost(1)).info(log.capture());
		String value = log.getValue();
		Assert.assertEquals("Creating a new user", value);
		Assert.assertEquals("admin/user", jsp);
		
	}
	
	
	@Test
	public void deleteUserTest()
	{
		final ArgumentCaptor<String> log = ArgumentCaptor.forClass(String.class);
		User user = new User();
		user.setCreated(new Date());
		user.setEmail("testing@rdfgroup.com");
		user.setFirstname("Billy");
		user.setId("123");
		user.setPassword("testpassword");
		Set<Role> roles = new HashSet<Role>();
			roles.add(Role.Admin);
			roles.add(Role.Finance);
		user.setRoles(roles);
		user.setSurname("Sneddon");
		user.setUpdated(new Date());
	

		doReturn(user).when(userService).getUser("123");
	
		String jsp = adminController.deleteUser("123");
	
		verify(userService, times(1)).deleteUser("123"); 
		verify(auditService, Mockito.atMost(1)).info(log.capture());
		String value = log.getValue();
		Assert.assertEquals("User testing@rdfgroup.com deleted", value);               
		Assert.assertEquals("redirect:users", jsp);
	
	}
	
	@Test
	public void testSettings()
	{
		Model m = new ExtendedModelMap();
		String jsp = adminController.settings(m);
		verify(adminService, Mockito.atMost(1)).getSetting(anyString());
		Assert.assertEquals("admin/settings", jsp);
	}
	
	@Test
	public void testGetSettings()
	{
		String jsp = adminController.settings(new ExtendedModelMap());
		verify(adminService, Mockito.atMost(1)).getSettings();
		Assert.assertEquals("admin/settings", jsp);
	}
	
	@Test
	public void testDeleteSettings()
	{
		final ArgumentCaptor<String> log = ArgumentCaptor.forClass(String.class);
		Setting setting = new Setting();
		setting.setName("Billy");
		setting.setId("123");
		doReturn(setting).when(adminService).getSetting("123");
		
		Model m = new ExtendedModelMap();
		String jsp = adminController.deleteSetting("123",m);
		
		verify(adminService, Mockito.atMost(1)).deleteSetting("123");
		
		verify(auditService, Mockito.atMost(1)).info(log.capture());
		String value = log.getValue();
		Assert.assertEquals("SettingModel Billy deleted", value);  
		Assert.assertEquals("redirect:settings", jsp);
	}
	
	@Test
	public void testNewSettings()
	{
		Model m = new ExtendedModelMap();
		String jsp = adminController.newSettings(m);
		Assert.assertEquals("admin/setting", jsp);//TODO chech model contents
	}
	
	@Test
	public void testGetJobStatus()
	{
		List<LogEntry> logs = new ArrayList<LogEntry>();
		LogEntry le = new LogEntry();
		le.setId("456");
		logs.add(le);
		Model m = new ExtendedModelMap();
		
		doReturn(logs).when(auditService).getLogs();
		String jsp = adminController.getJobStatus(m);
		Assert.assertEquals("admin/logs", jsp);//TODO chech model contents
	}
	
	@Test
	public void testClearTaskStatus()
	{
		final ArgumentCaptor<String> log = ArgumentCaptor.forClass(String.class);
		Model m = new ExtendedModelMap();
	
		String jsp = adminController.clearTaskStatus(m);
		 
		verify(auditService, Mockito.atMost(1)).clearLogs();
		verify(auditService, Mockito.atMost(1)).info(log.capture());
		String value = log.getValue();
		Assert.assertEquals("Logs have been cleared", value);
		Assert.assertEquals("redirect:logs", jsp);//TODO chech model contents
	}
	
	@Test
	public void testGetUser()
	{
		User user = new User();
		user.setId("123");
	
		Model m = new ExtendedModelMap();
		doReturn(user).when(userService).getUser("123");
		String jsp = adminController.getUser("123", m);
		verify(userService, Mockito.atMost(1)).getUser("123");
		Assert.assertEquals("admin/user", jsp);//TODO chech model contents
	}
	
	@Test
	public void testGetUsers()
	{
		Model m = new ExtendedModelMap();
		String jsp = adminController.getUsers(m);
		 
		verify(userService, Mockito.atMost(1)).getUsers();
		Assert.assertEquals("admin/users", jsp);//TODO chech model contents
	}
	
}
