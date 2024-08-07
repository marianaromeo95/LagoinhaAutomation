package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utils.Utils.*;
import java.time.Duration;


public class LoginPage extends HomePage {

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
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(60));
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

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(createEventBtn));
    }




}
