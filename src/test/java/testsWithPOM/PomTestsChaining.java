package testsWithPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.ResultsPage;
import setUpClasses.BaseWebDriver;

public class PomTestsChaining extends BaseWebDriver {
  @Test
  public void test1() {
    driver.get("https://www.google.com");
    GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
    googleSearchPage.sendSearchQuery("Selenium webdriver");

    ResultsPage resultsPage = new ResultsPage(driver);
    resultsPage.getResultByText("WebDriver :: Documentation for Selenium").click();

    Assert.assertTrue(driver.getTitle().contains("WebDriver :: Documentation for Selenium"));
  }

  @Test
  public void test2() {
    driver.get("https://www.google.com");
    GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
    googleSearchPage.sendSearchQuery("TestNG");

    ResultsPage resultsPage = new ResultsPage(driver);
    resultsPage.getResultByText("TestNG - Welcome").click();

    Assert.assertTrue(driver.getTitle().contains("TestNG - Welcome"));
  }
}
