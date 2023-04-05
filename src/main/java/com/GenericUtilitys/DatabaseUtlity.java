package com.GenericUtilitys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtlity {

	
	Connection con=null;
	
	/**
	 * @author Suresh Biswal
	 * @throws Throwable
	 */
	public void ConnectToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DB_USERNAME,IpathConstants.DB_PASSWORD);
	}
	
	
	/**
	 * @author Suresh Biswal
	 * @param query
	 * @param columIndex
	 * @param ExpectData
	 * @return
	 * @throws Throwable
	 */
	public String ExecuteQueryAndGetData(String query,int columIndex,String ExpectData) throws Throwable
	{
	ResultSet result= con.createStatement().executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String data=result.getString(columIndex);
		if(data.equalsIgnoreCase(ExpectData))
		{
			flag=true;
			break;
		}
		
	}
	if(flag)
	{
		System.out.println("data is verifyed");
		return ExpectData;
	}
	else
	{
		System.out.println("not verified");
		return "";
	}
	
	}
	
	/**
	 * @author Suresh Biswal
	 * @throws Throwable
	 */
	public void CloseDB() throws Throwable
	{
		con.close();
		System.out.println("Database connection is Closed");
	}
}
