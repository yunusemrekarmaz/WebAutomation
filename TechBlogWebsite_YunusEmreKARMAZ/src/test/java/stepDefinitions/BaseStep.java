package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.BrowserType;

import static webdriver.WebDriverFactory.getBrowserInstance;

public class BaseStep {
    public static WebDriver driver;
    @Given("User opens a browser {string}")
    public void userOpensABrowser(String browserType) {
        driver =getBrowserInstance(BrowserType.valueOf(browserType));
        driver.manage().window().maximize();
    }

}
