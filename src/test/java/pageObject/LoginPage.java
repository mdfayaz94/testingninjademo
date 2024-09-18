package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtLemail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtLpwd;
	@FindBy(xpath="//input[@value='Login']") WebElement clkLlogin;
	
	
	public void SetEmail(String email) {
		txtLemail.sendKeys(email);
	}
	
	public void Setpwd(String pwd) {
		txtLpwd.sendKeys(pwd);
	}
	
	public void clklogin() {
		clkLlogin.click();
	}
}
