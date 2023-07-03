package hybridframework.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Hybridframework.Pages.HomePage;
import Hybridframework.Pages.SearchPage;
import hybridframework.BaseClass.BaseTest;

public class SearchTest extends BaseTest {
	HomePage homepage;
	SearchPage searchpage;

	public SearchTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void BeforeMethod() {

		driver = intialData(prop.getProperty("browser"));
		homepage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		searchpage = homepage.SearchFiled("HP");
		searchpage.SearchButton();
		Assert.assertEquals(searchpage.HP_Display(), "HP LP3065");

	}

	@Test(priority = 2)
	public void verifySearchWithInValidProduct() {
		searchpage = homepage.SearchFiled("honda");
		searchpage.SearchButton();
		Assert.assertEquals(searchpage.ProductNotMatch(), dataProp.getProperty("NoProductmatching"));

	}

	@Test(priority = 3)
	public void searchWithoutAnyProduct() {
		searchpage = new SearchPage(driver);
		searchpage.SearchButton();
		Assert.assertEquals(searchpage.ProductNotMatch(), dataProp.getProperty("NoProductmatching"));

	}
}
