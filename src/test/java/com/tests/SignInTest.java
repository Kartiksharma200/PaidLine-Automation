package com.tests;
import org.testng.annotations.Test;
import com.base.BaseTest;
import com.utils.ScreenshotUtils;
import com.utils.TestData;
import com.utils.WaitUtils;

import come.pages.SignInPage;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

	/*Sceanrio 1: Login with Valid Credentials
	 * 
	 * Expected Result: We Redirect to Dashboard/Onboarding process
	 * */
    @Test (priority = 1)
    public void loginWithValidCredentials() throws Exception {
        test = extent.createTest("Login with Valid Credentials");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login(TestData.validEmail, TestData.validPassword);

            WaitUtils.waitForUrlToContain(driver, "dashboard");

            assertTrue(driver.getCurrentUrl().contains("dashboard"));
            test.pass("Login successful. Dashboard URL verified.");
            Thread.sleep(3000);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithValidCredentials");
            test.fail("Login test failed. Error: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e; // Re-throw so TestNG marks it as failed
        }
    }
 
    /*Scenario 2: Login with invalid credentials
     * 
     * Expected Result: Getting an Invalid credentails Toast message.
     * */
    @Test (priority = 2)
    public void loginWithInvalidCredentials() {
        SignInPage signIn = new SignInPage(driver);
        signIn.login(TestData.invalidEmail, TestData.invalidPassword);
        // Verify the login failed - either by URL not changing or showing error
        assertTrue(signIn.isLoginButtonVisible());
    }

    /*Scenario 3: Login with Empty field
     * 
     * Expected Result: Sign In button disable
     * */
    @Test (priority = 3)
    public void loginWithEmptyFields() {
        SignInPage signIn = new SignInPage(driver);
        signIn.login("", "");
        // Validate the form shows required field error
        assertTrue(signIn.isLoginButtonVisible());
    }

    
    public void forgotPasswordLinkTest() {
      
		SignInPage signIn = new SignInPage(driver);
        signIn.clickForgotPassword();
        // Add assert for popup visibility (when implemented)
    }
}