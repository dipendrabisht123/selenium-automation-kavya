package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static Driver driverObj = null;
	protected static WebDriver driver = null;
	
	public Driver(){
		
	}
	
	public static Driver getDriverObj(String sBrowserType){
		
		if (driverObj == null){
			driverObj = new Driver();
			initializeBrowser(sBrowserType);
		}
		
		return driverObj;
	}
	
	public static WebDriver getWebDriver(String sBrowserType){
		return getDriverObj(sBrowserType).driver;
	}
	
	
	public static WebDriver initializeBrowser(String sBrowserType){
		
		if (sBrowserType.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().version("2.41").setup();
			driver = new ChromeDriver();
			
		}else if (sBrowserType.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().arch32().setup();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static WebElement getElement(WebDriver driver, By by){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
}
