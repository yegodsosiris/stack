package com.stack.services.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.domain.Role;
import com.stack.domain.User;
import com.stack.security.PasswordEncoder;
import com.stack.services.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<User> getUsers() {
		List<User> users = userRepository.getUsers();
		Collections.sort(users);
		return users;
	}

	@Override
	public User getUserByUsernameAndPassord(String userName, String password) {
		User user = userRepository.getUser(userName);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public void createUser(User user) {
		userRepository.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		if (StringUtils.isBlank(user.getId())) {
			// If coming from a new user the id is set as a hidden field and
			// should remain null.
			user.setId(null);
			user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
		} else {
			if (StringUtils.isBlank(user.getPassword())) {
				User userById = userRepository.getUserById(user.getId());
				user.setPassword(userById.getPassword());
			}
			else {
				user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
			}
		}
		if (user.getRoles() == null) {
			throw new IllegalStateException("A Role must be set");
		}
		// It's a set so adding this if it already exists is fine.
		user.getRoles().add(Role.User);
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteUser(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUser(username);
	}

	@Override
	public User getUser(String id) {
		return userRepository.getUserById(id);
	}

}
