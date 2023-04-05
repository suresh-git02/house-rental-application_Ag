package practicePackage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympic {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	
	
	
//	List<WebElement> country = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
//	List<WebElement> gold = driver.findElements(By.xpath("//div[@title='Gold']/span[1]"));
//	List<WebElement> silver = driver.findElements(By.xpath("//div[@title='Silver']/span[1]"));
//	List<WebElement> bronze = driver.findElements(By.xpath("//div[@title='Bronze']/span[1]"));
//	List<WebElement> total = driver.findElements(By.xpath("//div[contains(@data-medal-id,'total-medals-')]/span[1]"));
//
//	for(int i=0;i<=country.size()-1;i++)
//	{
//		System.out.println(country.get(i).getText()+" "+gold.get(i).getText()+" "+silver.get(i).getText()+" "+bronze.get(i).getText()+" "+total.get(i).getText());
//	}
//	
	
	String ag="Armenia";
	String gold=driver.findElement(By.xpath("//span[text()='"+ag+"']/../following-sibling::div[1]/span[1]")).getText();
	String silver=driver.findElement(By.xpath("//span[text()='"+ag+"']/../following-sibling::div[2]/span[1]")).getText();
	String bronze=driver.findElement(By.xpath("//span[text()='"+ag+"']/../following-sibling::div[3]/span[1]")).getText();
	String total=driver.findElement(By.xpath("//span[text()='"+ag+"']/../following-sibling::div[4]/span[1]")).getText();
	
	System.out.println(ag+"   "+"gold=="+gold+"  "+"silver=="+silver+"  "+"bronze=="+bronze+"  "+"total=="+total);

}
}
