package hybridframework.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Hybridframework.Pages.AccountPage;
import Hybridframework.Pages.HomePage;
import Hybridframework.Pages.LoginPage;
import Hybridframework.utilites.utlitiesPage;
import hybridframework.BaseClass.BaseTest;

public class LoginTest extends BaseTest {
	public WebDriver driver;
	LoginPage loginpage;
	AccountPage accountpage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod() {

		driver = intialData(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.accountOption();
		loginpage = homepage.loginoption();
	}

	@DataProvider(name = "validcredentialsupplier")
	public Object[][] testSupplyData() {

		Object[][] data = utlitiesPage.getTestDataFromExel("Login");

		return data;

	}

	@Test(priority = 1, dataProvider = "validcredentialsupplier")
	public void verifyWithValidCredential(String email, String password) {

		accountpage = loginpage.login(email, password);

		Assert.assertTrue(accountpage.editAccountInfo());

	}

	@Test(priority = 2)
	public void verifyWithInvalidCreditnial() {
		loginpage.login(utlitiesPage.randomString() + "@gmail.com", utlitiesPage.randomNumber());

		Assert.assertEquals(loginpage.WarningMessage(), dataProp.getProperty("warningMessage"));
	}

	@Test(priority = 3)
	public void verifyInvalidEmail_ValidPassword() {
		loginpage.login(utlitiesPage.randomString() + "@gmail.com", prop.getProperty("validPassword"));
		Assert.assertEquals(loginpage.WarningMessage(), dataProp.getProperty("warningMessage"));

	}

	@Test(priority = 4)
	public void verifyValidEmail_InvalidPassword() {
		loginpage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginpage.WarningMessage(), dataProp.getProperty("warningMessage"));

	}

	@Test(priority = 5)
	public void verifyWithoutCredential() {

		loginpage.loginbutton();

		Assert.assertEquals(loginpage.WarningMessage(), dataProp.getProperty("warningMessageDDD"));

	}

}
