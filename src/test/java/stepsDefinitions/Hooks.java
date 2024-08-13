package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

import static utils.Utils.*;

public class Hooks {

    @Before("@login")
    public void setUp() throws Exception {
        accessSystem();
    }

    @Before
    public void setUp2() throws Exception {
        accessSystem();
        //systemLogin("jpbaterabsb@gmail.com", "12345678");
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.quit();
    }



}
