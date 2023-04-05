package MyPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;




public class dbConnection {
public static void main(String[] args) throws Throwable {
		
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider", "root", "root");
	String a="select * from oar;";
	ResultSet result=con.createStatement().executeQuery(a);
	boolean b= false;
	while(result.next())
	{
		String ag=result.getString(1);
		System.out.println(ag);
		if(ag.equalsIgnoreCase("someone"))
		{
			b=true;
			break;
			
		}
	}
	if(b)	
	{
		System.out.println("updated");
	}
	else
	{
		System.out.println("not update");
	}
	
}
}
