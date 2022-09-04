package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class CheckoutElements extends AbstractBasePage {
    protected CheckoutElements(WebDriver driver) {
        super(driver);
    }

    private final static String TOTAL_COST = "//div[@class='checkout-step__total-cost']";
    private final static String SUBMIT_ORDER_BTN = "//div[@class='order__submit']/button[@class='button button_one button_full']";

    public WebElement getDeliveryOrPaymentType(String deliveryOrPayment) {
        return waitVisibleOfElement(String.format("//span[@class='pay-method__inner']/span[contains(text(), '%s')]", deliveryOrPayment));
    }
}
