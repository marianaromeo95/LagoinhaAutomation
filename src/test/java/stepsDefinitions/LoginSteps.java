package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import static utils.Utils.*;
import java.time.Duration;

import static utils.Utils.driver;

public class LoginSteps {

    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("^the user attempts to log in using the email \"?([^\"]*)\"? and password \"?([^\"]*)\"?$")
    public void theUserAttemptsToLogInUsingTheEmailAndPassword(String email, String password)  {
        At(LoginPage.class).enterEmail(email);
        At(LoginPage.class).enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        At(LoginPage.class).clickLoginButton();
    }
    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(At(HomePage.class).createEventBtn));
        Assert.assertEquals("CRIAR EVENTO", driver.findElement(By.xpath("//button[contains(text(), 'Criar evento')]")).getText());

    }

    @Then("^the system should throw invalid email/password error message$")
    public void theSystemShouldThrowInvalidEmailPasswordErrorMessage() {
        // Code to verify that an invalid email/password error message is shown
    }

    @When("^the user clicks the password visibility toggle icon$")
    public void theUserClicksThePasswordVisibilityToggleIcon() {
        At(LoginPage.class).clickToggleIcon();
    }

    @Then("^the password field should display the password$")
    public void thePasswordFieldShouldDisplayThePassword() {
        WebElement passwordInput = driver.findElement(By.name("password"));
        String typeAttribute = passwordInput.getAttribute("type");
        Assert.assertEquals("text", typeAttribute);
    }

    @Then("^the user clicks the password visibility toggle icon again$")
    public void theUserClicksThePasswordVisibilityToggleIconAgain() {
        At(LoginPage.class).clickToggleIcon();
    }

    @Then("^the password field should hide the password$")
    public void thePasswordFieldShouldHideThePassword() {
        WebElement passwordInput = driver.findElement(By.name("password"));
        String typeAttribute = passwordInput.getAttribute("type");
        Assert.assertEquals("password", typeAttribute);
    }



}
