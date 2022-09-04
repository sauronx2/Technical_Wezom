package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class FansElements extends AbstractBasePage {
    protected FansElements(WebDriver driver) {
        super(driver);
    }

    private final static String PURCHASE_BASKET_BTN = "";

    public WebElement getCurrentPurchaseBasketBtn(String productName) {
        return waitClickableElementByXpath(String.format("//div[contains(@class, 'goods-tile')]//a[contains(text(), '%s')]//../..//button[contains(@class, 'button_cart')]", productName));
    }
}
