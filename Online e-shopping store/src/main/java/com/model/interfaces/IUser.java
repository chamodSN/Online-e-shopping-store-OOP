package com.model.interfaces;

import java.util.List;

import com.model.entities.User;

public interface IUser {

	public boolean insertUser(String userName, String password, String email, String image);

	public boolean updateUser(String id, String userName, String password, String email);
	
	public List<User> getUserDetails(String uName);
	
	public boolean deleteUser(String id);
	

}
