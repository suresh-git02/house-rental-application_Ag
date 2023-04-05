package RegistationUsingPOM;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;
import com.ObjectRepo.UserRegistration;
import com.ObjectRepo.WelcomPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistrations {

	public static void main(String[] args) throws Throwable {
		
	
	DatabaseUtlity dLib=new DatabaseUtlity();
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	FileUtility fLib=new FileUtility();
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	wLib.maximizeWindow(driver);
	wLib.implicitelyWait(driver,20);
	
	
	String URL=fLib.readDataFromPropertiesFile("url");
	driver.get(URL);
	 WelcomPage wl=new WelcomPage(driver);
	 wl.logo();
	 wl.RegisterUser();

	 HashMap<String, String> map = eLib.readMultipleDataInExcel("Sheet3");

		Thread.sleep(2000);
	 UserRegistration user=new UserRegistration(driver);
		user.UserRegistrations(driver, map, jLib); 
		user.SubmitUsers();
boolean expt=driver.findElement(By.xpath("//div[text()='Registration successfull. Now you can login']")).isDisplayed();
if(expt)
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