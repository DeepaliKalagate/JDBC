package com.bridgelabz.prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BatchProcessingCRUD 
{
	static Connection con = (Connection) DBBatch.getConnection(); // Method call for DB connection
	static PreparedStatement pstmt = null; // Create object of Prepare Statement

	public static void main(String[] args) throws SQLException 
	{

		int[] result = executeAll();	// function call to executes all Queries.
		for (int i = 0; i < result.length; i++) 
		{
			System.out.println(result[i]);
		}
		System.out.println("operation execute");
	}

	private static int[] executeAll() throws SQLException 
	{

		String query = "insert into studentinfo values (?,?,?)";

		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, 4);
		pstmt.setString(2, "Pratibha");
		pstmt.setString(3, "modi");
		pstmt.addBatch();

		pstmt.setInt(1, 5);
		pstmt.setString(2, "Punam");
		pstmt.setString(3, "Joshi");
		pstmt.addBatch();
		return pstmt.executeBatch();
	}
}

