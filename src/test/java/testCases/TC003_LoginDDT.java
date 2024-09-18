package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class) // getting data from different  class
	public void Verify_loginDDT(String email,String Pwd,String ExpectedRes) {
	try
	{

	logger.info("*** Starting of TC003_LoginDDt***");
	
	HomePage hm=new HomePage(driver);
	hm.ClickmyAccount();
	hm.Clicklogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.SetEmail(email);
	lp.Setpwd(Pwd);
	lp.clklogin();
	
	MyAccountPage map=new MyAccountPage(driver);
	boolean targetmsg=map.ismsgHeaderMsg();
	
	if(ExpectedRes.equalsIgnoreCase("Valid")) {
		if(targetmsg==true) {
			map.logout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(ExpectedRes.equalsIgnoreCase("Invalid")) {
		if(targetmsg==true) {
			map.logout();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
	}
	
	
	}
	catch(Exception e) {
		Assert.fail();
		
	}
	finally {
		logger.info("************ TC003_Login DDT is Finished***********");
	}
	
	}
	
	

}

