package com.bridgelabz.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility
{
	
	private static String url="jdbc:mysql://localhost:3306/testdb";
	private static String username="root";
	private static String password="admin@123";
	private static Connection con=null;
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection(url,username,password);
			System.out.println("connected...");
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection()
	{
		return con;
		
	}

	
}