package practicePackage;

import org.testng.annotations.Test;

public class test_annotation {
     @Test(priority=1,enabled=true)
	public void m1()
	{
		System.out.println("open the Database");
	}
     @Test(priority=2,dependsOnMethods="m1",enabled=true)

	public void m2()
	{
		System.out.println("lunch the browser");
	}
     @Test(priority=3,dependsOnMethods="m2",enabled=true)

	public void m3()
	{
		System.out.println("login the the application");
	}
     @Test(priority=4,dependsOnMethods="m3")

	public void m4()
	{
		System.out.println("test");
	}
     @Test(priority=5)

	public void m5()
	{
		System.out.println("logout");
	}
	
}
