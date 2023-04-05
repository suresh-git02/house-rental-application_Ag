package RegistrationUsingTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilitys.BaseClass;
import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;
import com.ObjectRepo.ApartmentRegistration;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApartmentRegistrationss extends BaseClass {

@Test
public void apartmentReg() throws Throwable
{	
	HomePage hm=new HomePage(driver);
		hm.RegisterClick();
		
		ApartmentRegistration ap=new ApartmentRegistration(driver);
		ap.clickApartmentRegTab();
		HashMap<String, String> data = eLib.readMultipleDataInExcel("sheet4");
		ap.registerapartment(driver, data, jLib);
		ap.clickAddMore();
		HashMap<String, String> addData = eLib.readMultipleDataInExcel("Sheet5");
		ap.moreDetails(driver, addData);
		ap.submitRegApartment();
		String expt=driver.findElement(By.xpath("//div[text()='Registration successfull. Thank you']")).getText();
		String Actual="Registration successfull. Thank you";
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(Actual, expt);
		 sa.assertAll();
		 System.out.println("done");
		
		
	    
//		
//		if(expt)
//		{
//	System.out.println("sucessfully update");
//		}
//		else
//		{
//			System.out.println("not updated");
//		}
//		

	
//	HashMap<String, String> map = eLib.readMultipleDataInExcel("Sheet3");
//		RegisterInduvidualHome reg = new RegisterInduvidualHome(driver);
//		reg.registerHome(driver, jLib, map);
//		reg.registerInduvidualHome();
//		eLib.closeWorkbook(ExcelUtility.workBook());
//		
//		d.clickSendSMS();
//		
//		SendSMS s=new SendSMS(driver);
//		Thread.sleep(3000);
//		s.clickcheckBox(driver);
//
//		s.clickMessageBody("NoMessage");
//		s.submitSendSMS();
//		
		
	}
}

	

