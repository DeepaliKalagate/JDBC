package com.bridgelabz.utility;

import java.util.Scanner;

public class Utility 
{
	static Scanner scanner=new Scanner(System.in);
	public static int isInteger()
	{
		int integer=scanner.nextInt();
		return integer;
	}
	public static String isString()
	{
		String string=scanner.nextLine();
		return string;
	}
	public static long isLong()
	{
		long Long=scanner.nextLong();
		return Long;
	}
	public static double isDouble()
	{
		double Double=scanner.nextDouble();
		return Double;
	}
}
