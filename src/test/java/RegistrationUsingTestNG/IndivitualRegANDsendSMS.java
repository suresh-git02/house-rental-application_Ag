package RegistrationUsingTestNG;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.GenericUtilitys.BaseClass;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.IndivitualHomeRegistration;
import com.ObjectRepo.SendSms;


public class IndivitualRegANDsendSMS extends BaseClass {

@Test
public void sendSms() throws Throwable
{	
		HomePage hm=new HomePage(driver);
		hm.RegisterClick();
		IndivitualHomeRegistration reg=new IndivitualHomeRegistration(driver);
	
		
		HashMap<String, String> map = eLib.readMultipleDataInExcel("Sheet1");
		reg.RegisterHome(driver, map, jLib);
		reg.RIsubmit();
		hm.SendSMSclick();
		SendSms sms=new SendSms(driver);
		sms.clickcheckBox(driver,eLib.readDataFromExcel("Sheet2", 2, 0) );
		sms.clickMessageBody("kukura");
		sms.submitSendSMS();
		driver.navigate().back();
		
}		
}
