package com.mycompany.myapp.selenium.tests;

import com.mycompany.myapp.JhipseleniumApp;
import com.mycompany.myapp.selenium.base.TestBaseSetup;
import com.mycompany.myapp.selenium.pageObjects.HomePageObject;
import com.mycompany.myapp.selenium.pageObjects.LoginPageObject;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipseleniumApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeIntTest extends TestBaseSetup {

    private final Logger log = LoggerFactory.getLogger(HomeIntTest.class);

    // This allows us to print the test name before and after it runs
    @Rule
    public TestName name = new TestName();

    HomePageObject homePageObject = new HomePageObject(getDriver());
    LoginPageObject loginPageObject = new LoginPageObject(getDriver());

    @Before
    public void individualTestSetup() {
        log.info("Running test " + name.getMethodName());
    }

    @After
    public void logAfterTestsComplete() {
        log.info("Completed test " + name.getMethodName());
    }

    @Test
    public void verifiesHomePageHasHeader() throws Exception {
        // Our browser is directed to our homepage before each test:
        openUrl(getDriver(), "/");

        // We use our pageObjects class to retrieve the WebElement with id="mainHeader"
        // We assert that the text of the element with id="mainHeader" is "Welcome, Java Hipster!"
        Assert.assertTrue("Homepage header does not match", homePageObject.verifyMainnav());
    }

    @Test
    public void clickLogin() {
        // Our browser is directed to our homepage before each test:
        openUrl(getDriver(), "/");

        // We click on the element with id="login":
        homePageObject.login(getDriver()).click();

        // We use our pageObjects class to retrieve the WebElement with id="loginTitle" using our LoginPageObject:
        // We assert that the element with id="loginTitle" has the text "Sign in":
        Assert.assertTrue("Login title does not match", loginPageObject.verifyLoginTitle());
    }
}
