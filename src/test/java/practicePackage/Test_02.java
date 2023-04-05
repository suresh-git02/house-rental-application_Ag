package practicePackage;

import org.testng.annotations.Test;

public class Test_02 {

	@Test(groups="integration")
	public void m3()
	{
	System.out.println("execute the test 3");	
	}
	@Test(groups={"smoke","integration"})
	public void m4()
	{
	System.out.println("execute the test 4");	
	}
}
