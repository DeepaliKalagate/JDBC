package com.bridgelabz.prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class DBUtility 
{
	static Scanner sc=new Scanner(System.in);
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
		try
		{
			Connection con=getConnection();
			PreparedStatement create=(PreparedStatement) con.prepareStatement("CREATE TABLE register(username varchar(20),email varchar(20),password varchar(20));");
			create.executeUpdate();
			System.out.println("TABLE CREATED SUCCESSFULLY...");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertData()
	{
		try
		{
			Connection con=getConnection();
			PreparedStatement insert=(PreparedStatement) con.prepareStatement("insert into register values(?,?,?)");
			insert.setString(1,"Deepali");
			insert.setString(2, "lokesh@123");
			insert.setString(3,"pass123");
	
			int i=insert.executeUpdate();
			System.out.println( i  +  "Record Inserted Successfully");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	/**Updating a record in table using Statement Interface
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void isUpdate()
	{
		try
		{
			Connection con=getConnection();
			PreparedStatement st=(PreparedStatement) con.prepareStatement("update register set username=? where email=?");
		    st.setString(1, "Deepali");
            st.setString(2, "deepali@123");
		    int i=st.executeUpdate();
			System.out.println( i  +  "Record Updated  Successfully");
			//con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	/**
	 * delete record 
	 */
	public static void isDelete()
	{
		try
		{
			Connection con=getConnection();
			PreparedStatement st=(PreparedStatement) con.prepareStatement("delete from register where username=?");
           st.setString(1, "Deepali");
		    int i=st.executeUpdate();
			System.out.println( i   + "Record Deleted  Successfully");
			//con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	/**
	 * retrieve the records of a table
	 */
	public static void retrieve()
	{
		try
		{
			Connection con=getConnection();
			PreparedStatement st=(PreparedStatement) con.prepareStatement("select * from register");
			ResultSet rs=st.executeQuery();  
			
			while(rs.next())
			{  
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));  
			}  
		   
			System.out.println("Record Retrieved Successfully");
			//con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	/**
	 * Login Implemntation
	 * @param user
	 * @param pwd
	 */
	
	public static void loginUser(String user,String pwd)
	{
		try
		{
			    Connection con=getConnection();
				PreparedStatement st=(PreparedStatement) con.prepareStatement("select * from register where username=? and password=?" );
				st.setString(1, user);
				st.setString(2,pwd);
				ResultSet rs=st.executeQuery();
				int count=0;
				while(rs.next())
				{  
				//rs.getString(1)+" "+rs.getString(2); 
				count++;
				} 
				if(count>0)
				{			
				  System.out.println("Login Successfully");
				}
				else 
				{
					System.out.println("Username & Password Not Found ");
					int count1=0;
					while(count1>=0)
					{
					System.out.println("Do You Want To Register ");
					System.out.println("1. Yes  \n 2. No  \n 3.EXIT");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1: register(); break;
					case 2: System.out.println("Thank You "); count1=1; return;
					case 3: System.out.println("EXIT");  count1=1; return;
					default: System.out.println("wrong choice"); count1=1;return;
					}
					}
				}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void register()
	{
		try
		{	
			Connection con=getConnection();

			PreparedStatement st=(PreparedStatement) con.prepareStatement("insert into register values (?,?,?)");
			
			System.out.println("**Registration Form**");
		
		    System.out.println("Enter name:");
		    String username=sc.next();
		    System.out.println("Enter Email");
		    String email=sc.next();
		   // sc.next();
		    System.out.println("Enter password");
		    String password=sc.next();
		
			st.setString(1, username);
			st.setString(2, email);
			st.setString(3,password);
			
			st.executeUpdate();
			
			System.out.println(" Registration Successfully ..!");
			
			insertData();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}


