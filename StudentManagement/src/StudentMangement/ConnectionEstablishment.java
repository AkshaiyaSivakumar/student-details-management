package StudentMangement;
import java.sql.*;
import java.sql.DriverManager;
public class ConnectionEstablishment 
{
		static Connection con=null;
		public static Connection getConnection()
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details_management", "root", "root");
			}
			catch(Exception c){
				System.out.println(c);
			}
			return con;
		}
}