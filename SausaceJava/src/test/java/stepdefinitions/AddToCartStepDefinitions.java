package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;
import steps.CommonSteps;

import static utils.SelectUsers.returnCorrectUserName;
import static utils.SelectUsers.PASSWORD;

public class AddToCartStepDefinitions {

    @Steps
    private CommonSteps commonSteps;

    @Steps
    private LoginPage fromLoginPage;

    @Steps
    private InventoryPage fromInventoryPage;


    @Given("I enter to sauce page as {string}")
    public void iEnterToSaucePageAs(String userName) {
        commonSteps.openTheSaucePage();
        fromLoginPage.logInWithCredentials(returnCorrectUserName(userName), PASSWORD);
    }
    @When("I select the product called {string}")
    public void iSelectTheProductCalled(String products) {
        fromInventoryPage.addToCartProductCalled(products);
    }

    @When("I select the product called {string} from the detail")
    public void iSelectTheProductCalledFromTheDetail(String product) {

    }

    @When("Remove the product called {string}")
    public void removeTheProductCalled(String string) {

    }

    @When("Remove the product called {string} from the cart")
    public void removeTheProductCalledFromTheCart(String string) {

    }

    @Then("The counter should not appear")
    public void theCounterShouldNotAppear() {

    }

    @Then("The counter should contain the number {string}")
    public void theCounterShouldContain(String counterExpect) {
        assertThat("the cart counter contains a different value",
                fromInventoryPage.returnCartCounter(), is(equalTo(counterExpect)));
    }


}
