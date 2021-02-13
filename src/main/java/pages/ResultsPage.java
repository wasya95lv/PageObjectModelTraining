package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
  WebDriver driver;
  By googleLogo = By.id("logo");

  public ResultsPage(WebDriver driver) {
    this.driver = driver;

    if (driver.findElements(googleLogo).size() == 0) {
      throw new IllegalStateException(
          "Wrong page. Expected to find Google logo, but nothing was found. Current page is: "
              + driver.getCurrentUrl());
    }
  }

  public WebElement getResultByText(String titleText) {
    By locator = By.xpath("//h3/span[text()='" + titleText + "']");
    return new WebDriverWait(driver, 5)
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }
}
