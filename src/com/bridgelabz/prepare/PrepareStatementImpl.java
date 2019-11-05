package com.bridgelabz.prepare;

import java.sql.SQLException;

import com.bridgelabz.utility.Utility;

public class PrepareStatementImpl 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		System.out.println("--Welcome To JDBC--");
		System.out.println("Operation On table using PreparedStatemnt Interface");
		
		int count=0;
		
		while(count>=0)
		{
			System.out.println("1. CREATE TABLE");
			System.out.println("2. INSERT DATA INTO TABLE");
			System.out.println("3. UPDATE TABLE");
			System.out.println("4. DELETE DATA");
			System.out.println("5. RETRIEVE TABLE");
			System.out.println("6. EXIT");
			System.out.println("Enter Your Choice");
			int choice=Utility.isInteger();
			
			switch(choice)
			{
			case 1:
				DBUtility.createNewTable();
				break;
			
			case 2:
	            DBUtility.insertData();
	            break;
	            
			case 3:
				DBUtility.isUpdate();
				break;
			case 4:
				DBUtility.isDelete();
				break;
			
			case 5:
				DBUtility.retrieve();
				break;
				
			case 6:
				System.out.println("EXIT");
				count=1;
				return;
	            
			 default:
				 System.out.println("You Entered Wrong Choice ");
			     count=1;
			     return;
				
			}
		}	
		

	}

}
