package com.bridgelabz.prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBBatch 
{
	
	static String url="jdbc:mysql://localhost:3306/testdb";
	static String user = "root"; // mysql user id
	static String pass = "Admin@123"; // mysql user password
	static Connection con = null;
	
	public static Connection getConnection()
	{ // connection method
		try 
		{
			// Load & Register Drivers.
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection(url, user, pass); // Establish the connection
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return con; // return connection
	}	
}
