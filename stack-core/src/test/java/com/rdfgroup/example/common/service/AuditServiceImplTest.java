package com.rdfgroup.example.common.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.rdfgroup.example.common.repository.AuditRepositoryImpl;
import com.rdfgroup.example.common.service.AuditServiceImpl;
import com.stack.util.SecurityHelper;


@RunWith(MockitoJUnitRunner.class)
public class AuditServiceImplTest 
{
	public static String EDITED_BY ="billy";
	
	AuditServiceImpl auditService;
	
	@Mock
	SecurityHelper securityHelper;
	
	@Mock 
	AuditRepositoryImpl auditRepository;
	
	@Before
	public void init()
	{
		auditService = new AuditServiceImpl();
		auditService.setSecurityHelper(securityHelper);
		auditService.setAuditRepository(auditRepository);
	}
	
	@Test
	public void testGetLogs() 
	{
		Mockito.verify(auditRepository, Mockito.atMost(1)).getLogs();
		auditService.getLogs();
	}
	
	@Test
	public void testInfo() 
	{
		final ArgumentCaptor<String> log = ArgumentCaptor.forClass(String.class);
		doReturn(EDITED_BY).when(securityHelper).getLoggedInUser();
		String message ="test message";
		verify(auditRepository, Mockito.atMost(1)).info(message, EDITED_BY);
	
		auditService.info(message);
	}
	
	@Test
	public void testClearLogs() 
	{
		Mockito.verify(auditRepository, Mockito.atMost(1)).clearLogs();
		auditService.clearLogs();
	}
	
	@Test
	public void testWarn() 
	{
		String message ="test message";
		doReturn(EDITED_BY).when(securityHelper).getLoggedInUser();
		
		Mockito.verify(auditRepository, Mockito.atMost(1)).warning(message,EDITED_BY);
		auditService.warning(message);
	}
	
	@Test
	public void testError() 
	{
		String message ="test message";
		doReturn(EDITED_BY).when(securityHelper).getLoggedInUser();
		
		verify(auditRepository, Mockito.atMost(1)).error(message,EDITED_BY);
		auditService.error(message);
		
	}



}
