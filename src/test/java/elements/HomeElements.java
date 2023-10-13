package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class HomeElements extends AbstractBasePage {
    public HomeElements(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegistrationAuthorizationBtn() {
        return waitClickableElementByXpath("//div[@class='header__actions-button']");
    }

    public WebElement getRegistrationAuthorizationPopUpText() {
        return waitVisibleOfElement("(//div[@class='h3 _text-center _mb-xl'])[1]");
    }

    public WebElement getFirstNameField() {
        return waitClickableElementByXpath("//input[@name='name']");
    }

    public WebElement getPasswordPopUpField() {
        return waitVisibleOfElement("//div[@class='form-control _mt-xs']/input[@name='password']");
    }

    public WebElement getEmailOrNumberPopUpField() {
        return waitVisibleOfElement("//div[@class='form-control']/input[@name='login']");
    }

    public WebElement getLastNameField() {
        return waitClickableElementByXpath("//input[@name='surname']");
    }

    public WebElement getTelephoneField() {
        return waitClickableElementByXpath("//form[1]/div[4]/input[1][@name='phone']");
    }

    public WebElement getEmailField() {
        return waitClickableElementByXpath("//input[@name='email']");
    }

    public WebElement getPasswordField() {
        return waitClickableElementByXpath("//input[@name='password']");
    }

    public WebElement getPasswordConfirmationField() {
        return waitClickableElementByXpath("//div[@class='popup__view']//form//div[7]/input");
    }

    public WebElement getRegistrationPopUpBtn() {
        return waitClickableElementByXpath("//div[contains(@class, 'popup__aside')]/button");
    }

    public WebElement getCurrentPurchaseBasketBtn(String supply) {
        return waitClickableElementByXpath(String.format("//div[contains(@class, 'goods-tile')]//a[contains(text(), '%s')]//../..//button[contains(@class, 'button_cart')]", supply));
    }

    public WebElement getIAgreeCheckBox() {
        return waitClickableElementByXpath("//label[@class='input-choice']/span[1]");
    }

    public WebElement getSubmitRegistrationBtn() {
        return waitClickableElementByXpath("//button[@class='button button_full button_one']");
    }

    public WebElement getProductCatalogueMenu() {
        return waitVisibleOfElement("//div[@class='menu__button ']");
    }

    public WebElement getHouseHoldAppliances() {
        return waitVisibleOfElement("//li/a[@href='https://evrika.wezom.agency/catalog/bytovaya-tehnika/c244']");
    }

    public WebElement getFansProduct() {
        return waitVisibleOfElement("//ul[@class='menu__sub-list _ul-like']//a[@href='https://evrika.wezom.agency/catalog/ventilyatory/c266']");
    }

    public WebElement getXClosePopUpBtn() {
        return waitClickableElementByXpath("//div/button[@class='modal-close']");
    }

    public WebElement getBasketBtn() {
        return waitClickableElementByXpath("//div[@class='header__cart-badge _flex _justify-center _items-center']");
    }

    public WebElement getSubmitOrderBtn() {
        return waitClickableElementByXpath("//a[@class='button button_one button_full button_size_sm _mb-sm']");
    }

    public WebElement getBasketPopUpText() {
        return waitVisibleOfElement("//div[contains(@class, 'cart__title h3')]");
    }

    public WebElement getBasketPopUpCartBody() {
        return waitVisibleOfElement("//div[contains(@class, 'cart__body')]");
    }

    public WebElement getBasketPopUpTotalCostValue() {
        return waitVisibleOfElement("//div[@class='cart-resume__cost-value']");
    }


}
