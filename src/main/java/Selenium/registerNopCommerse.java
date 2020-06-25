package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.Driver;
import Utilities.ConfigDetails;

public class registerNopCommerse {
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		register();
	}
	public static void register() throws InterruptedException  {
		driver = Driver.getWebDriver(ConfigDetails.getProperty("browser"));
		driver.manage().window().maximize();

		Thread.sleep(1000);
		driver.get(ConfigDetails.getProperty("App_url_"+ConfigDetails.getProperty("Environment")));
		
		Thread.sleep(1000);
		
		WebElement rbGender_Female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		if (rbGender_Female.isDisplayed()){
			rbGender_Female.click();
			
			WebElement txtFirstName = driver.findElement(By.cssSelector("input#FirstName"));
			txtFirstName.sendKeys("TestF1");
			Thread.sleep(500);
			
			WebElement txtLastName = driver.findElement(By.cssSelector("input[name='LastName']"));
			txtLastName.sendKeys("TestL1");
			Thread.sleep(500);
			
			WebElement weDateOfBirthDay = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
			Select ddDateOfBirthDay = new Select(weDateOfBirthDay);
			ddDateOfBirthDay.selectByVisibleText("3");
			Thread.sleep(500);
			
			WebElement weDateOfBirthMonth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
			Select ddDateOfBirthMonth = new Select(weDateOfBirthMonth);
			ddDateOfBirthMonth.selectByIndex(5);
			Thread.sleep(500);
			
			WebElement weDateOfBirthYear = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
			Select ddDateOfBirthYear = new Select(weDateOfBirthYear);
			ddDateOfBirthYear.selectByValue("2020");
			Thread.sleep(500);
			
			WebElement txtEmail = driver.findElement(By.xpath("//input[@id='Email']"));
			txtEmail.sendKeys("TestF1TestL1@gmail.com");
			Thread.sleep(500);
			
			WebElement txtCompany = driver.findElement(By.cssSelector("input[name='Company']"));
			txtCompany.sendKeys("XYZ Company");
			Thread.sleep(500);
			
			WebElement cbNewsletter = driver.findElement(By.xpath("//input[@id='Newsletter']"));
			
			if(cbNewsletter.isSelected()){
				System.out.println("Newsletter checkbox is already selcted, going to deselect it.");
				cbNewsletter.click();
				Thread.sleep(500);
			}
			
			WebElement txtPassword = driver.findElement(By.cssSelector("input[id='Password']"));
			txtPassword.sendKeys("testing123");
			Thread.sleep(500);
			
			WebElement txtConfirmPassword = driver.findElement(By.cssSelector("input[id='ConfirmPassword']"));
			txtConfirmPassword.sendKeys("testing123");
			Thread.sleep(500);
			
			WebElement btnRegister = driver.findElement(By.cssSelector("input#register-button"));
			btnRegister.click();
			
		}else{
			System.out.println("Page not loaded !!!");
		}
		
		WebElement lblResult = driver.findElement(By.xpath("//div[@class='result']"));
		
		String sResult = lblResult.getText();
		
		if (sResult.equalsIgnoreCase("Your registration completed")){
			System.out.println("Registered successfully");
			
			driver.findElement(By.xpath("//input[@name='register-continue']")).click();
			
		}else{
			System.out.println("Registered un-successfull");
		}
		
		Thread.sleep(2000);
		
	}
}
