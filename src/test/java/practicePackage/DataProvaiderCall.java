package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilitys.ExcelUtility;

public class DataProvaiderCall {

	
	@Test(dataProviderClass=DataProviderUseingExcel.class,dataProvider="detaa",enabled=false)
	public void mental(String a,String b,String c,String m)
	{
		System.out.println(a+"  "+b+" "+"   "+c+"  "+m+" ");
	}
	
	
	
	@Test(dataProvider="detacall",enabled=true)
	
	public void readMultipleSetData(String a,String b,String c,String m) throws Throwable
	{
	{
		System.out.println(a+"  "+b+" "+"   "+c+"  "+m+" ");
	
	}
	
	
 
}
	@DataProvider
	public Object[][]  detacall() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.readMultipleSetUpData();
		return value;

	}
}