package com.stack.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityHelper {
	public String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null) {
			return "";
		}
		Object principal = authentication.getPrincipal();
		if (principal instanceof String) {
			return (String)principal;
		}
		UserDetails userDetails =
				 (UserDetails)principal;
		return userDetails.getUsername();
	}
}
