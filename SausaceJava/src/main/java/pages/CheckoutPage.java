package pages;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CheckoutPage extends PageObject {
    @FindBy(id="first-name")
    WebElementFacade txtFirstName;
    @FindBy(id="last-name")
    WebElementFacade txtLastName;
    @FindBy(id="postal-code")
    WebElementFacade txtPostalCode;
    @FindBy(id="continue")
    WebElementFacade btnContinue;

    @FindBy(id="finish")
    WebElementFacade btnFinish;

    @FindBy(xpath = "//div[@id='checkout_complete_container']/h2")
    WebElementFacade confirmationCheckoutMessage;

    public void completeCustomerInfo(DataTable customerInfo){
        Map<String, String> data = customerInfo.transpose().asMap(String.class, String.class);
        String firstName=data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtPostalCode.sendKeys(zipCode);
    }

    public void clickOnContinueButton(){
        btnContinue.click();
    }

    public void clickOnFinishButton(){
        btnFinish.click();
    }

    public String returnCheckoutMessage(){
        return confirmationCheckoutMessage.getText();
    }
}
