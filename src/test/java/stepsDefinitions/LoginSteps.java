package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import static utils.Utils.*;
import java.time.Duration;

import static utils.Utils.driver;

public class LoginSteps {

    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user attempts to log in using the email {string} and password {string}")
    public void theUserAttemptsToLogInUsingTheEmailAndPassword(String string, String string2) {
        At(LoginPage.class).enterEmail(string);
        At(LoginPage.class).enterPassword(string2);
    }
    @And("clicks the login button")
    public void clicksTheLoginButton() {
        At(LoginPage.class).loginButtonClick();
    }
    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(At(HomePage.class).createEventBtn));
        Assert.assertEquals("CRIAR EVENTO", driver.findElement(By.xpath("//button[contains(text(), 'Criar evento')]")).getText());

    }


}
