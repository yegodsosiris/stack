package com.stack.services.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stack.domain.Role;
import com.stack.domain.User;
import com.stack.security.PasswordEncoder;
import com.stack.services.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    
    PasswordEncoder passwordEncoder = new PasswordEncoder();
    
    @Override public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Authenticating with user " + email);
        User user = userRepository.getUser(email);
        if (user == null) {
            throw new UsernameNotFoundException("Username was not found: " + email);
        }
        
        final List<String> roles = new ArrayList<String>();
        for(Role role : user.getRoles()) {
            // Spring roles need to start with "ROLE"
            roles.add("ROLE_" + role.toString());
        }
        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(roles.toArray(new String[0]));
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), auths);
    }

}
