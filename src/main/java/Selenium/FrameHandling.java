package Selenium;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Driver;
import Utilities.ConfigDetails;

public class FrameHandling {
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		handleFrames();


	}
	
	public static void handleFrames() throws InterruptedException{
		
		
		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		driver.manage().window().maximize();

		Thread.sleep(1000);
		driver.get(ConfigDetails.getProperty("App_url_"+ConfigDetails.getProperty("Environment")));
		
		Thread.sleep(1000);
		
		WebElement frmOverview = driver.findElement(By.xpath("//frame[@name='packageListFrame']"));
		
		driver.switchTo().frame(0);
		
		List<WebElement> listTopics = driver.findElements(By.xpath("//div[h2[text()='Packages']]//a"));
		
		Iterator<WebElement> it = listTopics.iterator();
		int iCounter = 1;
		while (it.hasNext() && iCounter <=5){
						
			System.out.println(it.next().getText());
			iCounter++;
		}
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		
		System.out.println(driver.findElement(By.xpath("//body//h1")).getText());
		
		
		Thread.sleep(1000);
		
		driver.quit();
		
	}

}
