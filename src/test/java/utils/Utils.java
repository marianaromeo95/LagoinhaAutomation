package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;

import java.time.Duration;
import java.util.UUID;

public class Utils {

    public static WebDriver driver;
    WebDriverWait wait;

    public static void accessSystem() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup(); // very useful
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev2.d2nzsfhhqtb1yb.amplifyapp.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //Initializes a Page Object and returns an instance of it.
    // The At method is a utility method that I've created to
    //whenever I need to interact with a specific web page or component,
    // I can simply call the At method, providing the Page Object class I want to work
    // with, and it will return an instance that I can use to access and interact with
    // the elements on that page easily. It helps make my test code cleaner,
    // more organized, and easier to maintain
    public static <T> T At(Class<T> className) {
        return PageFactory.initElements(driver, className);
    }



    public static void silentSleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    public static String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString();
        return uuid + "@example.com";
    }

    public static void systemLogin(String email, String password){
        At(LoginPage .class).login(email, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}

