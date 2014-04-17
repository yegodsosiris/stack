package com.stack.services.repository;

import java.util.List;

import com.stack.domain.User;

public interface UserRepository {

	List<User> getUsers();

	User getUser(String email);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(String id);

	User getUserById(String id);

}
