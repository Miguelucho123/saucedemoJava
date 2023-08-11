package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import pages.*;
import steps.CommonSteps;



public class E2eStepdefinitions {

    @Steps
    private InventoryPage fromInventoryPage;

    @Steps
    private CartPage fromCartPage;

    @Steps
    private CheckoutPage fromCheckoutPage;

    @When("Complete the checkout process with the data")
    public void completeTheCheckoutProcessWithTheData(DataTable customerData) {
        fromInventoryPage.clickOnCart();
        fromCartPage.clickOnCheckout();
        fromCheckoutPage.completeCustomerInfo(customerData);
        fromCheckoutPage.clickOnContinueButton();
        fromCheckoutPage.clickOnFinishButton();

    }
    @Then("Should appear the message {string}")
    public void shouldAppearTheMessage(String message) {
        assertThat("the message was different than expected",
                fromCheckoutPage.returnCheckoutMessage(), is(equalTo(message)));
    }
}
