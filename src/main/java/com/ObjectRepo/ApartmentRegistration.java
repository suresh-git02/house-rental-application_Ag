package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilitys.JavaUtility;

public class ApartmentRegistration {

	@FindBy(xpath="//a[text()='Apartment Registration']")
	private WebElement apartmentRegTab;
	
	@FindBy(name="apartment_name")
	private WebElement apartmentname;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='plot_number']")
	private WebElement plotNumber;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='country']")
	private WebElement country;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='state']")
	private WebElement state;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='landmark']")
	private WebElement landmark;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='address']")
	private WebElement address;
	
	@FindBy(xpath="//a[text()='Add More(Plat Number/Description)']")
	private WebElement description;
	
	@FindBy(xpath="//a[text()='Add More(Plat Number/Description)']")
	private WebElement AddMore;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='fullname[]']")
	private WebElement fullname;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='ap_number_of_plats[]']")
	private WebElement plats;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='rooms[]']")
	private WebElement rooms;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='area[]']")
	private WebElement area;
	
	@FindBy(xpath="//select[@name='purpose[]']")
	private WebElement purpose;
	
	@FindBy(name="floor[]")
	private WebElement floor;
	
	@FindBy(name="own[]")
	private WebElement ownOrrented;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='rent[]']")
	private WebElement rent;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='deposit[]']")
	private WebElement deposit;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='accommodation[]']")
	private WebElement facilities;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='description[]']")
	private WebElement desc;
	
	public WebElement getApartmentRegTab() {
		return apartmentRegTab;
	}

	public WebElement getApartmentname() {
		return apartmentname;
	}

	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPlotNumber() {
		return plotNumber;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getLandmark() {
		return landmark;
	}

	public WebElement getAddress() {
		return address;
	}


	public WebElement getDescription() {
		return description;
	}


	public WebElement getAddMore() {
		return AddMore;
	}

	public WebElement getFullname() {
		return fullname;
	}
	public WebElement getPlats() {
		return plats;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getArea() {
		return area;
	}

	public WebElement getPurpose() {
		return purpose;
	}

	public WebElement getFloor() {
		return floor;
	}

	public WebElement getOwnOrrented() {
		return ownOrrented;
	}


	public WebElement getRent() {
		return rent;
	}


	public WebElement getDeposit() {
		return deposit;
	}


	public WebElement getFacilities() {
		return facilities;
	}

	public WebElement getDesc() {
		return desc;
	}


	public WebElement getVacant() {
		return vacant;
	}

	public WebElement getRegisterapartment() {
		return registerapartment;
	}

	@FindBy(name="vacant[]")
	private WebElement vacant;
	
	@FindBy(name="register_apartment")
	private WebElement registerapartment;
	
	

	
	public ApartmentRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	//HashMap<String, String> map = eLib.readMultipleData("Sheet2");
	public String registerapartment(WebDriver driver, HashMap<String, String> map, JavaUtility jLib) {
String nam=null;
	for(Entry<String, String> set: map.entrySet())
	{
		
		String key = set.getKey();
		if(key.equalsIgnoreCase("apartment_name"))
		{
			nam =set.getValue()+jLib.random();
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='"+set.getKey()+"']")).sendKeys(nam);
		}
		
		else 
		{
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='"+set.getKey()+"']")).sendKeys(set.getValue());
			
		}
	}
        return nam;

	}
	

	
	//HashMap<String, String> mapA = eLib.readMultipleData("Sheet3");
	public void moreDetails(WebDriver driver, HashMap<String, String> mapA) throws Throwable
	{
		
	for(Entry<String, String> set1: mapA.entrySet())
	{
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='"+set1.getKey()+"']")).sendKeys(set1.getValue());
	}
	
	}
	
	
	
	public void clickAddMore()
	{
		AddMore.click();
	}
	
	public void state(String  Sname)
	{
		state.sendKeys(Sname);
	}
	
	
	public void submitRegApartment()
	{
		registerapartment.click();
	}
	public void stateClear()
	{
		state.clear();
	}

	
	
	

	
	public void clickApartmentRegTab()
	{
		apartmentRegTab.click();
	}
	
	public void checkApartmentReg(WebDriver driver)
	{
	boolean display = driver.findElement(By.xpath("//div[.='Registration successfull. Thank you']")).isDisplayed();
	if(display)
	{
		System.out.println("registration successful");
	}
	else {
		System.out.println("registration not successful");
	}
	}

	public void updateDet(WebDriver driver)
	{
		driver.findElement(By.xpath("//p[text()='Ammant apartment']/../../../child::div[@class='col-5']//b[text()='Apartment Name: ']/../../../../../a")).click();
		driver.findElement(By.name("rooms")).clear();
		String newDet = "bangalore";
	driver.findElement(By.name("city")).sendKeys(newDet);
	this.submitRegApartment();
	HomePage home=new HomePage(driver);
			home.DetailsClick();
	driver.findElement(By.xpath("//p[text()='Ammant apartment']/../../../child::div[@class='col-5']//b[text()='Apartment Name: ']/../../../../../a")).click();
	 String room = driver.findElement(By.name("city")).getText();
	
		System.out.println("updated successfully");
	}	
	
}
