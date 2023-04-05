package practicePackage;

import org.testng.annotations.Test;

public class Test_04 {
	@Test(groups="system")
	public void m7()
	{
	System.out.println("execute the test 7");	
	}
	@Test(groups= {"system","adhoc"})
	public void m8()
	{
	System.out.println("execute the test 8");	
	}
}
