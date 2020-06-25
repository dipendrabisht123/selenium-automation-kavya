package Selenium;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Driver;
import Utilities.ConfigDetails;

public class HandleMultiWindows {
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		handleMultipleWindows();
	}
	
	public static void handleMultipleWindows() throws InterruptedException{
		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		driver.manage().window().maximize();

		Thread.sleep(1000);
		driver.get(ConfigDetails.getProperty("App_url_"+ConfigDetails.getProperty("Environment")));
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		
		String sParentHandle = driver.getWindowHandle();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		WebElement linkTwitter = driver.findElement(By.linkText("Twitter"));
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(linkTwitter));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Twitter")));
		
		linkTwitter.click();
		
		Set<String> setHandles = driver.getWindowHandles();
		
		Iterator<String> it = setHandles.iterator();
		
		while (it.hasNext()){
			String sHandle = it.next();
			
			if (!sHandle.equalsIgnoreCase(sParentHandle)){
				driver.switchTo().window(sHandle);
				break;
			}
			
		}
		
		WebElement txtSearch = driver.findElement(By.xpath("//input[@aria-label='Search query']"));
		txtSearch.sendKeys("Selenium");
		
		txtSearch.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		driver.close();
		
		driver.switchTo().window(sParentHandle);
		
		WebElement linkFacebook = driver.findElement(By.linkText("Facebook"));
		
		linkFacebook.click();
		
		driver.quit();
		
	}
	

}
