package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    @FindBy(id="user-name")
    private WebElementFacade txtUserName;

    @FindBy(id="password")
    private WebElementFacade txtPassword;

    @FindBy(id="login-button")
    private WebElementFacade btnLogin;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    private WebElementFacade msgError;

    public void logInWithCredentials(String username, String password){
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public String returnErrorMessage(){
        return msgError.getText();
    }

    public String returnCurrentURL(){
        return getDriver().getCurrentUrl();
    }
}
