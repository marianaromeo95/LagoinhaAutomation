package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Utils.*;

public class HomePage {


    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Criar evento')]")
    public WebElement createEventBtn;

    @FindBy(name = "name")
    public WebElement titleInput;

    @FindBy(name = "description")
    public WebElement descriptionInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//button[contains(text(), 'Confirmar')]")
    public WebElement confirmDelete;

    @FindBy(xpath = "//div[contains(text(), 'Cadastrar')]")
    public WebElement cadastrarModal;

    @FindBy(id = "delete-legacy-experience")
    public  WebElement deleteBtn;

    @FindBy(id = "edit-legacy-experience")
    public  WebElement editBtn;

    @FindBy(xpath = "//h5[contains(text(), 'Legacy Experience')]")
    public WebElement getEvent;

    @FindBy(xpath = "//h5[contains(text(), 'Culto Hope Terca')]")
    public WebElement getEditedTitle;

    @FindBy(xpath = "//p[contains(text(), 'Best service of the week')]")
    public WebElement getEditedDescription;

    @FindBy(xpath = "//div[contains(text(), 'Título do evento obrigatório')]")
    public WebElement emptyTitleError;

    @FindBy(xpath = "//div[contains(text(), 'Evento alterado com sucesso')]")
    public WebElement editSuccess;

    @FindBy(id = "search")
    public  WebElement searchInput;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void createEvent(String eventName) {
        clickCreateEventButton();
        inputEventTitle(eventName);
        clickSubmitButton();
    }

    public void clickCreateEventButton() {
        createEventBtn.click();
    }

    public void inputEventTitle(String eventName) {
        wait.until(ExpectedConditions.visibilityOf(titleInput));
        titleInput.sendKeys(eventName);
    }

    public void inputEventDescription(String eventDescription) {
        descriptionInput.sendKeys(eventDescription);
    }

    public void clickSubmitButton() {
        submitBtn.click();
    }

    public void clickDeleteButton() {
        waitForEvent();
        deleteBtn.click();
    }

    public void clickEditButton() {
        waitForEvent();
        editBtn.click();
    }

    public void searchEvent(String search) {
        searchInput.sendKeys(search);
    }

    public void editEvent(String eventTitle, String newTitle, String newDescription) {
        WebElement editButton = getEditButtonForEvent(eventTitle);
        editButton.click();
        titleInput.clear();
        inputEventTitle(newTitle);
        descriptionInput.clear();
        inputEventDescription(newDescription);
        clickSubmitButton();
    }

    public void editEventTitle(String eventTitle, String newTitle) {
        WebElement editButton = getEditButtonForEvent(eventTitle);
        editButton.click();
        titleInput.clear();
        inputEventTitle(newTitle);
    }

    public void editEventDescription(String newDescription) {
        descriptionInput.clear();
        inputEventDescription(newDescription);
        clickSubmitButton();
    }

    public void confirmDelete() {
        wait.until(ExpectedConditions.visibilityOf(confirmDelete));
        confirmDelete.click();
        wait.until(ExpectedConditions.invisibilityOf(confirmDelete));
    }

    public boolean deleteEvent(String eventTitle) {
        WebElement eventElement = getEventByTitle(eventTitle);
        WebElement deleteButton = getDeleteButtonForEvent(eventTitle);
        deleteButton.click();
        confirmDelete();
        wait.until(ExpectedConditions.invisibilityOf(eventElement));
        return true;
    }

    public boolean isEventDisplayed(String title) {
        silentSleep(1000);
        WebElement eventElement = getEventByTitle(title);
        wait.until(ExpectedConditions.visibilityOf(eventElement));
        return eventElement.isDisplayed();
    }


    public void waitForEvent() {
        wait.until(ExpectedConditions.visibilityOf(getEvent));
    }
    public boolean isEmptyTitleErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(emptyTitleError));
        return emptyTitleError.isDisplayed();
    }

    public boolean isEventTitleAndDescriptionEdited(String newTitle, String newDescription) {
        WebElement editedTitleElement = getEventByTitle(newTitle);
        WebElement editedDescriptionElement = driver.findElement(By.xpath("//p[contains(text(), '" + newDescription + "')]"));

        // Wait for both elements to be visible.
        wait.until(ExpectedConditions.visibilityOf(editedTitleElement));
        wait.until(ExpectedConditions.visibilityOf(editedDescriptionElement));

        return editedTitleElement.isDisplayed() && editedDescriptionElement.isDisplayed();
    }

    public WebElement getEventByTitle(String title) {
        String xpath = "//h5[contains(text(), '" + title + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getDeleteButtonForEvent(String title) {
        String dynamicXPath = "//button[@id='delete-" + title.toLowerCase().replace(" ", "-") + "']";
        return driver.findElement(By.xpath(dynamicXPath));
    }

    public WebElement getEditButtonForEvent(String title) {
        String dynamicXPath = "//button[@id='edit-" + title.toLowerCase().replace(" ", "-") + "']";
        return driver.findElement(By.xpath(dynamicXPath));
    }

}
