package Hybridframework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editaccountinfo;

	public boolean editAccountInfo() {

		boolean displayedstatus = editaccountinfo.isDisplayed();

		return displayedstatus;
	}

	public AccountPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
}
