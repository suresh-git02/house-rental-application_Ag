package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dtataprovider {

  @Test(dataProvider="data")
	public void newww(String ag, String og ,String boj)
	{
		System.out.println(ag+"  "+og+"" +boj+" ");
	}
	
	
	
	
	@DataProvider
	public Object[][] dataPro()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="owner";
		obj[0][1]="lavanya";
		obj[1][0]="mukesh";
		obj[1][1]="lata";
		return obj;
		
		
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[2][3];
		obj[0][0]="owner";
		obj[0][1]="lavanya";
		obj[0][2]="mukesh";
		
		obj[1][0]="lata";
		obj[1][1]="mukesh";
		obj[1][2]="lata";

		return obj;
		
		
	}
	
	
}
