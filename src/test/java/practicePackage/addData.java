package practicePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class addData {
public static void main(String[] args) throws SQLException {
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider","root","root");
	Statement state=con.createStatement();
	//add colum
	
//    String query=" alter table oar add(s_father varchar(20));";
//   state.executeUpdate(query);
	
	//drop colum
	
//    String query2="alter table oar drop column s_father;";
//   state.executeUpdate(query2);
	
	//insert colum
//	String query4="insert into oar values('someone',19,'odisha',143,76090276,'nursing');";
//	state.executeUpdate(query4);
	//update value
	String query5="update oar set s_name=abhi where s_name=owner;";
	state.executeUpdate(query5);
	
    System.out.println("done");
    con.close();
	
	
}
}
