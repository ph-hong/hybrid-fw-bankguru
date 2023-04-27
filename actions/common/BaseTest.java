package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;

		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
			
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;
			
		default:
			throw new RuntimeException("Browser name is invalid.");
		}
		
//		case "firefox":
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//			break;
//
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//			break;
//
//		case "edge":
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			throw new RuntimeException("Browser name is not valid.");
//		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/v4/");
		
		System.out.println("Driver ID in Base Test = " + driver.toString());
		return driver;
	}
	

}
