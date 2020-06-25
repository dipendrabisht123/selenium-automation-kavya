package Selenium;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import Base.Driver;
import Utilities.ConfigDetails;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleLoginFlow {

	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
//		driver = Driver.initializeBrowser(ConfigDetails.getProperty("browser"));
//		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		
		login();
//		launchGoogle();
//		quitBrowser();
	}

	public static void login() throws InterruptedException, IOException, AWTException {
		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		driver.manage().window().maximize();

		Thread.sleep(1000);
		driver.get(ConfigDetails.getProperty("App_url_"+ConfigDetails.getProperty("Environment")));
		
		captureSSUsingRobot("URL_Launched");
		
		Thread.sleep(1000);
		WebElement txtUserName = driver.findElement(By.id("txtUsername"));
		WebElement txtPWD = driver.findElement(By.id("txtPassword"));
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		
		txtUserName.sendKeys(ConfigDetails.getProperty("user_Name"));
		
		Thread.sleep(1000);
		txtPWD.sendKeys(ConfigDetails.getProperty("user_pwd"));
		Thread.sleep(1000);
		btnLogin.click();
		Thread.sleep(2000);
		
		/*WebElement linkDashboard = driver.findElement(By.id("menu_dashboard_index"));
		List<WebElement> listLinkDashboard = driver.findElements(By.id("menu_dashboard_index"));*/
		
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
		
		fWait.withTimeout(Duration.ofSeconds(20));
		fWait.pollingEvery(Duration.ofSeconds(1));
		
		WebElement linkDashboard = fWait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				
				return t.findElement(By.id("menu_dashboard_index"));
			}
		});
		
		
		if (linkDashboard.isDisplayed()){
			System.out.println("Dashboard link is displayed, we are at home page !!");
		}else{
			System.out.println("Dashboard link is NOT displayed, fail to load the home page !!");
		}
		captureSSUsingTakesScreenshot("Login");
		captureSSUsingRobot("Logged-in");
		
		if (linkDashboard.isEnabled()){
			System.out.println("Dashboard link is enabled, we are at home page !!");
		}
		
		System.out.println("Selected? : " +linkDashboard.isSelected());		
		
		
		quitBrowser();
	}
	
	public static void launchGoogle() throws InterruptedException {
		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		driver.get("https://www.google.com");
		Thread.sleep(1000);
		
	}
	
	public static void quitBrowser(){
		driver.close();
		driver.quit();
	}
	
	public static void captureSSUsingTakesScreenshot(String sScreenshotFile) throws IOException{
		TakesScreenshot tss = (TakesScreenshot) driver;
		
		File image = tss.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(image, new File ("./Screenshot/"+sScreenshotFile+"_"+System.currentTimeMillis()+".jpeg"));
		
	}
	
	public static void captureSSUsingRobot(String sScreenshotFile) throws AWTException, IOException {
		
		Robot robo = new Robot();
		
		Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		
		BufferedImage image = robo.createScreenCapture(rect);
		
		ImageIO.write(image, "jpeg", new File ("./Screenshot/"+sScreenshotFile+"_"+System.currentTimeMillis()+".jpeg"));
	}

}
