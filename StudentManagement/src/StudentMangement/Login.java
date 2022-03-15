package StudentMangement;

import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.*;
import java.sql.Connection;

public class Login 
{
	ConnectionEstablishment ConnectionEstablishmentobj=new ConnectionEstablishment();
	Connection con=ConnectionEstablishment.getConnection();
	int login() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name:");
		String name=sc.next();
		System.out.println("Enter Password:");
		String password=sc.next();
		String sql="select f_name,password from faculty where f_name='"+name+"'and password='"+password+"'";
		Statement stmt=(Statement)con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		String str1="",str2="";
		while(rs.next())
		{
			str1=rs.getString(1);
			str2=rs.getString(2);
		}
		if(str1.equals(""))
		{
			System.out.println("LOGIN FAILED");
			return 0;
		}
		else
		{
			System.out.println("LOGIN SUCCESSFULL");
			return 1;
		}
		

	}

}
