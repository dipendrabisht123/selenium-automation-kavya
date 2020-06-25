package TestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGRID {
	WebDriver driver;
	
	@Test
	public void getOrangeTitle(){
		try {
			String sNodeURL = "http://192.168.1.2:33126/wd/hub";
			
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WIN10);
			
			driver = new RemoteWebDriver(new URL(sNodeURL), capability);
			
//		driver = new ChromeDriver();
			
			driver.get("http://testingmasters.com/hrm");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			System.out.println("Title OrangeHRM: "+ driver.getTitle());
			
			driver.quit();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
