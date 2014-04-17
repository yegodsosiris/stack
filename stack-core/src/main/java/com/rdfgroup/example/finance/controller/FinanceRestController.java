package com.rdfgroup.example.finance.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.rdfgroup.example.finance.domain.FinanceRecord;
import com.rdfgroup.example.finance.model.FinanceRecordModel;
import com.rdfgroup.example.finance.model.RecordsResponse;
import com.rdfgroup.example.finance.service.FinanceService;
import com.stack.controller.BaseMVCController;

/**
 * Handles requests for the users page.
 * 
 * NB: This class of Restful services will be deprecated when Access's Web Services become available
 */
@Controller
public class FinanceRestController extends BaseMVCController{
	
	FinanceService financeService;

	@Autowired
	public void setFinanceService(FinanceService financeService) {
		this.financeService = financeService;
	}
	
	@Autowired
	DozerBeanMapper mapper;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@RequestMapping(value = "/rest/records/produce", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody RecordsResponse getRecords() throws Exception {
		RecordsResponse rr = new RecordsResponse();
		List<FinanceRecord> records = financeService.getRecords();
		/*
		 * We don't send domain objects through REST services - that would be bad. Instead we have
		 * a dedicated public model for this purpose
		 */
		List<FinanceRecordModel> recordModels = new ArrayList<FinanceRecordModel>();
		for (FinanceRecord record : records) {
			recordModels.add(mapper.map(record, FinanceRecordModel.class));
		}
		rr.setRecords(recordModels);
		return rr;
	}
	
	// NB: /finance/ added to URL to protect it using Spring Security
	@RequestMapping(value="/rest/records/consume", method=RequestMethod.GET)
	public String consumeRecords(Model model) {

		RecordsResponse response = restTemplate.getForObject("http://localhost:8080/stack/rest/records/produce", RecordsResponse.class, "");
		model.addAttribute("records", response.getRecords());
		return "finance/records";
	}

	
}
