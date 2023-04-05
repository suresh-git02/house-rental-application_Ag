package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll {
public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
WebElement ag=driver.findElement(By.xpath("//div[text()='Kitchen Appliances']"));
JavascriptExecutor jvs=(JavascriptExecutor)driver ;
jvs.executeScript("Argument[0].scrollTo(true)", ag);
	


}
}
