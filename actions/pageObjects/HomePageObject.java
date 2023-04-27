package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWelcomMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOM_MSG_TEXT);
		return isElementDisplayedInDOM(driver, HomePageUI.WELCOM_MSG_TEXT);
	}
}
