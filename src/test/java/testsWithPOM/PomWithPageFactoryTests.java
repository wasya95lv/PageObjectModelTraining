package testsWithPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPageChaining;
import setUpClasses.BaseWebDriver;

public class PomWithPageFactoryTests extends BaseWebDriver {
  @Test
  public void test1() {
    driver.get("http://www.google.com");

    GoogleSearchPageChaining googleSearchPageChaining = new GoogleSearchPageChaining(driver);
    googleSearchPageChaining.setSearchQuery("It is alive!");
    googleSearchPageChaining.clickSearchButton();

    Assert.assertTrue(driver.getTitle().contains("It is alive!"));
  }
}
