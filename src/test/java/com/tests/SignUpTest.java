package com.tests;

import org.testng.annotations.Test;

public class SignUpTest {

    
    private ExtentReports extent;
    private ExtentTest extentTest;
  

    @BeforeClass
    public void setUp() {
        extent = ExtentManager.createInstance(); 
    }

    /*Sceanrio 1: Sign Up with Valid Credentials
	 * 
	 * Expected Result: Successful SignUp
	 * */

    @Test
    public void validSignUpTest() {
        extentTest = extent.createTest("Valid Sign-Up Test"); 

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.enterFirstName(TestData.firstName);
            signup.enterlastName(TestData.lastName);
            signup.enterEmail(TestData.email);
            signup.enterPassword(TestData.password);
            signup.clickEyeIcon();
            signup.clickSignUpButton();
            extentTest.pass("Sign-Up test passed successfully");
        } catch (Exception e) {
            extentTest.fail("Sign-Up test failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
}
