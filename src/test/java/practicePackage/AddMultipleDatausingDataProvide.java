package practicePackage;

import org.testng.annotations.Test;

import com.GenericUtilitys.ExcelUtility;

public class AddMultipleDatausingDataProvide {

	
	@Test(dataProviderClass=ExcelUtility.class,dataProvider="readMultipleSetUpData")
	public void readMultipleSetData(String a,String b,String c,String m) throws Throwable
	{
		
		System.out.println(a+"  "+b+" "+"   "+c+"  "+m+" ");
	
	}
}
