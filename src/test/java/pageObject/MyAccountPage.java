package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement ClkLogout;

	public boolean ismsgHeaderMsg() {
		try {
			return msgHeading.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}

	public void logout() {
		ClkLogout.click();
	}
}
