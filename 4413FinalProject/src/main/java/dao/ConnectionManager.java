package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	static String DB_SERVER;
	static String DB_PORT;
	static String DB_NAME;
	static String DB_USERID;
	static String DB_PASSWORD;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Failed to load DB driver");
		}
		DB_SERVER = System.getenv("DB_SERVER");
		DB_PORT = System.getenv("DB_PORT");
		DB_NAME = System.getenv("DB_NAME");
		DB_USERID = System.getenv("DB_USERID");
		DB_PASSWORD = System.getenv("DB_PASSWORD");
	}

	public static Connection getConnection() {

		try {
			// jdbc:mysql://localhost:3306/eStore?allowPublicKeyRetrieval=true&useSSL=false
			String dbUrl = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false", DB_SERVER, DB_PORT, DB_NAME);
			Connection con = DriverManager.getConnection(dbUrl, DB_USERID, DB_PASSWORD);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
