package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
		static final String username = "System";
		static final String password = "pass";
		static final String sid = "xe";
		static final String server = "jdbc:oracle:thin:@localhost";
		static final String portno = "1521";
		static final String url = server + ":" + portno + ":" + sid;
		
		public static Connection getConnect() throws SQLException, ClassNotFoundException {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			return con;
			
		}

		public static void closeConnection(Connection con) throws SQLException {
				if(con != null) {
					con.close();
				}
		}
}
