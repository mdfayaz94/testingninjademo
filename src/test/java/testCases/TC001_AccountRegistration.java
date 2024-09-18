package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{
	
	//public WebDriver driver;
	
	
	 
	@Test
	public void Account_Registration() {
		try {
			
		logger.info("Test Case Execution Starts");
		HomePage hp=new HomePage(driver);
		logger.info(" ***** Clicked on MyAccount Option****");
		hp.ClickmyAccount();
		logger.info(" ***** Clicked on Register Option****");
		hp.clickRegister();
		
		logger.info("Registration process starts");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
//		regpage.SetFirstName("John");
//		regpage.SetLastName("Dave");
//		regpage.SetEmail("asdaraf@gmail.com");
//		regpage.SetTelephone("321548551");
//		regpage.SetPassword("xyz@12345");
//		regpage.SetConfirmPassword("xyz@12345");
//		regpage.SetCheckbox();
//		regpage.Clickcontinue();
//		String confmsg=regpage.GetmsgConfirmation();		
//		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		regpage.SetFirstName(randomString().toUpperCase());
		regpage.SetLastName(randomString().toUpperCase());
		regpage.SetEmail(randomString()+ "@gmail.com");
		regpage.SetTelephone(randomnumeric());
		
		String password=ranpwd();
		regpage.SetPassword(password);
		regpage.SetConfirmPassword(password);
		regpage.SetCheckbox();
		regpage.Clickcontinue();
		
		logger.info("confimation message validation");
		String confmsg=regpage.GetmsgConfirmation();	
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		}
		catch(Exception e) {
			logger.error("Test failed...");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		logger.info("Test case Execution is finished");
		
		
	}
	
	
	
	
	
	
}
