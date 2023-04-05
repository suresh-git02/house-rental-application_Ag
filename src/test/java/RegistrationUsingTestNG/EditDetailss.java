package RegistrationUsingTestNG;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilitys.BaseClass;
import com.ObjectRepo.Details_Update_page;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.IndivitualHomeRegistration;
//@Listeners(com.GenericUtilitys.ListenerImPlementation.class)
public class EditDetailss extends BaseClass{

	
	@Test(retryAnalyzer = com.GenericUtilitys.RetryImpClass.class)
	public void editDetails() throws Throwable
	{
		HomePage home=new HomePage(driver);
		home.RegisterClick();
		//read the multipledata in ExcelSheet
		HashMap<String, String> map = eLib.readMultipleDataInExcel("sheet1");
		
		IndivitualHomeRegistration InHome= new IndivitualHomeRegistration(driver);
		String name2=InHome.RegisterHome(driver, map, jLib);
		System.out.println(name2);
		 wLib.select(InHome.getVacant(),1);
		 InHome.RIsubmit();
		 home.DetailsClick();
		 Details_Update_page dtl=new Details_Update_page(driver);
		 dtl.Edit(name2, driver);

		 InHome.getCity().clear();
		 Thread.sleep(3000);
		 String newCity=eLib.readDataFromExcel("sheet2",0, 0);
		 InHome.city(newCity);
		 InHome.other(eLib.readDataFromExcel("sheet2", 1, 0));
		 InHome.RIsubmit();
		 home.DetailsClick();
		 
		 
	 Thread.sleep(2000);
	 String Expected = driver.findElement(By.xpath("//p[text()='"+name2+"']/..//b[text()=' City: ']/parent::p[text()='"+newCity+"']")).getText();
	 System.out.println(Expected);
	String Actual="City: balasore";
	Assert.fail();
	//Assert.assertSame(Actual, Expected);
			
	 
	 
//	 if(Expected)
//	 {
//	 	System.out.println("edit is sucessfully");
//	 	
//	 }
//	 else
//	 {
//	 System.out.println("edit not don");	
//	 }
	 }
	
	
	}

