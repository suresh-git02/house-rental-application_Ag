package Ragistration;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class EditDetails {
public static void main(String[] args) throws Throwable {
	
	WebDriverManager.chromedriver().setup();;
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	
	Random r=new Random();
	int ran=r.nextInt(100000);
	
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties p=new Properties();
	p.load(fis);
	String URL=p.getProperty("url");
	String USERNAME=p.getProperty("username");
	String PASSWORD=p.getProperty("psw");

	
	
	driver.get(URL);
	//driver.findElement(By.xpath("//a[text()='Login']")).click();
	driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.name("login")).click();
	

	driver.findElement(By.xpath("//a[text()='Register']")).click();
	
	FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testyantra.xlsx");
	Workbook book = WorkbookFactory.create(fis1);
	Sheet sh = book.getSheet("sheet1");
	
	
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	
         HashMap<String, String> map = new HashMap<String, String>();
         for(int i=0;i<=sh.getLastRowNum();i++)
         {
        String	key= sh.getRow(i).getCell(0).getStringCellValue();
        String value = sh.getRow(i).getCell(1).getStringCellValue();
        map.put(key,value);
        
         }
        for(Entry<String, String> set:map.entrySet())
        {
        	Thread.sleep(2000);
        	driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
        }
	
	WebElement ag=driver.findElement(By.name("vacant"));
	Select s=new Select(ag);
	s.selectByIndex(1);
	
	driver.findElement(By.name("register_individuals")).click();
	driver.findElement(By.xpath("//a[text()='Details/Update']")).click();

	
	driver.findElement(By.xpath("//p[text()='sureshbiswal12']/../../../a")).click();
	 String city="bangaluru";
	driver.findElement(By.id("city")).clear();
	driver.findElement(By.id("city")).sendKeys(city);
	driver.findElement(By.name("other")).sendKeys("nothing");
	driver.findElement(By.name("register_individuals")).click();


	driver.findElement(By.xpath("//a[text()='Details/Update']")).click();

String 	Actual="sureshbiswal12";
Thread.sleep(2000);
boolean Expected = driver.findElement(By.xpath("//p[text()='sureshbiswal12']/..//b[text()=' City: ']/parent::p[text()='balasore']")).isDisplayed();
if(Expected)
{
	System.out.println("edit is sucessfully");
	
}
else
{
System.out.println("edit not don");	
}
}
}
/*WebElement name=driver.findElement(By.name("fullname"));
name.sendKeys("sureshWaris"+ran);
driver.findElement(By.name("mobile")).sendKeys("63715"+ran);
driver.findElement(By.name("alternat_mobile")).sendKeys("6389999091");

driver.findElement(By.name("email")).sendKeys("tapuu"+ran+"@gmail.com");
driver.findElement(By.name("plot_number")).sendKeys("p-232"+ran);
driver.findElement(By.name("rooms")).sendKeys("2bhk");
driver.findElement(By.name("country")).sendKeys("india");
driver.findElement(By.name("state")).sendKeys("karnataka");
driver.findElement(By.name("city")).sendKeys("bangaluru");
driver.findElement(By.name("rent")).sendKeys("2000");
driver.findElement(By.name("sale")).sendKeys("1000");
driver.findElement(By.name("deposit")).sendKeys("10000");
driver.findElement(By.name("accommodation")).sendKeys("everything");
driver.findElement(By.id("description")).sendKeys("okkk");
driver.findElement(By.name("landmark")).sendKeys("bangaluru");
driver.findElement(By.name("address")).sendKeys("mangaluru");
driver.findElement(By.id("image")).sendKeys("D:\\Tapu\\Tapu.jpg");
*/
