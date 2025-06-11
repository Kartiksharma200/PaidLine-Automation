package com.tests;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseTest;
import com.utils.ScreenshotUtils;
import com.utils.TestData;

import come.pages.SignUpPage;

public class SignUpTest extends BaseTest{

    /*Sceanrio 1: Sign Up with Valid Credentials
	 * 
	 * Expected Result: Successful SignUp
	 * */

    @Test
    public void validSignUpTest() throws Exception {
       test = extent.createTest("Valid Sign-Up Test"); 

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.enterFirstName(TestData.firstName);
            signup.enterLastName(TestData.lastName);
            signup.enterEmail(TestData.email);
            signup.enterPassword(TestData.password);
            signup.clickEyeIcon();
            signup.clickSignUpButton();
            test.pass("Sign-Up test passed successfully");
            Thread.sleep(3000);
        } catch (Exception e) {
        	String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ValidSignUpTest");
            test.fail("Sign-Up test failed: " + e.getMessage())
            .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

}
