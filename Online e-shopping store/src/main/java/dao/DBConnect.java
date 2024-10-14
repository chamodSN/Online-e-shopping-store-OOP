package dao;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnect {
		
		private static String url = "jdbc:mysql://localhost:3306/test";
		private static String userName = "root";
		private static String password = "admin123";
		private static Connection con;
		
		public static Connection getConnection() {
			
			if(con == null) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection(url, userName, password);
					
				}catch(Exception e) {
					System.out.println("Database Connection is not Sucess");
				}
				
				return con;
			}else {
				return con;
				
			}
				
			}

}
