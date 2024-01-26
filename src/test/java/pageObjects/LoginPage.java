package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "email")
    public WebElement emailInput;
    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement loginBtn;
    @FindBy(id = "password-icon")
    public WebElement toggleIcon;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public void clickToggleIcon() {
        toggleIcon.click();
    }




}
