package com.stack.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Provides a ONE-WAY password encryption. Cannot be decoded!
 * 
 * @author dave.hampton
 *
 */
@Component
public class PasswordEncoder extends Md5PasswordEncoder
{

	public String encodePassword(String rawPass)
	{
		return super.encodePassword(rawPass, null);
	}

}
