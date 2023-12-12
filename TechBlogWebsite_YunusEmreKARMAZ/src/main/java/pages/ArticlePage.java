package pages;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class ArticlePage {

    WebDriver webDriver;

    @FindBy(xpath = "//div[@class='river river--homepage ']/div/article/header/h2/a")

    private List<WebElement> articlesList;

    @FindBy(xpath = "//*[@class='post-block__title']/a")

    private List<WebElement> articleUrlList;

    @FindBy(xpath = "//*[@class='article__title']")

    private WebElement contTitle;
    private static int randomArticle;

    public ArticlePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    public void NavigateToARandomArticlePageInTheLatestNewsList() {

        randomArticle = ThreadLocalRandom.current().nextInt(0, articlesList.size() - 1);
        Actions actions = new Actions(webDriver);
        actions.scrollToElement(articlesList.get(randomArticle));
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(articlesList.get(randomArticle)));
        actions.perform();
        articlesList.get(randomArticle).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void verifyTheCurrentURLIsSameAsTheURLInTheContent()  {
        String contentURL = articleUrlList.get(randomArticle).getAttribute("href");
        String browserUrl = webDriver.getCurrentUrl();
        if (contentURL.equals(browserUrl)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse("The content URL: " + contentURL + "is not same as the browser URL: " + browserUrl, true);
        }

    }

    public void verifyTheCurrentBrowserTitleIsSameAsTheTitleInTheContent() {
        String contentTitle = contTitle.getText();
        String browserTitle = webDriver.getTitle();
        String title = browserTitle.replace(" | TechCrunch", "");
        if (contentTitle.equals(title)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse("The content Title: " + contentTitle + "is not same as the browser Title: " + browserTitle, true);
        }

    }

}
