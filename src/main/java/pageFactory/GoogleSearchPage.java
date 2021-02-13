package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
  WebDriver driver;

  @FindBy(name = "q")
  WebElement searchField;

  @FindBy(name = "btnK")
  WebElement searchBtn;

  public GoogleSearchPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void sendSearchQuery(String query) {
    searchField.sendKeys(query + Keys.ENTER);
  }
}
