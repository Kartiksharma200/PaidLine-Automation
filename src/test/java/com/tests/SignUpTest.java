package com.tests;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseTest;
import com.utils.ScreenshotUtils;
import com.utils.TestData;

import come.pages.SignUpPage;

public class SignUpTest extends BaseTest{

      /*
      Sceanrio 1: Sign Up with Valid Credentials
	  Expected Result: Successful SignUp
	  */

    @Test(priority = 1)
    public void validSignUpTest() throws Exception {
       test = extent.createTest("Valid Sign-Up Test"); 

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName(TestData.signUpFirstName);
            signup.enterLastName(TestData.signUpLastName);
            //Thread.sleep(3000);
            signup.enterEmail(TestData.signUpEmail);
            signup.enterPassword(TestData.signUpPassword);
            signup.clickEyeIcon();
            signup.clickSignUpButton();
            test.pass("Sign-Up test passed successfully");
            //Thread.sleep(3000);
        } catch (Exception e) {
        	String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ValidSignUpTest");
            test.fail("Sign-Up test failed: " + e.getMessage())
            .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }
    

    /*
      Sceanrio 2: Sign Up with InValid Credentials
	  Expected Result: Getting Error
	*/

    @Test(priority = 2, dependsOnMethods = "validSignUpTest") 
    public void inValidSignUp() throws Exception{
        test = extent.createTest("InValid Sign-Up Test");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName(TestData.invalidSignUpFirstName);
            signup.enterLastName(TestData.invalidSignUpLastName);
            signup.enterEmail(TestData.invalidEmail);
            signup.getErrorMessage();
            signup.enterPassword(TestData.invalidSignUpPassword);
            signup.clickEyeIcon();
            signup.clickSignUpButton();
            test.pass("Sign- Up test passed successfully");


        } catch (Exception e) {
            // TODO: handle exception
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "InValidSignUpTest");
            test.fail("Sign-Up test failed: " + e.getMessage())
            .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /*
      Sceanrio 3: Sign Up with Empty Field
	  Expected Result: Disable Sign-Up button
	*/
     @Test (priority = 3)
     public void signUpWithEmptyField() throws Exception{
          test = extent.createTest("Empty Field Sign-Up Test");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName(TestData.emptySignUpFirstName);
            signup.enterLastName(TestData.emptySignUpLastName);
            signup.enterEmail(TestData.emptySignUpEmail);
            signup.enterPassword(TestData.emptySignUpPassword);
            signup.clickEyeIcon();
            signup.clickSignUpButton();
            test.pass("Sign- Up test passed successfully");


        } catch (Exception e) {
            // TODO: handle exception
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "Empty Field SignUp Test");
            test.fail("Sign-Up test failed: " + e.getMessage())
            .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
     }

}
