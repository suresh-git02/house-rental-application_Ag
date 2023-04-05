package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

	//Declaration
	@FindBy(id="keywords") private WebElement keywords;
	@FindBy(id="location") private WebElement location;
	@FindBy(xpath="//button[@name='search']") private WebElement SearchRoom;

	
	//inithialization
	public Search(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getKeywords() {
		return keywords;
	}


	public WebElement getLocation() {
		return location;
	}


	public WebElement getSearchRoom() {
		return SearchRoom;
	}
	
	
	//utilization
	public void SearchRoom( String keyWords,String locations)
	{
		keywords.sendKeys(keyWords);
		location.sendKeys(locations);
		//SearchRoom.click();

}
	public void SearchRooms() {
		SearchRoom.click();

	}

}