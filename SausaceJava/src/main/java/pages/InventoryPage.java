package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryPage extends PageObject {

    @FindBy(id = "shopping_cart_container")
    WebElementFacade cartButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElementFacade cartCounter;
    public void addToCartProductCalled(String products){
        List<String> listProducts;
        if(products.contains(",")){
            String[] elementsArray = products.split(",");
            listProducts= new ArrayList<>(Arrays.asList(elementsArray));
            System.out.println("size with vector: "+ listProducts.size());
        }else {
            listProducts = new ArrayList<>();
            listProducts.add(products);
            System.out.println("size with add: "+listProducts.size());
        }
        if(listProducts.size()>1){
            for (String listProduct : listProducts) {
                System.out.println("actual product: " + listProduct);
                clickOnAddToCart(listProduct);
            }
        }else{
            clickOnAddToCart(products);
        }
    }

    public void clickOnAddToCart(String product){
        WebElement productBuy = find(
                By.xpath("//div[text()='"+product+"']/ancestor::div[@class='inventory_item']//button"));
        productBuy.click();
    }

    public String returnCartCounter(){
        return cartCounter.getText();
    }

    public void clickOnCart(){
        cartButton.click();
    }


}
