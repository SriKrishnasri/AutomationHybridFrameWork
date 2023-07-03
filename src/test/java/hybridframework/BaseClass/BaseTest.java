package hybridframework.BaseClass;

import java.io.File;
import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public BaseTest() {

		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\Hybridframework\\config\\config.properties");

		dataProp = new Properties();
		File dataPropFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\Hybridframework\\TestData\\testdata.properties");
		try {
			FileInputStream datafis = new FileInputStream(dataPropFile);
			
			dataProp.load(datafis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream(propFile);

			prop.load(fis);
		} catch (Throwable e) {

			e.printStackTrace();
		}
	}

	public WebDriver intialData(String browserName) {

		if (browserName.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equals("edge")) {

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));

		return driver;
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
