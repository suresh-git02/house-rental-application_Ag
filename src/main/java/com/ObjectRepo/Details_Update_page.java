package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Details_Update_page {

	
	//Declearation
	@FindBy(xpath="//a[text()='Complaint']") private WebElement  complaint;
	
	//Inithialization
	public Details_Update_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public WebElement getComplaint() {
		return complaint;
	}




	//utilization
	public void Edit(String name,WebDriver driver)
	{
		  driver.findElement(By.xpath("//p[text()='"+name+"']/../../../a")).click();

	}
	
	public void EditApt(String name,WebDriver driver)
	{
		  driver.findElement(By.xpath("//p[text()='"+name+"']/../../../../a")).click();

	}

	public void Complaint(String name,WebDriver driver)
	{
		complaint.click();
	}
}
