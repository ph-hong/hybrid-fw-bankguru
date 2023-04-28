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

public class New_Customer_NC16_NC17 extends BaseTest {
	WebDriver driver;
	NewCustomerPageObject newCustomerPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String userID, emailID, password, loginPageUrl;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();

		registerPage = loginPage.clickHereLink();

		emailID = "test" + randomNumber() + "@live.com";
		registerPage.inputEmailID(emailID);
		registerPage.clickSubmitButton();

		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();

		loginPage = registerPage.openLoginPage(loginPageUrl);
		loginPage.inputUserID(userID);
		loginPage.inputPassword(password);

		homePage = loginPage.clickSubmitButton();
	}

	/*
	 * Verify PIN field
	 */

	@Test
	public void NC16_PIN_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("pinno");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "PIN Code must not be blank");
	}

	@Test
	public void NC17_PIN_must_be_numeric() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("pinno", "1234pin");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "Characters are not allowed");
	}

	@Test
	public void NC18_PIN_Code_must_have_6_Digits() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("pinno", "1233");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "PIN Code must have 6 Digits");
	}

	@Test
	public void NC19_PIN_cannot_have_special_character() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("pinno", "1233#$");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "Special characters are not allowed");
	}

	@Test
	public void NC20_First_character_of_PIN_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("pinno", " ");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "First character can not have space");
	}

	@Test
	public void NC21_PIN_cannot_have_blank_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("pinno", "1233 3");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "Characters are not allowed");
	}

	/*
	 * Verify Mobile Number field
	 */

	@Test
	public void NC22_Mobile_Number_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("telephoneno");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Mobile no must not be blank");
	}

	@Test
	public void NC23_Mobile_Number_cannot_have_blank_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("telephoneno", "123 33");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Characters are not allowed");
	}

	@Test
	public void NC24_Mobile_Number_cannot_have_special_character() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("telephoneno", "1233#$");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Special characters are not allowed");
	}

	@Test
	public void NC25_First_character_of_Mobile_Number_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("telephoneno", "1233 3");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Characters are not allowed");
	}

	/*
	 * Verify Email field
	 */

	@Test
	public void NC26_Email_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("emailid");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID must not be blank");
	}

	@Test
	public void NC27_Email_must_be_in_correct_format() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("emailid", "guru12@gmail");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "guru12");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "Guru12@");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "guru12@gmail.");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "guru12gmail.com");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");
	}

	@Test
	public void NC28_Email_cannot_have_blank_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("emailid", "gruru 12");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");
	}

	/*
	 * Verify Password field
	 */

	@Test
	public void NC29_Password_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("password");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("password"), "Password must not be blank");
	}

	/*
	 * Verify Reset Button
	 */
	@Test
	public void NC30_All_New_Customer_data_are_reset() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("name", "Auto Bank");
		newCustomerPage.inputToTextboxByName("dob", "11/10/1990");
		newCustomerPage.inputToTextboxByName("addr", "Hoang Ha street, Dong Hung Dist");
		newCustomerPage.inputToTextboxByName("city", "Ho Chi Minh");
		newCustomerPage.inputToTextboxByName("state", "Ba Dinh");
		newCustomerPage.inputToTextboxByName("pinno", "778899");
		newCustomerPage.inputToTextboxByName("telephoneno", "123123123");
		newCustomerPage.inputToTextboxByName("emailid", "guru@gmail.com");
		newCustomerPage.inputToTextboxByName("password", "Guru123!@");

		newCustomerPage.clickResetButton();

		Assert.assertEquals(newCustomerPage.getTextByName("name"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("dob"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("addr"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("city"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("state"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("pinno"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("telephoneno"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("emailid"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("password"), "");
	}

	/*
	 * Register New Customer Successfully!
	 */
	@Test
	public void NC31_Add_new_customer_successfully() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("name", "Auto Bank");
		newCustomerPage.inputToTextboxByName("dob", "11/10/1990");
		newCustomerPage.inputToTextboxByName("addr", "Hoang Ha street");
		newCustomerPage.inputToTextboxByName("city", "Ho Chi Minh");
		newCustomerPage.inputToTextboxByName("state", "Ba Dinh");
		newCustomerPage.inputToTextboxByName("pinno", "778899");
		newCustomerPage.inputToTextboxByName("telephoneno", "123123123");
		newCustomerPage.inputToTextboxByName("emailid", emailID);
		newCustomerPage.inputToTextboxByName("password", password);

		newCustomerPage.clickSubmitButton();

		Assert.assertEquals(newCustomerPage.getRegisterMsg(), "Customer Registered Successfully!!!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
