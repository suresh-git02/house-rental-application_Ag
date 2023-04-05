package practicePackage;

import org.testng.annotations.Test;

public class Test_01 {

	@Test(groups="smoke")
	public void m1()
	{
	System.out.println("execute the test 1");	
	}
	@Test(groups="regrassion")
	public void m2()
	{
	System.out.println("execute the test 2");	
	}
}
