package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageObject {

    @FindBy(xpath = "//div[@class='inventory_details_desc_container']/button")
    WebElementFacade addToCartButton;

    public void clickOnAddToCart(){
        addToCartButton.click();
    }
}
