package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPageChaining {
  WebDriver driver;

  By searchFieldBy = By.name("q");
  By searchButtonBy = By.name("btnK");

  public GoogleSearchPageChaining(WebDriver webDriver) {
    this.driver = webDriver;
  }

  public GoogleSearchPageChaining setSearchQuery(String query) {
    driver.findElement(searchFieldBy).sendKeys(query);
    return this;
  }

  public GoogleSearchPageChaining clickSearchButton() {
    WebElement searchButton =
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(searchButtonBy));
    return this;
  }
}
