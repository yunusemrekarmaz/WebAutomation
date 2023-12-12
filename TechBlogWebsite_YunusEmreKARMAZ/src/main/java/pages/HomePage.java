package pages;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

@Getter
public class HomePage {
    WebDriver webDriver;

    @FindBy(xpath = "//h2[@class='river__title river__title--home']")
    private WebElement latestNews;

    @FindBy(xpath = "//div[@class='river river--homepage ']/div/article")

    private List<WebElement> articlesList;

    private By authorObject= new By.ByClassName("river-byline__authors");
    private By mediaObject= new By.ByClassName("post-block__media");
    private By imgObject= new By.ByTagName("img");


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }


    public void verifyEveryArticleHasAnAuthor() {
        for (int i = 0; i < articlesList.size() - 1; i++) {
            if (articlesList.get(i).findElement(authorObject) != null) {
                if (articlesList.get(i).findElement(authorObject).getText() != "") {
                    Assert.assertTrue(true);

                }
            } else {
                Assert.assertFalse("An article has no author", true);

            }

        }

    }


    public void verifyEveryArticleHasAnImage() {
        for (int i = 0; i < articlesList.size() - 1; i++) {
            if (articlesList.get(i).findElement(mediaObject).findElement(imgObject) != null) {
                if (articlesList.get(i).findElement(mediaObject).findElement(imgObject).isDisplayed()) {
                    Assert.assertTrue(true);
                }
            } else {
                Assert.assertFalse("An article has no image", true);
            }

        }
    }


}
