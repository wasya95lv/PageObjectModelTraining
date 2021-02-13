package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
  WebDriver driver;

  By searchField = By.name("q");
  By searchButton = By.name("btnK");

  public GoogleSearchPage(WebDriver webDriver) {
    this.driver = webDriver;

    if (!driver.getTitle().equals("Google")) {
      throw new IllegalStateException(
          "This is not Google search page," + " current page is: " + driver.getCurrentUrl());
    }
  }

  public void sendSearchQuery(String query) {
    driver.findElement(searchField).sendKeys(query + Keys.ENTER);
  }
}
