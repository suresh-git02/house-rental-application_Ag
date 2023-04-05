package practicePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeamRanking {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 
 
 driver.get("https://www.icc-cricket.com/rankings/womens/team-rankings/odi");
 List<WebElement> ag = driver.findElements(By.xpath("//tbody/tr/td[1]"));
 List<WebElement> ag2 = driver.findElements(By.xpath("//tbody/tr/td[2]"));
 List<WebElement> ag3 = driver.findElements(By.xpath("//tbody/tr/td[3]"));
 List<WebElement> ag4 = driver.findElements(By.xpath("//tbody/tr/td[4]"));
 List<WebElement> ag5 = driver.findElements(By.xpath("//tbody/tr/td[5]"));

 for(int i=0;i<=ag.size()-1;i++)
 {
	 System.out.println(ag.get(i).getText()+" "+ag2.get(i).getText()+" "+ag3.get(i).getText()+" "+ag4.get(i).getText()+" "+ag5.get(i).getText());
 }
 
 
 
// String teamName="India";
// String rating=driver.findElement(By.xpath("//span[text()='"+teamName+"']/../../td[3]")).getText();
// System.out.println(rating);
}
}
