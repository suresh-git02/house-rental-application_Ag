package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilitys.JavaUtility;

public class UserRegistration {

	
	//Declaration
		@FindBy(id="fullname")
		private WebElement fullname;
		@FindBy(id="username")
		private WebElement username;
		@FindBy(id="mobile")
		private WebElement mobile;
		@FindBy(id="email")
		private WebElement email;
		@FindBy(id="password")
		private WebElement password;
		@FindBy(id="c_password")
		private WebElement c_password;
		
		@FindBy(xpath="//button[text()='Submit']")
		private WebElement SubmitUser;

		public UserRegistration(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		
		
		public WebElement getFullname() {
			return fullname;
		}

		public WebElement getUsername() {
			return username;
		}

		public WebElement getMobile() {
			return mobile;
		}

		public WebElement getEmail() {
			return email;
		}

		public WebElement getPassword() {
			return password;
		}

		public WebElement getC_password() {
			return c_password;
		}
		
		
		public WebElement SubmitUser() {
			return SubmitUser;
		}
		
		
   public   String  UserRegistrations(WebDriver driver,HashMap<String,String> map,JavaUtility jLib)
		{
      	String name=null;
for(Entry<String, String> ag:map.entrySet())
{
	
     String actual=ag.getKey();

	if(actual.equalsIgnoreCase("fullname"))
	{
		name=ag.getValue()+jLib.random();
		driver.findElement(By.id(ag.getKey())).sendKeys(name);
	}
	else if(actual.equalsIgnoreCase("mobile"))
	{
		driver.findElement(By.id(ag.getKey())).sendKeys(ag.getValue()+jLib.random());

	}
	else if(actual.equalsIgnoreCase("username"))
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
return name;
		}

	
   public void SubmitUsers()

      {
	   
	   SubmitUser.click();
	   }
}
