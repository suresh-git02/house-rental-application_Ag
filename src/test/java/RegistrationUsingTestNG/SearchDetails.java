package RegistrationUsingTestNG;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilitys.BaseClass;
import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.IndivitualHomeRegistration;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.Search;
import com.ObjectRepo.WelcomPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchDetails extends BaseClass {
	
	@Test
	public void searchRoom() throws Throwable
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

		 WelcomPage wl=new WelcomPage(driver);
		 wl.logo();
		 wl.search();
	  
		 Search sc=new Search(driver);
		 sc.SearchRoom(name2,"balasore");
		 Thread.sleep(3000);
		sc.SearchRooms();
	
	 	boolean display=driver.findElement(By.xpath("//section[@id='search']//b[text()='Owner Name: ']/parent::p[text()='"+name2+"']")).isDisplayed();
	 	if(display)
	 	{
	 		System.out.println("search is sucessfully");
	 		
	 	}
	 	else
	 	{
	 	System.out.println("edit not don");	
	 	}
		wl.home();
	}	
}