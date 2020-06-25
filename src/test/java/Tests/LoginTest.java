package Tests;

import org.testng.annotations.Test;

import Pages.LoginPage;
import TestNG.TestBase;
import Utilities.ConfigDetails;

public class LoginTest extends TestBase{

	@Test
	public void loginToHRM(){
		
		LoginPage login = new LoginPage();
		login.login(ConfigDetails.getProperty("user_Name"), ConfigDetails.getProperty("user_pwd"));
		
	}
}
