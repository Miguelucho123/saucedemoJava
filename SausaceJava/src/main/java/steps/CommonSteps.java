package steps;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.time.InternalSystemClock;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.DriverManager;

import java.sql.Driver;
import java.time.Duration;

public class CommonSteps extends PageObject {

    private LoginPage loginPage = new LoginPage();
    @Step
    public void openTheSaucePage(){
        loginPage.open();
    }
    @Step
    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    @Step
    public void waitTheURL(String url){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains(url));
    }
    @Step
    public void waitingDuring(int seconds ){
        new InternalSystemClock().pauseFor((seconds * 1000));
    }
    @Step
    public void waitDisponibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
