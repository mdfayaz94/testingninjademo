package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkmyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(linkText="Login") WebElement linkLogin;
	
	//Action Method
	public void ClickmyAccount() {
		lnkmyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void Clicklogin() {
		linkLogin.click();
		
	}
}
