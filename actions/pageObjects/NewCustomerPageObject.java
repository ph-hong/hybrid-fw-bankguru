package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void tabToTextBoxByName(String textboxName) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		pressKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, Keys.TAB, textboxName);
	}

	public void inputToTextboxByName(String textboxName, String valueToInput) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, valueToInput, textboxName);
	}

	public String getValidateMsgByName(String textboxName) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_VALAIDATE_MSG, textboxName);
		return getElementText(driver, NewCustomerPageUI.DYNAMIC_VALAIDATE_MSG, textboxName);
	}
}