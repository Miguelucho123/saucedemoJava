package utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    private static WebDriver driver;

    public static WebDriver createDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--incognito");
        driver = new ChromeDriver(optionsChrome);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
