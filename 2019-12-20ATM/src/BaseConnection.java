package com;

import java.sql.*;

public class BaseConnection {
public static Connection getConnection(){
	Connection conn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
}

public static void CloseRes(ResultSet rs,PreparedStatement ps,Connection conn){
	try {
		if(rs!=null){
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void CloseRes(PreparedStatement ps,Connection conn){
	try {
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	Connection conn=BaseConnection.getConnection();
	System.out.println(conn);
	
}
}
