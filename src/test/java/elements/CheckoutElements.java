package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

import java.util.List;

public class CheckoutElements extends AbstractBasePage {
    protected CheckoutElements(WebDriver driver) {
        super(driver);
    }

    private final static String TOTAL_COST = "//div[@class='checkout-step__total-cost']";
    private final static String MIDDLE_NAME_FIELD = "//div[@class='form-control']/input[@class='form-input ']";
    private final static String SELECT_STORE_DROP_DOWN_MENU = "//div[@class='pickup__selected']";
    private final static String STORE_LIST = "//div/label/span[@class='pickup__option-inner']";

    private final static String SUBMIT_ORDER_BTN = "//div[@class='order__submit']/button[@class='button button_one button_full']";
    private final static String CONTACTS_OTHER_RECIPIENT_RADIO_BTN = "//div[@class='checkout-contacts']";

    public WebElement getDeliveryOrPaymentType(String deliveryOrPayment) {
        return waitVisibleOfElement(String.format("//span[@class='pay-method__inner']/span[contains(text(), '%s')]", deliveryOrPayment));
    }

    public WebElement getTotalCost() {
        return waitVisibleOfElement(TOTAL_COST);
    }

    public boolean isVisibleContactsOtherRecipientRadioBtn() {
        return waitInvisibilityOfElementLocated(CONTACTS_OTHER_RECIPIENT_RADIO_BTN);
    }

    public WebElement getMiddleNameField() {
        return waitClickableElementByXpath(MIDDLE_NAME_FIELD);
    }

    public WebElement getSelectStoreDropDownMenu() {
        return waitClickableElementByXpath(SELECT_STORE_DROP_DOWN_MENU);
    }

    public List<WebElement> getStoreList() {
        return waitPresenceOfElementsLocated(STORE_LIST);
    }

    public WebElement getSubmitOrderBtn() {
        return waitClickableElementByXpath(SUBMIT_ORDER_BTN);
    }

}
