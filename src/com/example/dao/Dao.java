package com.example.dao;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.*;

public class Dao {

	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
}
