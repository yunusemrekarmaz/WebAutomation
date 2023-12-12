package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageSteps {
    public static WebDriver driver;

    public HomePageSteps() {
        driver = BaseStep.driver;
    }

    @Given("User logins the home page {string}")
    public void userLoginsTheHomePage(String URL) {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Then("User verifies every article has an Image")
    public void userVerifiesEveryArticleHasAnImage() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyEveryArticleHasAnImage();

    }

    @Then("User verifies every article has an Author")
    public void userVerifiesEveryArticleHasAnAuthor() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyEveryArticleHasAnAuthor();
        driver.quit();
    }


}
