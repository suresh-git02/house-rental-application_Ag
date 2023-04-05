package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class complain {

	@FindBy(name="name")
	private WebElement name ;
	@FindBy(name="cmp")
	private WebElement complains;
	@FindBy(name="register")
	private WebElement submitcmp;
	
	
	public complain(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getName() {
		return name;
	}


	public WebElement getComplains() {
		return complains;
	}


	public WebElement getSubmitcmp() {
		return submitcmp;
	}
	
	
	public void name(String names)
	{
		name.sendKeys(names);
	}
	
	public void complains(String cmp)
	{
		complains.sendKeys(cmp);
	}
	public void submitcmp()
	{
		submitcmp.click();
	}
	
	
}
