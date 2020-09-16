package utility;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import static docker.StartDocker.*;
import static docker.StopDocker.*;

public class Driver {

	protected static WebDriver driver;
	private DesiredCapabilities dp;

	@BeforeTest
	public void getDriver() throws Exception {

		dp = DesiredCapabilities.chrome();
		String host = "localhost";

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("fireFox")) {
			dp = DesiredCapabilities.firefox();
		}

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}
		//ChromeOptions chromOptions = new ChromeOptions();
		//chromOptions.merge(dp);
		String completeURL = "http://" + host + ":4444/wd/hub";
		driver = new RemoteWebDriver(new URL(completeURL), dp);
		

		
		/*WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
	}

	//@BeforeSuite
	public static void dockerStart() throws Exception, Exception {
		startfile();
	}

	//@AfterSuite
	public static void dockerStop() throws Exception, Exception {
		stopfile();
	}

	public void navigateToUrl(String url) {
		driver.get(url);
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();

	}
}