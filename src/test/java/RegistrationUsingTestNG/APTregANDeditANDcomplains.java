package RegistrationUsingTestNG;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilitys.BaseClass;
import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;
import com.ObjectRepo.ApartmentRegistration;
import com.ObjectRepo.Details_Update_page;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.complain;

import io.github.bonigarcia.wdm.WebDriverManager;

public class APTregANDeditANDcomplains extends BaseClass {

	
		
		@Test
		public void complaint() throws Throwable
		{
		HomePage hm=new HomePage(driver);
		hm.RegisterClick();
		
		ApartmentRegistration ap=new ApartmentRegistration(driver);
		ap.clickApartmentRegTab();
		HashMap<String, String> data = eLib.readMultipleDataInExcel("sheet4");
		String name = ap.registerapartment(driver, data, jLib);
		ap.clickAddMore();
		HashMap<String, String> addData = eLib.readMultipleDataInExcel("Sheet5");
		ap.moreDetails(driver, addData);
		ap.submitRegApartment();
		hm.DetailsClick();
		Details_Update_page detl=new Details_Update_page(driver);
		detl.EditApt(name, driver);
		
		ap.stateClear();
		ap.state(eLib.readDataFromExcel("sheet2", 3, 0));
		Thread.sleep(2000);
		ap.submitRegApartment();
		hm.DetailsClick();
		detl.Complaint(name, driver);
		complain cmp=new complain(driver);
		cmp.name(name);
		cmp.complains(eLib.readDataFromExcel("sheet2", 4, 0));
		cmp.submitcmp();
		
		
		
}
}