package com.myConnect.Util;
import java.sql.*;


public class VeriTabaniUtil{
	
	static Connection conn=null;
	public static Connection Baglan() {
		
		try 
		{
		conn=DriverManager.getConnection("jdbc:mysql://localhost/myproducts","root","mysql");
		return conn;
		
		}
		
	catch (Exception e) {
		// TODO: handle exception
	
	System.out.println(e.getMessage().toString());
	return null;
	
	
	}
		
	}

}
	
	
	
