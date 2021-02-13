package testsWithPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import setUpClasses.BaseWebDriver;

public class PomTests extends BaseWebDriver {
  @Test
  public void test1() {
    driver.get("https://www.bing.com");
    GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
    googleSearchPage.sendSearchQuery("It is alive!");

    Assert.assertTrue(driver.getTitle().contains("It is alive!"));
  }
}
