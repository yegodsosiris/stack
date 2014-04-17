package com.rdfgroup.example.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stack.controller.BaseMVCController;

/**
 * Handles requests for the users page.
 */
@Controller
public class HomeController extends BaseMVCController {


    /**
     * Simply selects the home view to render by returning its name.
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	
}
