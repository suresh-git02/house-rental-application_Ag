package practicePackage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rmgYantra {
public static void main(String[] args) throws Throwable {
	
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CDforRMGyantra.properties");
	Properties p=new Properties();
	p.load(fis);
	String url=p.getProperty("url");
	String username=p.getProperty("username");
	String psw=p.getProperty("psw");
	
	String ActualPoj="Tms_07";
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	
	
	driver.get(url);
	driver.findElement(By.name("username")).sendKeys(username);
     WebElement lunch=driver.findElement(By.name("password"));
     lunch.sendKeys(psw);
     lunch.submit();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//a[text()='Projects']")).click();
     
     driver.findElement(By.xpath("//span[text()='Create Project']")).click();
     Thread.sleep(2000);
     driver.findElement(By.name("projectName")).sendKeys(ActualPoj);
     Thread.sleep(2000);
    // driver.findElement(By.xpath("//label[text()='Team Size']/../input[@name='teamSize']")).sendKeys("4");
     driver.findElement(By.xpath("//label[text()='Project Manager']/../input[@name='createdBy']")).sendKeys("abhii");
     WebElement ststus = driver.findElement(By.xpath("//label[text()='Project Status ']/../select[@name='status']"));
     Select s=new Select(ststus);
     s.selectByVisibleText("On Gogin");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@value='Add Project']")).click();
   
      Driver driver1=new Driver();
      DriverManager.registerDriver(driver1);
     Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%", "root");
      Statement stat = con.createStatement();
      String Query="select * from project;";
      ResultSet sat=stat.executeQuery(Query);
      boolean flage=false;
      while(sat.next())
      {
    	  String exPOJ=sat.getString(4);
    	  
    	  System.out.println(exPOJ);
    	  if(ActualPoj.equalsIgnoreCase(exPOJ))
    	  {
    		  flage=true;
    		  break;
    	  }
    	 
      }
    if(flage)
    {
    	System.out.println("created");
    }
    else {
		System.err.println("not created");
	}
      
     

}
}
//driver.findElement(By.xpath("//label[text()='Project Name']/../input")).sendKeys("");
//driver.findElement(By.xpath("//label[text()='Team Size']/../input")).sendKeys(args);
//driver.findElement(By.xpath("//label[text()='Project Manager']/../input")).sendKeys(args);
//WebElement ststus = driver.findElement(By.name("status"));
//Select s=new Select(ststus);
//s.selectByVisibleText("On Gogin");
