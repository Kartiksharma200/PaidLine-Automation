package com.tests;

import org.testng.annotations.Test;
import com.base.BaseTest;
import com.utils.TestData;
import come.pages.SignInPage;
import come.pages.SignUpPage;
import come.pages.YourNumPage;

public class E2E extends BaseTest{
  
    @Test (priority = 1)
    public void signUpWithValidCredentials() throws Exception{
      SignUpPage signup = new SignUpPage(driver);
      signup.enterFirstName(TestData.signUpFirstName);
      signup.enterLastName(TestData.signUpLastName);
      signup.enterEmail(TestData.signUpEmail);
      signup.enterPassword(TestData.signUpPassword);
    signup.clickSignUpButton(); 
      Thread.sleep(4000);
    }
 
    @Test (priority = 2)
    public void signInWithValidCredentials(){
      SignInPage signin = new SignInPage(driver);
      signin.enterEmail(TestData.validEmail);
      signin.enterPassword(TestData.validPassword);
      signin.clickLogin();
    }

    @Test (priority = 3)
    public void verifydashboard() throws Exception{
      YourNumPage dashboard = new YourNumPage(driver);
      dashboard.ClickpaidlineNum();
      //  Thread.sleep(3000);  // Optional wait for UI response
      dashboard.SetCallRate(TestData.SetRate);
        Thread.sleep(3000);
      dashboard.SetAvailability();
        Thread.sleep(3000);
      dashboard.CallForwarding();
       Thread.sleep(3000);      
    }

    public void logout(){

    }



}
