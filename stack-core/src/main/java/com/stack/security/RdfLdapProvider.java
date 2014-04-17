package com.stack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;

public class RdfLdapProvider extends LdapAuthenticationProvider 
{

	public RdfLdapProvider(LdapAuthenticator authenticator) 
	{
		super(authenticator);

	}
	
	@Autowired
	LdapTemplate ldap;
	
	public void setLdapTemplate(LdapTemplate anLdap) 
	{
	      ldap = anLdap;
	      ldap.setContextSource(ldap.getContextSource());
	}
	

}
