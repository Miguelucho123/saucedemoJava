package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="user-name")
    private WebElement txtUserName;

    @FindBy(id="password")
    private WebElement txtPassword;

    @FindBy(id="login-button")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    private WebElement msgError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openSaucePage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void logInWithCredentials(String username, String password){
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public String returnErrorMessage(){
        return msgError.getText();
    }

}
