package com.bridgelabz.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementUtility
{
	/**Creating Connection
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws ClassNotFoundException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/testdb";// Uniform resource locator
			String user="root";//mysql user id
			String password="Admin@123";//mysql user password
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("Connected...");
			System.out.println();
			return con;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**Creating New Table in Database using Statement Interface
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void createNewTable() throws ClassNotFoundException
	{
		String sql="CREATE TABLE studentinfo(id int NOT NULL AUTO_INCREMENT primary key,firstname varchar(20),lastname varchar(20));";
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			st.execute(sql);
			System.out.println("Table Created Successfully\n");
			System.out.println();
			con.close();			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**Inserting a record in table using Statement Interface
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void insertData() throws ClassNotFoundException
	{
		String sql="INSERT INTO studentinfo(id,firstname,lastname)"
				+ "VALUES(2,'Deepali','Patil')";
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			int i=st.executeUpdate(sql);
			System.out.println("\n"+ i +"  Record Inserted Successfully\n");
			System.out.println();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**Updating a record in table using Statement Interface
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void updateData() throws ClassNotFoundException
	{
		String sql="UPDATE  studentinfo SET firstname='Guru' where id=3 ";
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			int i=st.executeUpdate(sql);
			System.out.println("\n"+ i+"  Record Updated Successfully\n");
			System.out.println();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**Deleting a record in table using Statement Interface
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void deleteData() throws ClassNotFoundException
	{
		String sql="DELETE FROM studentinfo where firstname='sarthak' ";
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			int i=st.executeUpdate(sql);
			System.out.println("\n"+ i+"  Record Deleted Successfully\n");
			System.out.println();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**Fetching Record from table using Statement Interface
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void showData() throws ClassNotFoundException
	{
		String sql="SELECT * FROM studentinfo";
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			System.out.println("\nRecord Retrived Successfully\n");
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
