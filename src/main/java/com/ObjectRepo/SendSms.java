package com.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendSms {
	
	
	
		@FindBy(xpath="//input[@name='message']")
		private WebElement MessageBody;
		
		@FindBy(xpath="//button[@name='sms_alert']")
		private WebElement SMSButton;
		
		@FindBy(xpath="//input[@name='check[]']")
		private List<WebElement> checkboxes;
		
		public SendSms(WebDriver driver)
		{
			PageFactory.initElements(driver, this);	
		}
		
		public void clickMessageBody(String message)
		{
			MessageBody.sendKeys(message);;
		}
		
		public void submitSendSMS()
		{
			SMSButton.click();
		}
		
		public void clickcheckBox(WebDriver driver, String name)
		{
			
			 List<WebElement> names = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			for(WebElement ag:names)
			{
				String na = ag.getText();
				if(na.equalsIgnoreCase(name))
				{
					
					driver.findElement(By.xpath("//td[text()='"+na+"']/../th/input")).click();
				}
			}
		}

	}

