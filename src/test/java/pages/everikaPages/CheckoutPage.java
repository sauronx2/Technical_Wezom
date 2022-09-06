package pages.everikaPages;

import elements.CheckoutElements;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends CheckoutElements {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickDeliveryOrPaymentType(String deliveryOrPayment) {
        getDeliveryOrPaymentType(deliveryOrPayment).click();
        return this;
    }

    public CheckoutPage setMiddleNameField(String middleName) {
        getMiddleNameField().sendKeys(middleName);
        return this;
    }

    public CheckoutPage clickSelectStoreDropDownMenu() {
        getSelectStoreDropDownMenu().click();
        return this;
    }

    public CheckoutPage clickStoreInList(int storeNumber) {
        getStoreList().get(storeNumber).click();
        return this;
    }

    public CheckoutPage clickSubmitOrderBtn() {
        getSubmitOrderBtn().click();
        return this;
    }
}
