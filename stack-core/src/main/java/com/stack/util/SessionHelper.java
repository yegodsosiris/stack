package com.stack.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


@Component
public class SessionHelper {
	
	public Object getFromSession(HttpServletRequest request, String key){
	    return request.getSession().getAttribute(key);
	  }
	
	public void setInSession(HttpServletRequest request, String key, Object o){
	    request.getSession().setAttribute(key, o);
	  }
	
}
