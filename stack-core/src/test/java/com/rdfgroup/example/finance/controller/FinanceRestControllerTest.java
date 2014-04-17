package com.rdfgroup.example.finance.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.rdfgroup.example.finance.controller.FinanceRestController;
import com.rdfgroup.example.finance.service.FinanceServiceImpl;

/**
 * @author billy.sneddon
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class FinanceRestControllerTest {
	
	FinanceRestController controller = new FinanceRestController();
	
	
	@Mock
	FinanceServiceImpl financeService;
	
	@Before
	public void init() {
		controller.setFinanceService(financeService);
		
	}
	
	@Test
	public void testGetAccessRecords() throws Exception 
	{
		controller.getRecords();
		Mockito.verify(financeService,Mockito.atMost(1)).getRecords();
	}
	
}
