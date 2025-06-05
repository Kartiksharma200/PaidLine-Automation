package come.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    
    @FindBy(xpath = "(//*[@fill=\"currentColor\"])[2]")
    @CacheLookup
    private WebElement verifyEmailCrossIcon;
    
    @FindBy(xpath = "(//*[@class=\"chakra-button !w-[140px] css-i2zvij\"])[1]")
    @CacheLookup
    private WebElement verifyEmailResendEmail;
    
    @FindBy(xpath = "//*[@href=\"/contact-us\"]")
    @CacheLookup
    private WebElement verifyEmailContactUs;
    
    //Action 
    
    public void enterFirstName(String firstName) {
    	firstNameField.clear();
    	firstNameField.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
    	lastNameField.clear();
    	lastNameField.sendKeys(lastName);
    }
    
    public void enterEmail(String email) {
    	emailField.clear();
    	emailField.sendKeys(email);
    }
    
    public void enterPassword(String password) {
    	passwordField.clear();
    	passwordField.sendKeys(password);
    }
    
    public void clickEyeIcon() {
    	eyeIcon.click();
    }
    
    public void clickSignUpButton() {
    	submitBtn.click();
    }
}
