package com.lcdd.backend;

import com.lcdd.backend.pojo.User;

public interface UserService {
	public Iterable<User>getAllUsers();
	public User getUserById(Long id) throws Exception;
	public User updateUser(User user) throws Exception;
}
