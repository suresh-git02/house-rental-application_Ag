package practicePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		//create object for driver
		Driver driver=new Driver();
		//register the database
		DriverManager.registerDriver(driver);
		
		//get connection from database
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider","root","root");
		//create statement
		Statement state=con.createStatement();
		String s="select * from oar;";
		//execute query
	ResultSet	result=state.executeQuery(s);
//	while(result.next())
//	{
//		
//		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
//	}
		for(int i=1;result.next();i++) {
			
			System.out.println(result.getString(i)+" ");
		  }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{

			//close the database connection
		con.close();
		}
		
		
		
		
	}

}
