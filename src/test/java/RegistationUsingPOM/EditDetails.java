package RegistationUsingPOM;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;
import com.ObjectRepo.Details_Update_page;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.IndivitualHomeRegistration;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditDetails {

	
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
		String USERNAME=fLib.readDataFromPropertiesFile("username");
		String PASSWORD=fLib.readDataFromPropertiesFile("psw");

		
		//lunch the browser and login
		
		driver.get(URL);
		LoginPage lp= new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
		//Cick on registar
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
//		for(Entry<String, String> ag:map.entrySet())
//		{
//			String actual=ag.getKey();
//			
//			if(actual.equalsIgnoreCase("fullname"))
//			{
//				name=ag.getValue()+jLib.random();
//				driver.findElement(By.id(ag.getKey())).sendKeys(name);
//			}
//			else if(actual.equalsIgnoreCase("mobile"))
//			{
//				driver.findElement(By.id(ag.getKey())).sendKeys(ag.getValue()+jLib.random());
//		
//			}
//			else if(actual.equalsIgnoreCase("email"))
//			{
//				driver.findElement(By.id(ag.getKey())).sendKeys("ag"+jLib.random()+ag.getValue());
//		
//			}
//			else
//			{
//				driver.findElement(By.id(ag.getKey())).sendKeys(ag.getValue());
//			}
//		}
//		
		
		//System.out.println(name);
		
		
		//WebElement element=driver.findElement(By.name("vacant"));
	    // wLib.select(element,1);
	     //driver.findElement(By.name("register_individuals")).click();
		 
	    // driver.findElement(By.xpath("//a[text()='Details/Update']")).click();
	     //driver.findElement(By.xpath("//p[text()='"+name+"']/../../../a")).click();
	     
		 InHome.getCity().clear();
		 Thread.sleep(3000);
		 String newCity=eLib.readDataFromExcel("sheet2",0, 0);
		 InHome.city(newCity);
		 InHome.other(eLib.readDataFromExcel("sheet2", 1, 0));
		 InHome.RIsubmit();
		 home.DetailsClick();
	     //String city="bangaluru";
	 	//driver.findElement(By.id("city")).clear();
	 	//driver.findElement(By.id("city")).sendKeys(city);
	 	//driver.findElement(By.name("other")).sendKeys("nothing");
	 	//driver.findElement(By.name("register_individuals")).click();


	 	//driver.findElement(By.xpath("//a[text()='Details/Update']")).click();

	
	 Thread.sleep(2000);
	 boolean Expected = driver.findElement(By.xpath("//p[text()='"+name2+"']/..//b[text()=' City: ']/parent::p[text()='"+newCity+"']")).isDisplayed();
	 if(Expected)
	 {
	 	System.out.println("edit is sucessfully");
	 	
	 }
	 else
	 {
	 System.out.println("edit not don");	
	 }
	 }
	
	
	}

