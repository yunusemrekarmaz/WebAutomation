# Project Information
@Author: Yunus Emre Karmaz

@Java Version : 17

@Operating System : Windows 

@chromedriver: 119.0.6045.199

-----------------------------------------------------------------

## Essential Dependencies->

@junit 4.13.2

@io.cucumber 6.10

@org.seleniumhq.selenium 4.15

----------------------------------------------------------------
## Run Test

Run tests locally in 2 ways
1. Right click the feature file and select "Run" or "Debug" to start the test.
2. Right click in RunnerTest class and select "Run" or "Debug" to start the test.

----------------------------------------------------------------
## Test Flow

1. Starting with Background via Choosing a browserType in Feature File
2. Finding the BaseStep definition
3. Taking the browser type from the BrowserType enum file
3. Creating a browser object in WebDriverFactory class file
4. Passing into first step of the Scenario defined in feature file
5. Going to the given URL
4. Passing into other steps defined in Feature File
5. Finding the ArticlePageSteps or HomePageSteps related with step in the Feature
6. Creating a Page object with WebElements and its own methods, By the help of init method of PageFactory class
7. Then interaction with the elements thanks to defined webDriver and Page object.
8. Quitting driver and browser