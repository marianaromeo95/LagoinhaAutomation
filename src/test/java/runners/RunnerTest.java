package runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = {"stepsDefinitions"},
        tags = "@eventSuccess",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = false,
        dryRun = false

)
public class RunnerTest {

}
