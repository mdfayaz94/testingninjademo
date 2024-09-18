package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import junit.framework.Assert;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEMail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement chkcheckbox;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	// ActionMethods

	public void SetFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void SetLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void SetEmail(String email) {
		txtEMail.sendKeys(email);
	}

	public void SetTelephone(String phonenumber) {
		txtTelephone.sendKeys(phonenumber);
	}

	public void SetPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void SetConfirmPassword(String pwd) {
		txtPasswordConfirm.sendKeys(pwd);
	}

	public void SetCheckbox() {
		chkcheckbox.click();
	}

	public void Clickcontinue() {
		btncontinue.click();
	}
	
	public String GetmsgConfirmation() {
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
}
