package com.rdfgroup.example.finance.controller;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.rdfgroup.example.finance.controller.FinanceController;
import com.rdfgroup.example.finance.service.FinanceServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class FinanceControllerTest 
{

 FinanceController financeController;
	
 
 @Mock
 FinanceServiceImpl financeService;
 
 	@Before
	public void init() 
 	{
	 	financeController = new FinanceController();
	 	financeController.setFinanceService(financeService); 
 	}
 	
 	@Test
 	public void emptyTest() {
 		Assert.assertTrue(true);
 	}
 

}
