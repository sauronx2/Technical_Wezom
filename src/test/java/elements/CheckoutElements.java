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
    private final static String CHECKOUT_FIELD_TYPE = "//div[@class='form-control']/label[@class='form-label'][contains(text(), 'Отчество')]/../input[@class='form-input ']";
    private final static String SELECT_STORE_DROP_DOWN_MENU = "//div[@class='pickup__selected']";
    private final static String STORE_LIST = "//div/label/span[@class='pickup__option-inner']";
    private final static String SUBMIT_ORDER_BTN = "//div[@class='order__submit']/button[@class='button button_one button_full']";
    private final static String CONTACTS_OTHER_RECIPIENT_RADIO_BTN = "//div[@class='checkout-contacts']";
    private final static String ORDER_CREATING_ERROR_POPUP_MESSAGE = "//h2[@class='swal2-title']";
    private final static String ORDER_CREATING_ERROR_POPUP_OK_BTN = "//button[@class='swal2-confirm swal2-styled']";

    public WebElement getDeliveryOrPaymentType(String deliveryOrPayment) {
        return waitVisibleOfElement(String.format("//span[@class='pay-method__inner']/span[contains(text(), '%s')]", deliveryOrPayment));
    }

    public WebElement getDeliveryOrPaymentOrRecipient(String deliveryPaymentRecipient) {
        return waitVisibleOfElement(String.format("//div[@class='checkout-services__title _mb-md _md:m-none'][contains(text(), '%s')]", deliveryPaymentRecipient));
    }

    public WebElement getTotalCost() {
        return waitVisibleOfElement(TOTAL_COST);
    }

    public boolean isInvisibilityContactsOtherRecipientRadioBtn() {
        return waitInvisibilityOfElementLocated(CONTACTS_OTHER_RECIPIENT_RADIO_BTN);
    }

    public WebElement getCredentialsFieldTypeToBeClickable(String fieldType) {
        return waitClickableElementByXpath(String.format(CHECKOUT_FIELD_TYPE, fieldType));
    }

    public WebElement getCredentialsFieldTypeToBeVisible(String fieldType) {
        return waitVisibleOfElement(String.format(CHECKOUT_FIELD_TYPE, fieldType));
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

    public WebElement getOrderCreatingErrorMessage() {
        return waitVisibleOfElement(ORDER_CREATING_ERROR_POPUP_MESSAGE);
    }

    public boolean isVisibleOrderCreatingErrorMessage() {
        return waitInvisibilityOfElementLocated(ORDER_CREATING_ERROR_POPUP_MESSAGE);
    }

    public WebElement getOrderCreatingErrorBtn() {
        return waitVisibleOfElement(ORDER_CREATING_ERROR_POPUP_OK_BTN);
    }
}
