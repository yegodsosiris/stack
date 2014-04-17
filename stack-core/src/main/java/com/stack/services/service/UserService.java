package com.stack.services.service;

import java.util.List;

import com.stack.domain.User;

public interface UserService {

	List<User> getUsers();

	User getUserByUsernameAndPassord(String userName, String password);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(String id);

    User getUserByUsername(String username);

    User getUser(String id);

}
