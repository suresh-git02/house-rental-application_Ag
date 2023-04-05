package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	
	//Declaration
	@FindBy(name="username")
	private WebElement username;
	@FindBy(name="password")
	private WebElement passward;
	@FindBy(name="login")
	private WebElement submit;
	
	@FindBy(xpath="//a[text()='Register']") private WebElement RegisterUser;
	//initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getRegisterUser()
	{
		return RegisterUser;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassward() {
		return passward;
	}
	public WebElement getSubmit() {
		return submit;
	}
	
	
	//utilization
	public void loginPage(String USERNAME,String PSW)
	{
		username.sendKeys(USERNAME);
		passward.sendKeys(PSW);
		submit.click();
	}
}
