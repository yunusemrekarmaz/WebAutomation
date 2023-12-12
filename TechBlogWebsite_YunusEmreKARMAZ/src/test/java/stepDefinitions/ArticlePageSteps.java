package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ArticlePage;

public class ArticlePageSteps {

    public static WebDriver driver;

    public ArticlePageSteps() {
        driver = BaseStep.driver;
    }

    @When("User navigates to a random article page in the latest news list")
    public void userNavigatesToARandomArticlePageInTheLatestNewsList() throws InterruptedException {
        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.NavigateToARandomArticlePageInTheLatestNewsList();

    }

    @Then("User verifies the current browser title is same as the title in the content")
    public void userVerifiesTheCurrentBrowserTitleIsSameAsTheTitleInTheContent() {
        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.verifyTheCurrentBrowserTitleIsSameAsTheTitleInTheContent();
    }

    @Then("User verifies the current URL is same as the URL in the content")
    public void userVerifiesTheCurrentURLIsSameAsTheURLInTheContent() {
        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.verifyTheCurrentURLIsSameAsTheURLInTheContent();
        driver.quit();
    }


}
