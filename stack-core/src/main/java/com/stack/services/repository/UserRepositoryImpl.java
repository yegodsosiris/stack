package com.stack.services.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.stack.domain.User;
import com.stack.repository.BaseMongoRepositoryImpl;

@Repository
public class UserRepositoryImpl extends BaseMongoRepositoryImpl implements UserRepository {

	@Override
	public List<User> getUsers() {
		return list(User.class);
	}

	@Override
	public User getUser(String email) {
		return getByKeyValue(User.class, "email", email);
	}

	@Override
	public void createUser(User user) {
		saveOrUpdate(user);
	}

	@Override
	public void updateUser(User user) {
		user.setEmail(StringUtils.lowerCase(user.getEmail()));
		saveOrUpdate(user);
	}

	@Override
	public void deleteUser(String id) {
		findAndDelete(User.class, id);
	}

	@Override
	public User getUserById(String id) {
		return load(User.class, id);
	}


}