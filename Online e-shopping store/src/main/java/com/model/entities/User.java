package com.model.entities;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String profileImage;
	
	public User() {}
	
	public User(int userId, String userName, String password, String email, String profileImage) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.profileImage = profileImage;
	}
	
	public User(int userId, String userName, String email, String profileImage) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.profileImage = profileImage;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getProfileImage() {
		return profileImage;
	}


	
}
