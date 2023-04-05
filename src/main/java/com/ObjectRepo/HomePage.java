package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	//declaration
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeClick;
	@FindBy(xpath="//a[text()='Register']")
	private WebElement RegisterClick;
	@FindBy(xpath="//a[text()='Details/Update']")
	private WebElement DetailsClick;
	@FindBy(xpath="//a[text()='Send SMS']")
	private WebElement SendSMSclick;
	@FindBy(xpath="//a[text()='Complaint List']")
	private WebElement ComplaintListClick;
	@FindBy(xpath="//b[text()='Registered Users: ']")
	private WebElement RegisteredUserClick;
	@FindBy(xpath="//b[text()='Rooms for Rent: ']")
	private WebElement  RoomsforRentClick;

	@FindBy(xpath="//h1[text()='Dash board']")
	private WebElement hadder;
	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement LogOut;

	//initialization
	public   HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeClick() {
		return homeClick;
	}

	public WebElement getRegisterClick() {
		return RegisterClick;
	}

	public WebElement getDetailsClick() {
		return DetailsClick;
	}

	public WebElement getSendSMSclick() {
		return SendSMSclick;
	}

	public WebElement getComplaintListClick() {
		return ComplaintListClick;
	}
	public WebElement getLogOut() {
		return LogOut;
	}
	public WebElement getRegisteredUserClick() {
		return RegisteredUserClick;
	}

	public WebElement getRoomsforRentClick() {
		return RoomsforRentClick;
	}

	public WebElement getHadder() {
		return hadder;
	}

	//utilization
	
	public void homeClick()
	{
		homeClick.click();
	}
	public void RegisterClick()
	{
		RegisterClick.click();
	}
	public void DetailsClick()
	{
		DetailsClick.click();
	}
	public void SendSMSclick()
	{
		SendSMSclick.click();
	}
	public void ComplaintListClick()
	{
		ComplaintListClick.click();
	}
	
	public void LogOut()
	{
		LogOut.click();
	}
	public String hadder()
	{
		String h=hadder.getText();
		return h;
	}
	public void RoomsforRentClick()
	{
		RoomsforRentClick.click();
	}
	public void RegisteredUserClick()
	{
		RegisteredUserClick.click();
	}
}
