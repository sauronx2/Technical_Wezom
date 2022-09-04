package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class CheckoutElements extends AbstractBasePage {
    protected CheckoutElements(WebDriver driver) {
        super(driver);
    }

    private final static String TOTAL_COST = "//div[@class='checkout-step__total-cost']";
    private final static String PAYMENT_TYPE = "//div[@class='checkout-step__total-cost']";

    public WebElement getDeliveryType(String deliveryType) {
        return waitClickableElementByXpath(String.format("//span[@class='pay-method__inner']/span[contains(text(), '%s')]", deliveryType));
    }
}
