package Selenium;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Driver;
import Utilities.ConfigDetails;

public class JSAlerts {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		handleAlerts();

	}

	public static void handleAlerts() throws InterruptedException, AWTException, IOException {

		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		driver.manage().window().maximize();

		Thread.sleep(1000);
		driver.get(ConfigDetails.getProperty("App_url_" + ConfigDetails.getProperty("Environment")));

		Thread.sleep(1000);

		WebElement btnAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));

		btnAlert.click();

		Alert alert = driver.switchTo().alert();
		
		
		captureSSUsingRobot("AlertOpen_Robo");
		captureSSUsingTakesScreenshot("AlertOpen_Selenium");
		
		System.out.println(alert.getText());
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(2000);

		WebElement btnAlertConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		btnAlertConfirm.click();

		Thread.sleep(1000);

		System.out.println(alert.getText());

		Thread.sleep(1000);
		alert.accept();

		Thread.sleep(1000);
		
		WebElement btnAlertPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		btnAlertPrompt.click();

		Thread.sleep(1000);
		
		alert.sendKeys("Hello World");
		
		Thread.sleep(1000);
		alert.accept();

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
