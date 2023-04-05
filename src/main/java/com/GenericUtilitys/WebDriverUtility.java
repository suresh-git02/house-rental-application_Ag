package com.GenericUtilitys;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	

   /**
    *for maximize the window 
    * @param driver
    */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * implicitlyWait
	 * @param driver
	 * @param time
	 */
	public void implicitelyWait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		
	}

	/**
	 *  wait for page load process
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver,int time)
	{
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param time
	 */
	public void elementTObeVisible(WebDriver driver, WebElement element,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time );
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value)
	{
		Select sel =new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText, WebElement element)
	{
		Select sel =new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	
	public String getFirstselectedOption( WebElement element)
	{
		Select sel =new Select(element);
		String opt=sel.getFirstSelectedOption().getText();
		return opt;
	}
	
	public List<WebElement> getAllOptions( WebElement element)
	{
		Select sel =new Select(element);
		 List<WebElement> opt = sel.getOptions();
		 
		return opt;
	}

	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions act =new Actions(driver);
		act.dragAndDrop(src, dest).perform();
		
	}
	/**
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.doubleClick().perform();	
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickActionOnPerticularElement(WebDriver driver,WebElement element)
	{
		Actions act =new Actions(driver);
		act.doubleClick(element).perform();	
	}

	/**
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * 
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot r =new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
/**
 * 
 * @param driver
 * @param address
 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void switchToPerentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
/**
 * 
 * @param driver
 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step1: use getWindowHandles to capture all window id's
		Set<String> windows =driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator<String> it =windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId =it.next();
			
			//step5: switch to current window and capture title
		    String currentWinTiltle =driver.switchTo().window(winId).getTitle();
		    
		    //step6: check whether current window is expected
		    if(currentWinTiltle.contains(partialTitle))
		    {
		    	break;
		    }
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenShot(WebDriver driver, String ScreenShotName) throws Throwable
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		String path =".\\screenshot\\"+ScreenShotName+".png";
		File dest =new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver,int x,int y)
	{
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")", "");
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	 
	public void ScrollUpToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("Arguments[0].ScrollIntoView(true);",element );

	}
//	public String CloseNotification()
//	ChromeOption opt=new ChromeOptions()
}
