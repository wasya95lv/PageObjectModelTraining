package seleniumIntro;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumIntro {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void searchTest() {
        driver.get("https://google.com");
        driver.manage().window().maximize();

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium" + Keys.ENTER);

        WebElement firstResult = new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Selenium WebDriver']"))
        );

        firstResult.click();
        WebElement gettingStartedElement = driver.findElement(By.className("getting-started"));

        String actual = gettingStartedElement.findElement(By.tagName("h2")).getText();
        String expected = "Getting Started";

        Assert.assertEquals(actual,expected);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
