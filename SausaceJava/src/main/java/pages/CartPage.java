package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    public void clickOnRemoveItem(String product){
        WebElement removeButton = find(
                By.xpath("//div[text()='"+product+"']/ancestor::div[@class='cart_item']//button"));
        removeButton.click();
    }

    public void clickOnCheckout(){
        checkoutButton.click();
    }

}
