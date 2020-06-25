package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.Driver;
import Utilities.ConfigDetails;

public class JavaScriptOperations {

	static WebDriver driver = null;
	
	
	@Test
	public void f() {

		try {
			
			driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
			driver.manage().window().maximize();
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			Thread.sleep(1000);
			driver.get(ConfigDetails.getProperty("App_url_" + ConfigDetails.getProperty("Environment")));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			Thread.sleep(1000);
			
			js.executeScript("window.scrollBy(0,1600);");
			Thread.sleep(1000);
			
			js.executeScript("window.scrollBy(0,-1000);");
			//String sParentHandle = driver.getWindowHandle();
			
			WebElement txtPWD = driver.findElement(By.id("Password"));
			WebElement btnRegister = driver.findElement(By.id("register-button"));
			
//			js.executeScript("arguments[1].scrollIntoView();", txtPWD, btnRegister);
			
			js.executeScript("arguments[1].click();", txtPWD, btnRegister);
			
			
			Thread.sleep(1000);

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
