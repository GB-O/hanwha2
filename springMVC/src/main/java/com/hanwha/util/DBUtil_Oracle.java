package com.hanwha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil_Oracle {
	
	public static void dbClose(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs != null)rs.close();
			if(st != null)st.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
