package RegistrationUsingTestNG;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilitys.BaseClass;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.UserRegistration;
import com.ObjectRepo.WelcomPage;

public class UserRegistrationss extends BaseClass {


	
	@Test
	public void  UserREG() throws Throwable
	{
	
	 WelcomPage wl=new WelcomPage(driver);
	 wl.logo();
	 wl.RegisterUser();

	 HashMap<String, String> map = eLib.readMultipleDataInExcel("Sheet3");

		Thread.sleep(2000);
	 UserRegistration user=new UserRegistration(driver);
		String userN = user.UserRegistrations(driver, map, jLib); 
		user.SubmitUsers();
		
		String Actual="Registration successfull. Now you can login";
String  expt=driver.findElement(By.xpath("//div[text()='Registration successfull. Now you can login']")).getText();

    SoftAssert as=new SoftAssert();
   
    as.assertEquals(Actual, expt);
//if(expt)
//{
//	 System.out.println("registar sucessfully");
//}
//else
//{
//	 System.out.println("not registar ");
//
//}
//System.out.println("done");

wl.loginclick();
LoginPage lng=new LoginPage(driver);
lng.loginPage(userN,eLib.readDataFromExcel("Sheet3", 4, 1));
wl.logo();
wl.home();	
	
	
	
	
}
}