package Hybridframework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "input-email")
	WebElement emailfield;

	public void emailField(String email) {

		emailfield.sendKeys(email);
	}

	@FindBy(id = "input-password")
	WebElement passwordfiled;

	public void passwordField(String password) {

		passwordfiled.sendKeys(password);
	}

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	public AccountPage loginbutton() {

		loginButton.click();
		return new AccountPage(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement warningmessage;

	public String WarningMessage() {

		String warningmess = warningmessage.getText();
		return warningmess;
	}

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public AccountPage login(String email, String password) {
		emailfield.sendKeys(email);
		passwordfiled.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);

	}
}
