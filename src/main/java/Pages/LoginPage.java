package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Driver;
import Utilities.ConfigDetails;

public class LoginPage extends Driver{
	
	@FindBy (id="txtUsername")
	WebElement txtUserName;
	
	@FindBy (id="txtPassword")
	WebElement txtPWD;
	
	@FindBy (id="btnLogin")
	WebElement btnLogin;
	
	By weUserName = By.id("txtUsername");
	
		
	public WebElement getWeUserName() {
		return driver.findElement(weUserName);
	}


	public void setWeUserName(By weUserName) {
		this.weUserName = weUserName;
	}


	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	
	public void login(String sID, String sPWD){
		driver.get(ConfigDetails.getProperty("App_url_"+ConfigDetails.getProperty("Environment")));
		
		getWeUserName().sendKeys("");
		
		txtUserName.sendKeys(sID);
		txtPWD.sendKeys(sPWD);
		
		btnLogin.click();
	}
	
}
