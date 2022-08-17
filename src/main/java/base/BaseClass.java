package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import common.Commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.CreateNewAccount;
import objects.HomePage;
import objects.Register;
import utils.Configuration;

public class BaseClass {

	Configuration configuration = new Configuration(null);
	
	public WebDriver driver;//if its default then use WebDriver getDriver method which return driver;
	protected Commons commons;
	protected HomePage homePage;
	protected Register register;
	protected CreateNewAccount createNewAccount;


	@BeforeMethod
	public void setup() {
		driver = localDriver("chrome");
		driver.manage().window().maximize();
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		initClasses();
	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		return driver;
	}
 
//	protected WebDriver getDriver() {
//		return driver;
//	}
	
	protected void initClasses() {
		commons = new Commons();
		homePage = new HomePage(driver, commons);
//		register = new Register(driver, commons);
		createNewAccount = new CreateNewAccount(driver, commons);
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}
}
