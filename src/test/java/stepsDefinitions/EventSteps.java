package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import static utils.Utils.*;
import java.time.Duration;

public class EventSteps {

    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("^the user clicks on the create event button$")
    public void theUserClicksOnTheCreateEventButton() {
        At(HomePage.class).clickCreateEventButton();
    }

    @When("^inputs the title \"?([^\\\"]*)\"?$")
    public void inputsTheTitle(String title) {
        At(HomePage.class).inputEventTitle(title);
    }

    @When("^clicks on the register button$")
    public void clicksOnTheRegisterButton() {
        At(HomePage.class).clickSubmitButton();
    }

    @Then("^the event should be successfully created and deleted afterwards$")
    public void theEventShouldBeSuccessfullyCreatedAndDeletedAfterwards() {
        Assert.assertTrue(At(HomePage.class).isEventDisplayed("Legacy Experience"));
        boolean isDeletedEvent = At(HomePage.class).deleteEvent("Legacy Experience");
        Assert.assertTrue(isDeletedEvent);
    }

    @Then("^the event \"([^\"]*)\" should be successfully created and deleted afterwards$")
    public void theEventShouldBeSuccessfullyCreatedAndDeletedAfterwards(String title) {
        Assert.assertTrue(At(HomePage.class).isEventDisplayed(title));
        boolean isDeletedEvent = At(HomePage.class).deleteEvent(title);
        Assert.assertTrue(isDeletedEvent);
    }
    @When("^clicks on the register button without entering a title$")
    public void clicksOnTheRegisterButtonWithoutEnteringATitle() {
        At(HomePage.class).clickSubmitButton();
    }

    @Then("^a mandatory title error message should be displayed$")
    public void aMandatoryTitleErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(At(HomePage.class).isEmptyTitleErrorMessageDisplayed());
    }

    @Given("^an event with the title \"([^\"]*)\" exists$")
    public void anEventWithTheTitleExists(String string) {
        theUserClicksOnTheCreateEventButton();
        inputsTheTitle(string);
        clicksOnTheRegisterButton();
        Assert.assertTrue(At(HomePage.class).isEventDisplayed(string));
    }

   @When("^the user edits the event title to \"([^\"]*)\"$")
   public void theUserEditsTheEventTitleTo(String newTitle) {
       At(HomePage.class).editEventTitle("Legacy Experience", newTitle);
   }
    @When("^description to \"([^\"]*)\"$")
    public void descriptionTo(String newDescription) {
        At(HomePage.class).editEventDescription(newDescription);
    }
    @Then("^the event is successfully edited$")
    public void theEventIsSuccessfullyEdited() {
        Assert.assertTrue(At(HomePage.class).isEventTitleAndDescriptionEdited("Culto Hope Terca", "Best service of the week"));
        boolean isDeletedEvent = At(HomePage.class).deleteEvent("Culto Hope Terca");
        Assert.assertTrue(isDeletedEvent);
    }

    @And("clicks the save button")
    public void clicksTheSaveButton() {
        At(HomePage.class).clickSubmitButton();
    }

    @When("^the user searches for \"([^\"]*)\"$")
    public void theUserSearchesFor(String title) {
        At(HomePage.class).searchEvent(title);
    }

    @Then("^the event should be displayed$")
    public void theEventShouldBeDisplayed() {
        Assert.assertTrue(At(HomePage.class).isEventDisplayed("Legacy Experience"));
    }

    @And("the event should be deleted")
    public void theEventShouldBeDeleted() {
        At(HomePage.class).clickCreateEventButton();
        At(HomePage.class).deleteEvent("Legacy Experience");

    }




    // Other steps remain the same as in your provided class
}
