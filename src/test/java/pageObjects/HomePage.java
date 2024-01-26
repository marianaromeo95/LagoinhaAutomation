package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {


    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Criar evento')]")
    public WebElement createEventBtn;

}
