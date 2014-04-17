package com.stack.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Handles requests for the users page.
 */
@Controller
public class LoginController {


    @ModelAttribute("contextpath")
    public String setContextPath(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        return "/".equals(contextPath) ? "" : contextPath;
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "login";
	}

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public @ResponseBody Boolean logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return true;
    }
}
