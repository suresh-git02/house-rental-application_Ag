package RegistrationUsingGenericUtility;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndivitualHomeRagistration {

	
	public static void main(String[] args) throws Throwable {
	
	DatabaseUtlity dLib =new DatabaseUtlity();
	ExcelUtility eLib=new ExcelUtility();
	FileUtility fLib=new FileUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	wLib.maximizeWindow(driver);
	wLib.implicitelyWait(driver,20);
	
	
	String URL=fLib.readDataFromPropertiesFile("url");
	String USERNAME=fLib.readDataFromPropertiesFile("username");
	String PASSWORD=fLib.readDataFromPropertiesFile("psw");

	
	//lunch the browser and login
	
	driver.get(URL);
	driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.name("login")).click();
	
	//Cick on registar
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	
	//read the multipledata in ExcelSheet
	HashMap<String, String> map = eLib.readMultipleDataInExcel("sheet1");
	
	
	
	for(Entry<String, String> ag:map.entrySet())
	{
		String actual=ag.getKey();
		
		if(actual.equalsIgnoreCase("fullname"))
		{
			driver.findElement(By.id(ag.getKey())).sendKeys(ag.getValue()+jLib.random());
		}
		else if(actual.equalsIgnoreCase("mobile"))
		{
			driver.findElement(By.id(ag.getKey())).sendKeys(ag.getValue()+jLib.random());
	
		}
		else if(actual.equalsIgnoreCase("email"))
		{
			driver.findElement(By.id(ag.getKey())).sendKeys("ag"+jLib.random()+ag.getValue());
	
		}
		else
		{
			driver.findElement(By.id(ag.getKey())).sendKeys(ag.getValue());
		}
	}
	
	WebElement element=driver.findElement(By.name("vacant"));
     wLib.select(element,1);
     driver.findElement(By.name("register_individuals")).click();
		
     Boolean Expected=driver.findElement(By.xpath("//div[text()='Registration successfull. Thank you']")).isDisplayed();
     if(Expected)
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
