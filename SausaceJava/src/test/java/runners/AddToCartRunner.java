package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        dryRun = true,
        features = "src/test/resources/features/add_to_cart.feature",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
        ,plugin = {"pretty", "html:target/cucumber-reports"}
        ,monochrome = true
)
public class AddToCartRunner {
}
