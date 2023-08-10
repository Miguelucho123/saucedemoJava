package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.InventoryPage;
import pages.LoginPage;
import steps.CommonSteps;
import utils.DriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.concurrent.TimeUnit;

public class LoginStepDefinitions {

    @Steps
    private LoginPage fromLoginPage;

    @Steps
    private CommonSteps commonSteps;

    @Given("I enter to sauce page")
    public void iEnterToSaucePage() {
        commonSteps.openTheSaucePage();
    }
    @When("I enter as {string} with the password {string}")
    public void iEnterAsWithThePassword(String userType, String password) {
        fromLoginPage.logInWithCredentials(userType, password);
    }
    @Then("I should see into URL the {string}")
    public void iShouldSeeIntoUrlThe(String strURL) {
        assertThat(fromLoginPage.returnCurrentURL(),containsString(strURL));
    }
    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        assertThat("the message error wasn't deployed",fromLoginPage.returnErrorMessage(), containsString(errorMessage));
    }
}
