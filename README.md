HYBRID FRAMEWORK BANK GURU 
===================
_I have been developing a demo framework for banking domain based on Bank Guru demo website_

_This framework is flexible to apply to the Maven project._


**I. Pre-requisites**
---------------------
*   TEST CASE

**Link:** [https://tinyurl.com/ec55bankgurutestcases](https://tinyurl.com/ec55bankgurutestcases)

### 1\. For development

*   JDK 11

_Download link_: [https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html]( https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

*   Eclipse IDEA

_Download link_: [https://www.eclipse.org]( https://www.eclipse.org)

### 2\. For running tests only

*   TestNG library ver version 6.14.3

_Download link_: [https://mvnrepository.com/artifact/org.testng/testng/6.14.3]( https://mvnrepository.com/artifact/org.testng/testng/6.14.3)

*   WebDriverManager version 5.3.2

_Download link_: [https://jar-download.com/?search_box=WebDriverManager]( https://jar-download.com/?search_box=WebDriverManager)


**II. Repository**
------------------

**Link:** [https://github.com/ph-hong/hybrid-fw-bankguru](https://github.com/ph-hong/hybrid-fw-bankguru)

### 1\. For development

*   branch: _master_

### 2\. For running tests only

*   branch: _master_

**III. Project structure**
--------------------------

### 1\. testcases

*   __<_pakage's name_\>__
    *   __<_class's name_\>.java__
        
        > Each class/file is a test suite. Each suite includes many tests.

### 2\. actions
*   _common_
    *   _BasePage.java_
        > store wrapper methods of Selenium API.
        * click/type/select
        * isEnabled/isDisplayed
        * getText/getTitle
    
    *   _BaseTest.java_
        > store common methods for the testcases layer.
        * open browser
        * closer browser
        * random number
        
    *   _PageGeneratorManager_
        > used to generate page object.
        
*   _pageObjects_
    > store Page Objects
    *   _HomePageObject_
    *   _LoginPageObject_
    *   _RegisterPageObject_
    *   _***PageObject_
    
### 3\. interfaces
> store Page UI where element locators are defined.

*   _HomePageUI_
*   _LoginPageUI_
*   _RegisterPageUI_
*   _***PageUI_

### 4\. resources/*.xml

> settings of TestNG for tests.
> 
### 5\. libraries

> list of essential libraries of the project.

### 6\. .gitignore

> list of files/folder to be ignored for commit/push to repository.


**IV. How to set up a run**
---------------------------

1.  Open <resources/*.xml>
2.  Add the class name of tests to run
3.  Comment class name of tests not to run with `` `<!-- -->   ` ``

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite parallel="false" name="Bank Guru">

	<test name="Run on CHROME browser">
		<parameter name="browser" value="chrome">
		</parameter>

		<classes>
			<class name="com.bankguru.customer.New_Customer" />
		</classes>

	</test>

</suite>
```

**V. How to run**
-----------------

### 1\. For development

*   **Run in Eclipse:**
1. Open Eclipse IDE
2. Right click on the <resources/*.xml> file, move the cursor down to Run As and then click on the 1 TestNG Suite.
*   **view report:**

`(updating)`

**VI. Sample test**
-------------------

```xml
public class Customer_Login extends BaseTest {
        WebDriver driver;
        RegisterPageObject registerPage;
        LoginPageObject loginPage;
        HomePageObject homePage;
        String userID, password, loginPageUrl;

        @Parameters({ "browser" })
        @BeforeClass
        public void beforeClass(String browserName) {
            driver = getBrowserDriver(browserName);

            loginPage = PageGeneratorManager.getLoginPage(driver);

            loginPageUrl = loginPage.getLoginPageUrl();
        }

        @Test
        public void LG_01_Register() {
            registerPage = loginPage.clickHereLink();
            registerPage.inputEmailID("test" + randomNumber() + "@live.com");
            registerPage.clickSubmitButton();

            userID = registerPage.getUserIDText();
            password = registerPage.getPasswordText();

            loginPage = registerPage.openLoginPage(loginPageUrl);
        }

        @Test
        public void LG_02_Reset_Button() {
            loginPage.inputUserID(userID);
            loginPage.inputPassword(password);
            loginPage.clickResetButton();

            Assert.assertEquals(loginPage.getUserIDText(), "");
            Assert.assertEquals(loginPage.getPasswordText(), "");
        }

        @Test
        public void LG_03_Login_Successful() {
            loginPage.inputUserID(userID);
            loginPage.inputPassword(password);

            homePage = loginPage.clickSubmitButton();
            Assert.assertTrue(homePage.isWelcomMessageDisplayed());
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
```
`@Parameters()`

> define 'browser' to run based on the browser parameter in *.xml file

`@BeforeClass()`

> runs before all the test methods.

`@Test`

> the actual test case

`Assert.*`

> verify expected results

`@AfterClass()`

> the quit browser test case
