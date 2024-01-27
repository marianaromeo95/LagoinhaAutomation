package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utils.Utils.*;
import java.time.Duration;

public class EventSteps {

    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("^the user is authenticated and on the event management page$")
    public void theUserIsAuthenticatedAndOnTheEventManagementPage() {
        // Implementation code
    }

    @When("^the user clicks on the create event button$")
    public void theUserClicksOnTheCreateEventButton() {

    }

    @When("^inputs the title (.+)$")
    public void inputsTheTitle(String title) {

    }

    @When("^clicks on the register button$")
    public void clicksOnTheRegisterButton() {

    }

    @Then("^the event (.+) should be successfully created$")
    public void theEventShouldBeSuccessfullyCreated(String title) {

    }

    @Given("^an event (.+) exists$")
    public void anEventExists(String title) {
        // Code to ensure the event with the given title exists
    }

    @When("^the user selects the delete button for (.+)$")
    public void theUserSelectsTheDeleteButtonFor(String title) {

    }

    @When("^clicks confirm deletion$")
    public void clicksConfirmDeletion() {

    }

    @Then("(.+) should be successfully deleted$")
    public void shouldBeSuccessfullyDeleted(String title) {

    }

    @When("^clicks on the register button without entering a title$")
    public void clicksOnTheRegisterButtonWithoutEnteringATitle() {
        // Implementation code
    }

    @Then("^a mandatory title error message should be displayed$")
    public void aMandatoryTitleErrorMessageShouldBeDisplayed() {
        // Implementation code
    }

    @When("^the user edits the event \"([^\"]*)\"$")
    public void theUserEditsTheEvent(String title) {
        // Implementation code
    }

    @When("^changes the title to \"([^\"]*)\" and adds a description \"([^\"]*)\"$")
    public void changesTheTitleToAndAddsADescription(String newTitle, String description) {
        // Implementation code
    }

    @When("^clicks the save button$")
    public void clicksTheSaveButton() {
        // Implementation code
    }

    @Then("^the event is successfully edited$")
    public void theEventIsSuccessfullyEdited() {
        // Implementation code
    }

    @When("^erases the title$")
    public void erasesTheTitle() {
        // Implementation code
    }

    @When("^the user searches for \"([^\"]*)\"$")
    public void theUserSearchesFor(String title) {
        // Implementation code
    }

    @Then("^the event \"([^\"]*)\" should be displayed$")
    public void theEventShouldBeDisplayed(String title) {
        // Implementation code
    }



    // Other steps remain the same as in your provided class
}
