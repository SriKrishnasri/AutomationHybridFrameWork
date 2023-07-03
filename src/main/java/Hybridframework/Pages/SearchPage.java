package Hybridframework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='search']/descendant::button")
	WebElement searchbutton;

	public void SearchButton() {
		searchbutton.click();
	}

	@FindBy(xpath = "//a[text()='HP LP3065']")
	WebElement HPdisplay;

	public String HP_Display() {
		String hpdisplay = HPdisplay.getText();
		return hpdisplay;
	}

	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	WebElement productnomatch;

	public String ProductNotMatch() {
		String productNOmatch = productnomatch.getText();
		return productNOmatch;
	}
}
