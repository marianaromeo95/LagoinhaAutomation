package runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = /*{"pretty"}*/{"json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = {"stepsDefinitions"},
        tags = "@passwordIcon",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = false,
        dryRun = false


)
public class RunnerTest {

}
