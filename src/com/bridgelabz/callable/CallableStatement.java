package com.bridgelabz.callable;

import java.sql.Connection;
import java.sql.SQLException;

import com.bridgelabz.utility.ConnectionUtility;

public class CallableStatement 
{
	 static	Connection  connection=ConnectionUtility.getConnection();
		
		public static void main(String[] args) throws ClassNotFoundException
		{
			try
			{
			
				java.sql.CallableStatement st=connection.prepareCall("{call insertStud(?,?,?)}");
				st.setInt(1, 4);
				st.setString(2, "Aayush");
				st.setString(3, "Patil");
				st.execute();
				
				System.out.println("record inserted..");

				System.out.println();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
}
