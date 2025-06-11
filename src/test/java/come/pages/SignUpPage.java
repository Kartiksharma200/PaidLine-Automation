package come.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.WaitUtils;

public class SignUpPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

   //Constructor
    
    public SignUpPage(WebDriver driver) { 
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    //Web Element (Locators)
    
    @FindBy(xpath = "//*[@placeholder=\"Jordan\"]")
    @CacheLookup
    private WebElement firstNameField;
    
    @FindBy(xpath = "//*[@placeholder=\"Doe\"]")
    @CacheLookup
    private WebElement lastNameField;
    
    @FindBy(xpath = "//*[@placeholder=\"Email\"]")
    @CacheLookup
    private WebElement emailField;

    @FindBy(xpath = "//*[@placeholder=\"Password\"]")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class=\"eyeIcon\"]")
    @CacheLookup
    private WebElement eyeIcon;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    @CacheLookup
    private WebElement submitBtn;

    @FindBy(linkText = "Email is already registered with another user")
    @CacheLookup
    private WebElement errorMessage;
    
    @FindBy(xpath = "(//*[@fill=\"currentColor\"])[2]")
    @CacheLookup
    private WebElement verifyEmailCrossIcon;
    
    @FindBy(xpath = "(//*[@class=\"chakra-button !w-[140px] css-i2zvij\"])[1]")
    @CacheLookup
    private WebElement verifyEmailResendEmail;
    
    @FindBy(xpath = "//*[@href=\"/contact-us\"]")
    @CacheLookup
    private WebElement verifyEmailContactUs;

    @FindBy(xpath = "(//*[@type=\"button\"])[1]")
    @CacheLookup
    private WebElement googleSignUp;

    @FindBy(xpath = "(//*[@type=\"button\"])[2]")
    @CacheLookup
    private WebElement linkdinSignUp;

    @FindBy(xpath = "(//*[@type=\"button\"])[3]")
    @CacheLookup
    private WebElement twitterSignUp;
    
    
    //Action 
    
    public void enterFirstName(String firstName) {
    	WaitUtils.waitForElementToBeVisible(driver, firstNameField, 10);
    	firstNameField.clear();
    	firstNameField.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
    	WaitUtils.waitForElementToBeVisible(driver, lastNameField, 10);
    	lastNameField.clear();
    	lastNameField.sendKeys(lastName);
    }
    
    public void enterEmail(String email) {
    	WaitUtils.waitForElementToBeVisible(driver, emailField, 10);
    	emailField.clear();
    	emailField.sendKeys(email);
    }
    
    public void enterPassword(String password) {
    	WaitUtils.waitForElementToBeVisible(driver, passwordField, 10);
    	passwordField.clear();
    	passwordField.sendKeys(password);
    }
    
    public void clickEyeIcon() {
    	eyeIcon.click();
    }
    
    public void clickSignUpButton() {
    	WaitUtils.waitForElementToBeVisible(driver, submitBtn, 10);
    	submitBtn.click();
    }

    public String getErrorMessage(){
    	WaitUtils.waitForElementToBeVisible(driver, errorMessage, 10);
        return errorMessage.getText();
    }
}
