package com.bridgelabz.statement;

import com.bridgelabz.utility.Utility;

public class OperationOnTable 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		System.out.println("**************Welcome to JDBC***************");
		System.out.println("Performing operations on Table using Statement Interface....");
		for(int i=0;i<4;i++)
		{
			System.out.println("1.CREATE NEW TABLE");
			System.out.println("2.INSERT A RECORD IN TABLE");
			System.out.println("3.UPDATE RECORD FROM TABLE");
			System.out.println("4.DELETE RECORD FROM TABLE");
			System.out.println("5.VIEW RECORDS FROM TABLE");
			System.out.println("6.EXIT");
			int choice=Utility.isInteger();
			switch(choice)
			{
			case 1:
				StatementUtility.createNewTable();
				break;
			case 2:
				StatementUtility.insertData();
				break;
			case 3:
				StatementUtility.updateData();
				break;
			case 4:
				StatementUtility.deleteData();
				break;
			case 5:
				StatementUtility.showData();
				break;
			case 6:
				System.out.println("EXITED");
				break;
			default:
				System.out.println("You Entered Wrong Choice!");
				break;
			}
		}
	}
}
