package pages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractBasePage extends Base {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private final int BASE_WAIT = 15;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
    }

    protected WebElement waitVisibleOfElement(String locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("No visibility element: " + locator);
            return null;
        }
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("No clickable element: " + locator);
            return null;
        }
    }

    protected WebElement waitPresenceOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("No presence element: " + locator);
            return null;
        }
    }

    protected List<WebElement> waitPresenceOfElementsLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("No presence elements: " + locator);
            return null;
        }
    }

    protected boolean waitInvisibilityOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("Element is visibility: " + locator);
            return false;
        }
    }
}
