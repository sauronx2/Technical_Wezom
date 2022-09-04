package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class HomeElements extends AbstractBasePage {
    protected HomeElements(WebDriver driver) {
        super(driver);
    }

    private final static String HEADER_REGISTRATION_AUTHORIZATION_BTN = "//div[@class='header__actions-button']";
    private final static String REGISTRATION_AUTHORIZATION_POPUP_TEXT = "(//div[@class='h3 _text-center _mb-xl'])[1]";
    private final static String EMAIL_OR_NUMBER_POPUP_FIELD = "//div[@class='form-control']/input[@name='login']";
    private final static String PASSWORD_POPUP_FIELD = "//div[@class='form-control _mt-xs']/input[@name='password']";
    private final static String REGISTRATION_POPUP_BTN = "//div[contains(@class, 'popup__aside')]/button";
    private final static String REGISTRATION_POPUP_TEXT = "//div[@class='h3 _text-center _mb-xl']";
    private final static String FIRST_NAME_FIELD = "//input[@name='name']";
    private final static String LAST_NAME_FIELD = "//input[@name='surname']";
    private final static String TELEPHONE_FIELD = "//form[1]/div[4]/input[1][@name='phone']";
    private final static String EMAIL_FIELD = "//input[@name='email']";
    private final static String PASSWORD_FIELD = "//input[@name='password']";
    private final static String PASSWORD_CONFIRMATION_FIELD = "//div[@class='popup__view']//form//div[7]";
    private final static String TERMS_OF_USE_CHECKBOX = "//div[@class='form-control _mb-df']//input[@type='checkbox']";
    private final static String SUBMIT_REGISTRATION_BTN = "//button[@class='button button_full button_one']";
    private final static String PRODUCT_CATALOGUE_MENU = "//div[@class='menu__button ']";
    private final static String HOUSEHOLD_APPLIANCES = "//li/a[@href='https://evrika.wezom.agency/catalog/smartfony-i-gadzhety/c171']";
    private final static String FANS_CATEGORY = "//ul[@class='menu__sub-list _ul-like']//a[@href='https://evrika.wezom.agency/catalog/ventilyatory/c266']";
    private final static String X_CLOSE_POPUP_BTN = "//div/button[@class='modal-close']";
    private final static String BASKET_POPUP_TEXT = "//div[contains(@class, 'cart__title h3')]";
    private final static String BASKET_POPUP_CART_BODY = "//div[contains(@class, 'cart__body')]";
    private final static String BASKET_POPUP_SUBMIT_ORDER_BTN = "//a[@class='button button_one']";
    private final static String BASKET_POPUP_TOTAL_COST_VALUE = "//div[@class='cart-resume__cost-value']";

    public WebElement getRegistrationAuthorizationBtn() {
        return waitClickableElementByXpath(HEADER_REGISTRATION_AUTHORIZATION_BTN);
    }

    public WebElement getRegistrationAuthorizationPopUp() {
        return waitVisibleOfElement(REGISTRATION_AUTHORIZATION_POPUP_TEXT);
    }

    public WebElement getEmailOrNumberField() {
        return waitVisibleOfElement(EMAIL_OR_NUMBER_POPUP_FIELD);
    }

    public WebElement getPasswordField() {
        return waitVisibleOfElement(PASSWORD_POPUP_FIELD);
    }

    public WebElement getRegistrationPopUpBtn() {
        return waitClickableElementByXpath(REGISTRATION_POPUP_BTN);
    }

    public WebElement getRegistrationPopUpText() {
        return waitVisibleOfElement(REGISTRATION_POPUP_TEXT);
    }

    public WebElement getCurrentPurchaseBasketBtn(String supply) {
        return waitClickableElementByXpath(String.format("//div[contains(@class, 'goods-tile')]//a[contains(text(), '%s')]//../..//button[contains(@class, 'button_cart')]", supply));
    }
}
