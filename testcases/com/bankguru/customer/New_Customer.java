package com.bankguru.customer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class New_Customer extends BaseTest {
	WebDriver driver;
	NewCustomerPageObject newCustomerPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String userID, password, loginPageUrl;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();

		registerPage = loginPage.clickHereLink();
		registerPage.inputEmailID("test" + randomNumber() + "@live.com");
		registerPage.clickSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();

		loginPage = registerPage.openLoginPage(loginPageUrl);
//		userID = "mngr495936";
//		password = "ajYhanE";
		loginPage.inputUserID(userID);
		loginPage.inputPassword(password);

		homePage = loginPage.clickSubmitButton();
	}

	/*
	 * Verify Customer Name field
	 */

	public void NC01_Name_Cannot_Be_Blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToCustomer();

		Assert.assertEquals(newCustomerPage.getValidateCustomerNameMsg(), "Customer name must not be blank");
	}

	@Test
	public void NC02_Name_cannot_be_numeric() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputValueToCustomerName("123");
		Assert.assertEquals(newCustomerPage.getValidateCustomerNameMsg(), "Numbers are not allowed");

		newCustomerPage.inputValueToCustomerName("name 123");
		Assert.assertEquals(newCustomerPage.getValidateCustomerNameMsg(), "Numbers are not allowed");
	}

	@Test
	public void NC03_Name_cannot_have_special_characters() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputValueToCustomerName("!@#");
		Assert.assertEquals(newCustomerPage.getValidateCustomerNameMsg(), "Special characters are not allowed");

		newCustomerPage.inputValueToCustomerName("name!@#");
		Assert.assertEquals(newCustomerPage.getValidateCustomerNameMsg(), "Special characters are not allowed");
	}

	@Test
	public void NC04_First_character_of_Name_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputValueToCustomerName(" ");

		Assert.assertEquals(newCustomerPage.getValidateCustomerNameMsg(), "First character can not have space");
	}

	/*
	 * Verify Date of Birth field
	 */
	@Test
	public void NC05_Date_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToDateOfBirth();
		Assert.assertEquals(newCustomerPage.getValidateDateOfBirthMsg(), "Date Field must not be blank");
	}

	/*
	 * Verify Address field
	 */
	@Test
	public void NC06_Address_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToAddress();

		Assert.assertEquals(newCustomerPage.getValidateAddressMsg(), "Address Field must not be blank");
	}

	@Test
	public void NC07_First_character_of_Address_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputValueToAddress(" ");

		Assert.assertEquals(newCustomerPage.getValidateAddressMsg(), "First character can not have space");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
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
