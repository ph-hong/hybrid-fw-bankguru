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

	/*
	 * Customer
	 */
	public void tabToCustomer() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		pressKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
	}

	public void inputValueToCustomerName(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, value);
	}

	public String getValidateCustomerNameMsg() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_MSG);
		return getElementText(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_MSG);
	}

	/*
	 * Date of birth
	 */
	public void tabToDateOfBirth() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		pressKeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, Keys.TAB);
	}

	public String getValidateDateOfBirthMsg() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_DATE_OF_BIRTH_MSG);
		return getElementText(driver, NewCustomerPageUI.VALIDATE_DATE_OF_BIRTH_MSG);
	}

	/*
	 * Address
	 */
	public void tabToAddress() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
		pressKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, Keys.TAB);
	}

	public void inputValueToAddress(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, value);
	}

	public String getValidateAddressMsg() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_ADDRESS_MSG);
		return getElementText(driver, NewCustomerPageUI.VALIDATE_ADDRESS_MSG);
	}
}
