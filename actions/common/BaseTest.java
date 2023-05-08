package common;

import java.util.Random;
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/v4/");

		System.out.println("Driver ID in Base Test = " + driver.toString());
		return driver;
	}
	
	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
	
	public void sleepInsecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
