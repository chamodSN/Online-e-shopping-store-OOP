package model;

public class user {
	private int user_id;
	private String userName;
	private String password;
	private String email;
	private String role;
	
	
	public user(int id, String userName, String password, String email, String role) {
		this.user_id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
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

	public String getRole() {
		return role;
	}


}
