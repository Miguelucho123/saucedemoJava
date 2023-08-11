package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        dryRun = false,
        features = "src/test/resources/features/e2e.feature",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE


)
public class E2ERunner {
}
