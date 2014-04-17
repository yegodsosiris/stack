package com.rdfgroup.example.finance.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rdfgroup.example.finance.domain.Bank;
import com.rdfgroup.example.finance.domain.FinanceRecord;
import com.rdfgroup.example.finance.service.FinanceService;
import com.rdfgroup.example.finance.service.FinanceServiceImpl;
import com.stack.controller.BaseMVCController;

/**
 * Handles requests for the users page.
 */
@Controller
@Secured("ROLE_Finance")
public class FinanceController extends BaseMVCController {
	
	@Autowired
	FinanceService financeService;
	
	public void setFinanceService(FinanceServiceImpl financeService) {
		this.financeService=financeService;
	}

	
	@RequestMapping(value = "/finance/editRecord", method = RequestMethod.GET)
	public String editRecord(Model model, @RequestParam String id) throws Exception 
	{
		FinanceRecord record = financeService.getRecord(id);
		model.addAttribute("record", record);
		return "finance/record";
	}

	@RequestMapping(value = "/finance/newRecord", method = RequestMethod.GET)
	public String newRecord(Model model) throws Exception 
	{
		model.addAttribute("record", new FinanceRecord());
		return "finance/record";
	}

	@RequestMapping(value = "/finance/saveRecord", method = RequestMethod.POST)
	public String saveRecord(@ModelAttribute("record") FinanceRecord record) throws Exception 
	{
		financeService.saveRecord(record);
		return "redirect:records";
	}

	@RequestMapping(value = "/finance/deleteRecord", method = RequestMethod.GET)
	public String deleteRecord(@RequestParam String id) throws Exception 
	{
		financeService.deleteRecord(id);
		return "redirect:records";
	}

	@RequestMapping(value = "/finance/records", method = {RequestMethod.GET, RequestMethod.POST})
	public String records(Model model)
	{
		model.addAttribute("records", financeService.getRecords());
		return "finance/records";
	}
	
	@ModelAttribute("banks")
	public Map<String,String> populateRoles() {
		
		//Data referencing for java skills list box
		Map<String,String> types = new LinkedHashMap<String,String>();
		Bank[] values = Bank.values();
		for (Bank bank : values) {
			types.put(bank.name(), bank.name());
		}
		return types;
	}
	
	
	
}
