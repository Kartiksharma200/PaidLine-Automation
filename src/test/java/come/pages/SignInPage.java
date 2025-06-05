package come.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

   //Constructor
    
    public SignInPage(WebDriver driver) { 
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Web elements (locators)
    
    @FindBy(xpath = "//*[@placeholder='youremail@example.com']")
    @CacheLookup
    private WebElement emailField;

    @FindBy(xpath = "//*[@placeholder='Password']")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='eyeIcon']")
    private WebElement eyeIcon;

    @FindBy(xpath = "//*[@type='submit']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(linkText = "Forgot Password?")
    private WebElement forgotPasswordLink;

    // Actions
    
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickEyeIcon() {
        eyeIcon.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickEyeIcon();
        clickLogin();
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public boolean isLoginButtonVisible() {
        return loginButton.isDisplayed();
    }
}