package pageUIs;

public class NewCustomerPageUI {
	public static final String CUSTOMER_NAME_TEXTBOX = "NAME=name";
	public static final String DATE_OF_BIRTH_TEXTBOX = "ID=dob";
	public static final String ADDRESS_TEXTBOX = "NAME=addr";
	public static final String CITY_TEXTBOX = "NAME=city";
	public static final String STATE_TEXTBOX = "NAME=state";
	public static final String PIN_TEXTBOX = "NAME=pinno";
	public static final String MOBILE_PHONE_NUMBER = "NAME=telephoneno";
	public static final String EMAIL_TEXTBOX = "NAME=emailid";
	public static final String PASSWORD_TEXTBOX = "NAME=password";
	public static final String SUBMIT_BTN = "NAME=sub";
	public static final String RESET_BTN = "NAME=res";

	public static final String VALIDATE_CUSTOMER_NAME_MSG = "XPATH=//input[@name='name']/following-sibling::label";
	public static final String VALIDATE_DATE_OF_BIRTH_MSG = "XPATH=//input[@name='dob']/following-sibling::label";
	public static final String VALIDATE_ADDRESS_MSG = "XPATH=//textarea[@name='addr']/following-sibling::label";
}
