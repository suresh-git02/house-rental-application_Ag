package practicePackage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTripe {
public static void main(String[] args) throws Throwable {
	ChromeOptions op=new ChromeOptions();
	op.addArguments("--disable-notifications");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(op);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
	WebElement from = driver.findElement(By.xpath("//label[@for='fromCity']"));
	from.click();
 driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bangulore");
 driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
 
 WebElement to = driver.findElement(By.xpath("//label[@for='toCity']"));
	to.click();
driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bhubaneswar");
driver.findElement(By.xpath("//p[text()='Bhubaneswar, India']")).click();



Date cdate=new Date();
System.out.println(cdate);
String[] d=cdate.toString().split(" ");
String day=d[0];
String month=d[1];
String date=d[2];
String year=d[5];
String travelDate=day+" "+month+" "+date+" "+year;

driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();


//return date

String rday="Thu";
String rmonth="Jun";
String rdate="15";
String ryear="2023";
String rtravelDate=rday+" "+rmonth+" "+rdate+" "+ryear;

for(; ;)
{
	try {
		driver.findElement(By.xpath("//div[@aria-label='"+rtravelDate+"']")).click();
 break;
		
	} catch (Exception e) {
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

	}
}
driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom5']")).click();
driver.findElement(By.xpath("//li[@data-cy='adults-6']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();

driver.findElement(By.xpath("//a[text()='Search']")).click();


}
}
