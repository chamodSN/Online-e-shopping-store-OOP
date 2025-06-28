package com.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

import dao.DBConnect;

public class UserServicesDBUtil {
    
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stat = null;
    private static ResultSet rs = null;

    public static boolean validate(String loginUserName, String loginPassword) {
        isSuccess = false;

        try {
            con = DBConnect.getConnection();
            stat = con.createStatement();

            String sql = "SELECT password FROM users WHERE username = '" + loginUserName + "'";

            rs = stat.executeQuery(sql);

            if (rs.next()) {
                String hashedPassword = rs.getString("password");

                if (BCrypt.checkpw(loginPassword, hashedPassword)) {
                    isSuccess = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}
