package testCases;

//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginClass extends BaseClass {

	//public WebDriver driver;

	@Test
	public void Logintest() {
		try
		{
		logger.info("*** Starting of TC002_LoginTest***");
		
		HomePage hm=new HomePage(driver);
		hm.ClickmyAccount();
		hm.Clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(p.getProperty("email"));
		lp.Setpwd(p.getProperty("password"));
		lp.clklogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetmsg=map.ismsgHeaderMsg();
		Assert.assertTrue(targetmsg);
		}
		catch(Exception e) {
			Assert.fail();
			
		}
		logger.info("** Testing Ends**");
	}

}
