package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.concurrent.TimeUnit;

public class LoginStepDefinitions {

    private WebDriver driver;
    private LoginPage fromLoginPage;

    @BeforeScenario
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        fromLoginPage = new LoginPage(driver);
    }

    @Given("I enter to sauce page")
    public void iEnterToSaucePage() {

        fromLoginPage.openSaucePage();
    }
    @When("I enter as {string} with the password {string}")
    public void iEnterAsWithThePassword(String userType, String password) {
        fromLoginPage.logInWithCredentials(userType, password);
    }
    @Then("I should see into URL the {string}")
    public void iShouldSeeIntoUrlThe(String strURL) {
        assertThat(driver.getCurrentUrl(),containsString(strURL));
    }
    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        assertThat(fromLoginPage.returnErrorMessage(), containsString(errorMessage));
    }
    @AfterScenario
    public void shutDown(){
        driver.quit();
    }
}
