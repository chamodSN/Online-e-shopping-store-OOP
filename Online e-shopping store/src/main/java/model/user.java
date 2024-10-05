package model;

public class user {
	private int user_id;
	private String userName;
	private String password;
	private String email;
	private String profile_image;
	
	
	public user(int id, String userName, String password, String email, String profile_image) {
		this.user_id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.profile_image = profile_image;
	}


	public int getUser_id() {
		return user_id;
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

	public String getProfile_image() {
		return profile_image;
	}
	

}
