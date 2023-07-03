package Hybridframework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstname;

	public void FirstName(String firstnametext) {
		firstname.sendKeys(firstnametext);
	}

	@FindBy(id = "input-lastname")
	WebElement lastname;

	public void LastName(String lastnametext) {
		lastname.sendKeys(lastnametext);
	}

	@FindBy(id = "input-email")
	WebElement email;

	public void Email(String emailtext) {
		email.sendKeys(emailtext);
	}

	@FindBy(id = "input-telephone")
	WebElement telephone;

	public void TelePhone(String number) {
		telephone.sendKeys(number);
	}

	@FindBy(id = "input-password")
	WebElement inputpassword;

	public void InputPassword(String passwordtext) {
		inputpassword.sendKeys(passwordtext);
	}

	@FindBy(id = "input-confirm")
	WebElement confirmpassword;

	public void ConfirmPassword(String passwordtext) {
		confirmpassword.sendKeys(passwordtext);
	}

	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreebutton;

	public void AgreeButton() {
		agreebutton.click();
	}

	@FindBy(xpath = "//input[@value='0']")
	WebElement subscribebutton;

	public void SubscribeButton() {
		subscribebutton.click();
	}

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebutton;

	public void ContinueButton() {
		continuebutton.click();
	}

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement accountcreatemessage;

	public String AC_CreateMessage() {
		String AccountCreatemessage = accountcreatemessage.getText();
		return AccountCreatemessage;
	}

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement AlreadyAccountCreatedWarningMessage;

	public String AC_CreatedWarningMessage() {
		String Accountwarningmess = AlreadyAccountCreatedWarningMessage.getText();
		return Accountwarningmess;
	}

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	WebElement firstnamewarning;

	public String FirstNameWarning() {
		String firstNamewarning = firstnamewarning.getText();
		return firstNamewarning;
	}

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	WebElement lastnamewarning;

	public String LastnameWarning() {
		String lastNamewarning = lastnamewarning.getText();
		return lastNamewarning;
	}

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	WebElement emailwarning;

	public String EmailWarning() {
		String emailwarningmessage = emailwarning.getText();
		return emailwarningmessage;
	}

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	WebElement telephonewarning;

	public String TelePhoneWarn() {
		String telephonewarningmessage = telephonewarning.getText();
		return telephonewarningmessage;
	}

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	WebElement passwordwarningmessage;

	public String passwordWarning() {
		String passwordwarningmess = passwordwarningmessage.getText();
		return passwordwarningmess;
	}

	public void RegisterWithMandatoryFiled(String firstnametext, String lastnametext, String emailtext, String number,
			String passwordtext) {
		firstname.sendKeys(firstnametext);
		lastname.sendKeys(lastnametext);
		email.sendKeys(emailtext);
		telephone.sendKeys(number);
		inputpassword.sendKeys(passwordtext);
		confirmpassword.sendKeys(passwordtext);
		agreebutton.click();
		continuebutton.click();
	}

	public void RegisterwithexistingFiled(String firstnametext, String lastnametext, String emailtext, String number,
			String passwordtext) {
		firstname.sendKeys(firstnametext);
		lastname.sendKeys(lastnametext);
		email.sendKeys(emailtext);
		telephone.sendKeys(number);
		inputpassword.sendKeys(passwordtext);
		confirmpassword.sendKeys(passwordtext);
		subscribebutton.click();
		agreebutton.click();
		continuebutton.click();
	}

}
