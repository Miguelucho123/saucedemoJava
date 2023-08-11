package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import net.thucydides.core.annotations.Steps;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductDetailPage;
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

    @Steps
    private ProductDetailPage fromProductDetailPage;


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
        fromInventoryPage.clickOnProductName(product);
        fromProductDetailPage.clickOnAddToCart();
    }

    @When("Remove the product called {string}")
    public void removeTheProductCalled(String product) {
        fromInventoryPage.clickOnRemoveItem(product);
    }

    @When("Remove the product called {string} from the cart")
    public void removeTheProductCalledFromTheCart(String product) {
        fromInventoryPage.clickOnRemoveItem(product);
    }

    @Then("The counter should not appear")
    public void theCounterShouldNotAppear() {
        assertThat("the counter is deployed",
                fromInventoryPage.returnCartElement().isCurrentlyVisible(), is(false));
    }

    @Then("The counter should contain the number {string}")
    public void theCounterShouldContain(String counterExpect) {
        assertThat("the cart counter contains a different value",
                fromInventoryPage.returnCartCounter(), is(equalTo(counterExpect)));
    }


}
