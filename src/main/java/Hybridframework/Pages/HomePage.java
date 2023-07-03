package Hybridframework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// ACCOUNT
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountDropMenu;

	public void accountOption() {

		myAccountDropMenu.click();
	}

	// LOGINBUTTON
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginOption;

	public LoginPage loginoption() {

		loginOption.click();
		return new LoginPage(driver);
	}

	// REGISTER
	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;

	public RegisterPage registerButton() {
		register.click();
		return new RegisterPage(driver);
	}

	// SEARCH
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchfiled;

	public SearchPage SearchFiled(String text) {
		searchfiled.sendKeys(text);
		return new SearchPage(driver);

	}

}
