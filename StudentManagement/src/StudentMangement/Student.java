package StudentMangement;

import java.util.*;
import java.sql.*;
public class Student
{
	private int s_rollNo;
    private String s_name;
    private String b_id;
    private String d_id;
    private String dob;
    private String gender;
    private int age;
    private String blood_group;
    private Double phone_number;
    private String address;
   
    
    @SuppressWarnings("resource")
	public void getStudentDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Student RollNo:");
        s_rollNo = input.nextInt();
        System.out.println("Enter Student Name:");
        s_name = input.next();
        System.out.println("Enter the Batch Id:");
        b_id = input.next();
        System.out.println("Enter the Department Id:");
        d_id= input.next();
        System.out.println("Enter the student D.O.B:");
        dob= input.next();
        System.out.println("Enter the student Gender :");
        gender= input.next();
        System.out.println("Enter the Student age:");
        age= input.nextInt();
        System.out.println("Enter the Blood group of the student:");
        blood_group= input.next();
        System.out.println("Enter student phone number:");
        phone_number= input.nextDouble();
        System.out.println("Enter student address:");
        address= input.next();
    }
    
    @SuppressWarnings("static-access")
	public void insertStudent() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        //here we are going to work with a database
        //we need to open a database connection
    	ConnectionEstablishment ConnectionEstablishmentobj=new ConnectionEstablishment();
    	Connection con=ConnectionEstablishmentobj.getConnection();
        String sql = "insert into student_details values (?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1,s_rollNo);
        stmt.setString(2, s_name);
        stmt.setString(3, b_id);
        stmt.setString(4, d_id);
        stmt.setString(5, dob);
        stmt.setString(6, gender);
        stmt.setInt(7, age);
        stmt.setString(8, blood_group);
        stmt.setDouble(9, phone_number);
        stmt.setString(10, address);
        int i = stmt.executeUpdate();
        System.out.println("Record  inserted successfully");
       
    }
    
    @SuppressWarnings("static-access")
	public void updateStudentPassword() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    	ConnectionEstablishment ConnectionEstablishmentobj=new ConnectionEstablishment();
    	Connection con=ConnectionEstablishmentobj.getConnection();
        System.out.println("Enter student rollNo to update:");
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        int inputrollNo=input.nextInt();
        System.out.println("Select an operation \n 1- student_name \n 2- Password Update \n 3- Delete a Record \n 4- Search for a Student \n 5- Exit");
        int choice=input.nextInt();
        switch(choice)
        {
            case 1:
            	System.out.println("Enter student name to update:");
            	String inputname=input.next();
            	String sql = "update student_details set s_name = ? where s_rollNo = ?;";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, inputname);
                stmt.setInt(2, inputrollNo);
                int i = stmt.executeUpdate();
                if(i>0)
                {
                    System.out.println("Record updated sucessfully");
                }else
                {
                    System.out.println("No Such record in the Database");
                }
               
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
               
                break;
            case 5:
                break;
            default:
                System.out.println("Select the correct choice");
        }
        
    }


@SuppressWarnings("static-access")
public void deleteStudentRecord() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	ConnectionEstablishment ConnectionEstablishmentobj=new ConnectionEstablishment();
	Connection con=ConnectionEstablishmentobj.getConnection();
    System.out.println("Enter the rollNo of the Student");
    @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
    int inputrollNo=input.nextInt();
    String sql = "delete from student_details where s_rollNo = ?;";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setInt(1, inputrollNo);
    int i = stmt.executeUpdate();
    if(i>0)
    {
        System.out.println("Record Deleted Successfully");
    }
    else
    {
        System.out.println("No Such Record in the Database");
    }
   
}

@SuppressWarnings("static-access")
public void searchStudent() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	ConnectionEstablishment ConnectionEstablishmentobj=new ConnectionEstablishment();
	Connection con=ConnectionEstablishmentobj.getConnection();
    System.out.println("Enter student RollNo");
    @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
    int inputrollNo=input.nextInt();
    String sql = "select * from student_details where s_rollNo=?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setInt(1, inputrollNo);
    ResultSet rs = stmt.executeQuery();
    if(rs.next()==false)
    {
        System.out.println("No such record found in the database");
    }
    else
    {    
    	String rollNo = rs.getString("s_rollNo");
	 	String student_name = rs.getString("s_name");
        System.out.println(rollNo + "\n" + student_name);
        //System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getString(7)+rs.getString(8)+rs.getString(9)+rs.getString(10));
        
    }
}
public void selectAll() throws SQLException
{
	ConnectionEstablishment ConnectionEstablishmentobj=new ConnectionEstablishment();
	Connection con=ConnectionEstablishmentobj.getConnection();
	 String sql = "select * from student_details";
	 PreparedStatement stmt = con.prepareStatement(sql);
	 ResultSet rs = stmt.executeQuery();
	 while (rs.next()) {
		 	String rollNo = rs.getString("s_rollNo");
		 	String student_name = rs.getString("s_name");
	        System.out.println(rollNo + "," + student_name);
	        
	      }
	
}

}
