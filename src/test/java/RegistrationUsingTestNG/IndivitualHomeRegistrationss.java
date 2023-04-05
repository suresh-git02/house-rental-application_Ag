package RegistrationUsingTestNG;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtilitys.BaseClass;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.IndivitualHomeRegistration;


public class IndivitualHomeRegistrationss extends BaseClass {

	@Test
	public void indivisualRoom() throws Throwable
	{
		HomePage hm=new HomePage(driver);
		hm.RegisterClick();
		IndivitualHomeRegistration reg=new IndivitualHomeRegistration(driver);
	
		HashMap<String, String> map = eLib.readMultipleDataInExcel("Sheet1");
		reg.RegisterHome(driver, map, jLib);
		reg.RIsubmit();
		WebElement Expected=driver.findElement(By.xpath("//div[text()='Registration successfull. Thank you']"));
		wLib.elementTObeVisible(driver,Expected , 10);
		
	     if(Expected.isDisplayed())
	     {
	    	 System.out.println("registar sucessfully");
	     }
	     else
	     {
	    	 System.out.println("not registar ");

	     }
	    System.out.println("done");

	
		}
	
}
