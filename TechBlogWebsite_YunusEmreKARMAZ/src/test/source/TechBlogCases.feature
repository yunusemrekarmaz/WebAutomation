Feature: Tech Blog Cases

  Background: Choosing Browser
    Given User opens a browser "CHROME"

  Scenario: User checks home page
    Given User logins the home page "https://techcrunch.com/"
    Then User verifies every article has an Image
    Then User verifies every article has an Author

  Scenario: User checks the article page
    Given User logins the home page "https://techcrunch.com/"
    When User navigates to a random article page in the latest news list
    Then User verifies the current browser title is same as the title in the content
    Then User verifies the current URL is same as the URL in the content
