package practicePackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectedQuery {
public static void main(String[] args) throws Throwable {
	Connection con=null;
	int result=0;
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider","root","root");
	Statement state=con.createStatement();
	String s="update oar set s_name='bihar' whe s_from='owner';";
	result=state.executeUpdate(s);
	
	}
	catch(Exception e)
	{
		
	}
	finally {
		
	}
	if(result==1)
	{
		System.out.println("data updated");
	}
	else
	{
		System.err.println("data not updated");
	}
	con.close();
}	

	
}

