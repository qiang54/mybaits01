package com.test.dao;

import java.util.List;

import com.test.pojo.User;

public interface UserDao {

	public User findUserById(Integer id);
	public List<User> findUserByName(String name);
}
