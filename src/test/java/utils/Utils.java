package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static WebDriver driver;
    WebDriverWait wait;

    public static void accessSystem() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev2.d2nzsfhhqtb1yb.amplifyapp.com/login");
    }

    public static <T> T At(Class<T> className) {
        return PageFactory.initElements(driver, className);
    }
}

