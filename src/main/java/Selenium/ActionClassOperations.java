package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Base.Driver;
import Utilities.ConfigDetails;

public class ActionClassOperations {
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		contaxtClick();

	}
	
	public static void actionsClassOperations(){
		try {
			driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
			driver.manage().window().maximize();

			
			driver.get(ConfigDetails.getProperty("App_url_"+ConfigDetails.getProperty("Environment")));
			
			//WebElement txtUserName = driver.findElement(By.id("txtUsername"));
			WebElement txtUserName = Driver.getElement(driver, By.id("txtUsername"));
			
//		WebElement txtPWD = driver.findElement(By.id("txtPassword"));
			WebElement txtPWD = Driver.getElement(driver, By.id("txtPassword"));
			
//		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
			WebElement btnLogin = Driver.getElement(driver, By.id("btnLogin"));
			
			
			
			txtUserName.sendKeys(ConfigDetails.getProperty("user_Name"));
			
			
			
			txtPWD.sendKeys(ConfigDetails.getProperty("user_pwd"));
			
			
//			btnLogin.click();
			Actions act = new Actions(driver);
			act.moveToElement(btnLogin).click(btnLogin).perform();
			
			Thread.sleep(3000);
			
			WebElement menuLeave = Driver.getElement(driver, By.xpath("//a[b[text()='Leave']]"));
			//WebElement menuLeave = driver.findElement(By.xpath("//a[b[text()='Leave']]"));
			
//		WebElement miApply = Driver.getElement(driver, By.linkText("Apply"));
			
			act.moveToElement(menuLeave).perform();
			act.click(driver.findElement(By.linkText("Apply"))).perform();
			
			
			WebElement txtComments = Driver.getElement(driver, By.cssSelector("textarea#applyleave_txtComment"));
			
			act.sendKeys(txtComments, "Some comments").perform();
			
			act.click(txtComments).keyDown(txtComments, Keys.SHIFT).sendKeys(Keys.HOME).sendKeys("Hello there").keyUp(Keys.SHIFT).perform();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	
	public static void contaxtClick(){
		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		driver.manage().window().maximize();

		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClick = Driver.getElement(driver, By.xpath("//span[text()='right click me']"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(rightClick).perform();
		
	}
	
	
	
	//span[text()='Edit']
}
