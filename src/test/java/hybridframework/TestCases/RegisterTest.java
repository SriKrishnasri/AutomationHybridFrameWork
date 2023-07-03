package hybridframework.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Hybridframework.Pages.HomePage;
import Hybridframework.Pages.RegisterPage;
import Hybridframework.utilites.utlitiesPage;
import hybridframework.BaseClass.BaseTest;

public class RegisterTest extends BaseTest {
	public WebDriver driver;
	RegisterPage registerpage;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void BeforeMethod() {

		driver = intialData(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.accountOption();
		registerpage = homepage.registerButton();
	}

	@Test(priority = 1)
	public void registerAccountWithManadatoryFiled() {

		registerpage.RegisterWithMandatoryFiled(utlitiesPage.randomString(), utlitiesPage.randomString(),
				utlitiesPage.randomString() + "@gmail.com", utlitiesPage.randomNumber(), "9346118066");

		Assert.assertEquals(registerpage.AC_CreateMessage(), dataProp.getProperty("AC_create_Message"));
	}

	@Test(priority = 2)
	public void registerAccountWithAllCredential() {

		registerpage.RegisterwithexistingFiled(utlitiesPage.randomString(), utlitiesPage.randomString(),
				utlitiesPage.randomString() + "@gmail.com", utlitiesPage.randomNumber(), "9346118066");

		Assert.assertEquals(registerpage.AC_CreateMessage(), dataProp.getProperty("AC_create_Message"));

	}

	@Test(priority = 3)
	public void registerWithExistingFiled() {

		registerpage.RegisterwithexistingFiled(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("mobile_no"), prop.getProperty("validPassword"));

		Assert.assertEquals(registerpage.AC_CreatedWarningMessage(), dataProp.getProperty("warn_Message2"));
	}

	@Test(priority = 4)
	public void registerWithoutFilingAnyDetails() {
		registerpage.ContinueButton();
		Assert.assertEquals(registerpage.AC_CreatedWarningMessage(), dataProp.getProperty("privacypolicy_warn"));

		Assert.assertEquals(registerpage.FirstNameWarning(), dataProp.getProperty("firstname_warn"));

		Assert.assertEquals(registerpage.LastnameWarning(), dataProp.getProperty("lastname_warn"));

		Assert.assertEquals(registerpage.EmailWarning(), dataProp.getProperty("email_warn"));

		Assert.assertEquals(registerpage.TelePhoneWarn(), dataProp.getProperty("telephone_warn"));

		Assert.assertEquals(registerpage.passwordWarning(), dataProp.getProperty("password_warn"));

	}
}
