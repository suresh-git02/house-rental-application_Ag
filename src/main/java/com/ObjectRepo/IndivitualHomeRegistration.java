package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;

public class IndivitualHomeRegistration {

	//Declaration
	@FindBy(id="fullname")
	private WebElement fullname;
	@FindBy(id="mobile")
	private WebElement mobile;
	@FindBy(id="alternat_mobile")
	private WebElement alternat_mobile;
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="plot_number")
	private WebElement plot_number;
	@FindBy(id="rooms")
	private WebElement rooms;
	@FindBy(id="country")
	private WebElement country;
	@FindBy(id="state")
	private WebElement state;
	@FindBy(id="city")
	private WebElement city;
	@FindBy(id="rent")
	private WebElement rent;
	@FindBy(id="sale")
	private WebElement sale;
	@FindBy(id="deposit")
	private WebElement deposit;
	@FindBy(id="accommodation")
	private WebElement accommodation;
	@FindBy(id="description")
	private WebElement description;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(id="image")
	private WebElement image;
	@FindBy(id="vacant")
	private WebElement vacant;
	@FindBy(id="landmark")
	private WebElement landmark;

	@FindBy(name="register_individuals")
	private WebElement RIsubmit ;


	@FindBy(xpath="//h2[text()='Register Room']")
	private WebElement IndivisualHoemHeader;
	
	@FindBy(name="other")
	private WebElement other ;
	
	



	//inithialization
	public IndivitualHomeRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);          //constroctor
	}
	
	
	public WebElement getOther() {
		return other;
	}
	public WebElement getFullname() {
		return fullname;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getAlternat_mobile() {
		return alternat_mobile;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPlot_number() {
		return plot_number;
	}
	public WebElement getRooms() {
		return rooms;
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
	public WebElement getRent() {
		return rent;
	}
	public WebElement getSale() {
		return sale;
	}
	public WebElement getDeposit() {
		return deposit;
	}
	public WebElement getAccommodation() {
		return accommodation;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getImage() {
		return image;
	}
	public WebElement getVacant() {
		return vacant;
	}
	public WebElement getRIsubmit() {
		return RIsubmit;
	}
	public WebElement getIndivisualHoemHeader() {
		return IndivisualHoemHeader;
	}
	
	public WebElement getLandmark() {
		return landmark;
	}

	
	//Utilization
	public void IndivisualHoemDetails(WebDriverUtility wLib,String fname,String mob,String A_mob,String Email,String p_no,String room,String countrys,String states,String citys,String rents,String sales,String deposits,String accommodations,String descriptions,String addresss,String images,String landmarks)
	{
		fullname.sendKeys(fname);
		mobile.sendKeys(mob);
		alternat_mobile.sendKeys(A_mob);
		email.sendKeys(Email);
		plot_number.sendKeys(p_no);
		rooms.sendKeys(room);
		country.sendKeys(countrys);
		state.sendKeys(states);
		city.sendKeys(citys);
		rent.sendKeys(rents);
		sale.sendKeys(sales);
		deposit.sendKeys(deposits);
		accommodation.sendKeys(accommodations);
		description.sendKeys(descriptions);
		address.sendKeys(addresss);
		image.sendKeys(images);
		wLib.select(vacant, 1);
		landmark.sendKeys(landmarks);
		RIsubmit.click();
		
	}



	public String  IndivisualHoemHeader()
	{
		String text=IndivisualHoemHeader.getText();
		return text;
	}
	
	public void  RIsubmit()
	{
		RIsubmit.click();
	}
	
	public String  city(String Cityy)
	{
		city.sendKeys(Cityy);
		return Cityy;
	}	
	
	public void  other(String otherSMS)
	{
		other.sendKeys(otherSMS);;
	}
	
	//HashMap<String, String> map = eLib.readMultipleDataInExcel("sheet1");
	public String RegisterHome(WebDriver driver,HashMap<String,String> map,JavaUtility jLib)
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
	}
