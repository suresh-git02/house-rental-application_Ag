package search_package;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndivitualRoomSearch {
public static void main(String[] args) throws Throwable {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	
	Random r=new Random();
	int ran=r.nextInt(100000);
	
	
	driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("login")).click();
	
	
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	driver.findElement(By.name("fullname")).sendKeys("sureshWaris"+ran);
	driver.findElement(By.name("mobile")).sendKeys("63715"+ran);
	driver.findElement(By.name("alternat_mobile")).sendKeys("6389999091");

	
	
	driver.findElement(By.name("email")).sendKeys("tapuu"+ran+"@gmail.com");
	driver.findElement(By.name("plot_number")).sendKeys("p-232"+ran);
	driver.findElement(By.name("rooms")).sendKeys("2bhk");
	driver.findElement(By.name("country")).sendKeys("india");
	
	String state="odisha";
	driver.findElement(By.name("state")).sendKeys(state);
	driver.findElement(By.name("city")).sendKeys("bhubaneswar");
	driver.findElement(By.name("rent")).sendKeys("2000");
	driver.findElement(By.name("sale")).sendKeys("1000");
	driver.findElement(By.name("deposit")).sendKeys("10000");
	driver.findElement(By.name("accommodation")).sendKeys("everything");
	driver.findElement(By.id("description")).sendKeys("okkk");
	driver.findElement(By.name("address")).sendKeys("odisha");
	WebElement ag=driver.findElement(By.name("vacant"));


	Select s=new Select(ag);
	s.selectByIndex(1);
	
	driver.findElement(By.id("image")).sendKeys("D:\\Tapu\\Tapu.jpg");
	driver.findElement(By.name("register_individuals")).click();
	
	driver.findElement(By.xpath("//a[text()='Logo/Home']")).click();
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	
	driver.findElement(By.id("keywords")).sendKeys("sureshWaris"+ran);
	driver.findElement(By.id("location")).sendKeys(state);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Search']")).click();
	
	boolean display=driver.findElement(By.xpath("//section[@id='search']//b[text()='Owner Name: ']/parent::p[text()='sureshWaris"+ran+"']")).isDisplayed();
	if(display)
	{
		System.out.println("search is sucessfully");
		
	}
	else
	{
	System.out.println("edit not don");	
	}
	
}
}
//section[@id='search']//b[text()='Owner Name: ']/parent::p[text()='sureshWaris64974']