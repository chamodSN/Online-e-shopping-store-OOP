package com.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.DBConnect;

public class UserServicesDBUtil{
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;

	
	public static boolean validate(String loginUserName, String loginPassword) {

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM users WHERE username = '" + loginUserName + "' AND password = '" + loginPassword
					+ "'";

			rs = stat.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

}
