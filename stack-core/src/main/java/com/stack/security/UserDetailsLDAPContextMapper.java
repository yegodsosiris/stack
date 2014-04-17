package com.stack.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.stereotype.Component;

import com.stack.domain.Role;
import com.stack.services.repository.UserRepository;

@Component
public class UserDetailsLDAPContextMapper implements UserDetailsContextMapper 
{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authority) {

        List<GrantedAuthority> mappedAuthorities = new ArrayList<GrantedAuthority>();
        
        com.stack.domain.User user = userRepository.getUser(username);
        if (user != null) {
	        Set<Role> roles = user.getRoles();
	        for (final Role role : roles) {
	        	mappedAuthorities.add(new GrantedAuthority(){
	                private static final long serialVersionUID = 4356967414267942910L;
	
	                @Override
	                public String getAuthority() {
	                    return "ROLE_"+role.name();
	                } 
	
	            });
			}
        }

        return new User(username, "", true, true, true, true, mappedAuthorities);
    }

    @Override
    public void mapUserToContext(UserDetails arg0, DirContextAdapter arg1) {
    }

}
