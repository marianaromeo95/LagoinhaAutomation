package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static utils.Utils.*;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        accessSystem();
    }


    @After
    public void tearDown(Scenario cenario) {
        driver.quit();
    }

}
