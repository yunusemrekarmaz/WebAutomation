package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.BrowserType;
import java.io.File;

public class WebDriverFactory {
    private final static String chromeDriverPath="src/main/java/webdriver/chrome/chromedriver.exe";
    //private final static String geckoDriverPath="src/main/java/webdriver/firefox/geckodriver.exe";

    private WebDriverFactory(){
    }

    public static WebDriver getBrowserInstance(BrowserType browser){
        WebDriver retWebDriver;
        switch(browser){
            default:
            case CHROME:
                setChromeDriver();
                ChromeOptions chromeOptions=new ChromeOptions();
                retWebDriver=new ChromeDriver(chromeOptions);
                break;
            /*case FIREFOX:
                setFirefoxDriver();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                WebDriver driver = new FirefoxDriver();
                retWebDriver=new FirefoxDriver(firefoxOptions);
                break;*/
        }
        return retWebDriver;
    }
    private static void setChromeDriver(){
        if (!new File(chromeDriverPath).exists())
            throw new RuntimeException
                    ("Chromedriver.exe does not exist!");

        try {
            System.setProperty("webdriver.chrome.driver",
                    chromeDriverPath);
        }

        catch (Exception ex) {
            throw new RuntimeException
                    ("Couldnt create chrome driver");
        }

    }
    /*private static void setFirefoxDriver(){
        if (!new File(geckoDriverPath).exists())
            throw new RuntimeException
                    ("GeckoDriver.exe does not exist!");

        try {
            System.setProperty("webdriver.gecko.driver",
                    geckoDriverPath);
        }

        catch (Exception ex) {
            throw new RuntimeException
                    ("Couldnt create gecko driver");
        }

    }*/
}
