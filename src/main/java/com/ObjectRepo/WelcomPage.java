package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomPage {

	
	//Declaration
	@FindBy(xpath="//a[text()='Logo/Home']") private WebElement logo;
	@FindBy(xpath="//a[text()='Search']") private WebElement search;
	@FindBy(xpath="//a[text()='Register']") private WebElement RegisterUser;
	@FindBy(xpath="//a[text()='Home']") private WebElement home;
	@FindBy(xpath="//a[text()='Login']") private WebElement loginclick;






	
	


	//initialization
	 public WelcomPage(WebDriver driver)
	 {
		PageFactory.initElements(driver, this);
	 }
	 
	 
	 public WebElement getHome() {
			return home;
		}

	 public WebElement getLoginclick() {
			return loginclick;
		}
	 
	 public WebElement getlogo()
	 {
		 return logo;
	 }
	 public WebElement getsearch()
	 {
		 return search;
	 }
	 public WebElement getRegisterUser()
	 {
		 return RegisterUser;
	 }
	//utilization
	 public void logo()
	 {
		 logo.click();
	 }
	 public void search()
	 {
		 search.click();
	 }
	 public void RegisterUser()
	 {
		 RegisterUser.click();
	 }
	 public void home()
	 {
		 home.click();
	 }
	 public void loginclick()
	 {
		 loginclick.click();
	 }
}
