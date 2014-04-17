package com.stack.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.stack.util.SecurityHelper;
import com.stack.util.SessionHelper;

/**
 * Handles requests for the users page.
 */
public abstract class BaseMVCController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	protected SessionHelper sessionHelper;
	
	@Autowired
	public
	SecurityHelper securityHelper;
	
	@ExceptionHandler (AccessDeniedException.class)
    @ResponseStatus (HttpStatus.TEMPORARY_REDIRECT)
    public ModelAndView handleAccessDeniedException(HttpServletRequest request, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access_denied");
		try {
			modelAndView.addObject("contextpath", setContextPath(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    logger.error("Exception in "+ex.getClass().getSimpleName(), ex);
	    return modelAndView;
    }
	
	@ExceptionHandler (Exception.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllExceptions(HttpServletRequest request, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("name", ex.getClass().getSimpleName());
		modelAndView.addObject("message", ex.getMessage());
		modelAndView.addObject("stack", ex.getStackTrace());
		try {
			modelAndView.addObject("contextpath", setContextPath(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    logger.error("Exception in "+ex.getClass().getSimpleName(), ex);
	    return modelAndView;
    }  

    @ModelAttribute("contextpath")
    public String setContextPath(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        return "/".equals(contextPath) ? "" : contextPath;
    }

	@ModelAttribute("loggedInUser")
	public String getLoggedInUser() {
		return securityHelper.getLoggedInUser();
	} 

}
