package com.GenericUtilitys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
    /**
     * 
     * @return
     */
	public int random()
	{
		Random r=new Random();
		int ran=r.nextInt(10000);
		return ran;
		
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemTime()
	{
		Date dt=new Date();
		String date=dt.toString();
		return date;
		
	}
	/**
	 * 
	 * @return
	 */
	public String FormatSystemDate()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy  hh:mm:ss");
		Date dt=new Date();
		String getDateAndTime=dateformat.format(dt);
		getDateAndTime.replace(";","-");
		return getDateAndTime;
		
	}
}
