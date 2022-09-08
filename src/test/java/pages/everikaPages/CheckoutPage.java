package pages.everikaPages;

import elements.CheckoutElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.CommonActions.scrollForElement;

public class CheckoutPage extends CheckoutElements {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final String middleNameField = "Отчество";
    @Step("Click delivery or payment type")
    public CheckoutPage clickDeliveryOrPaymentType(String deliveryOrPayment) {
        getDeliveryOrPaymentType(deliveryOrPayment).click();
        return this;
    }

    @Step("Set middle name")
    public CheckoutPage setMiddleNameField(String middleName) {
        getCredentialsFieldTypeToBeClickable(middleNameField).sendKeys(middleName);
        String x = getCredentialsFieldTypeToBeVisible(middleNameField).getAttribute("value");
        if (x.contains(middleName)) {
            captureScreen(driver);
        }
        return this;
    }

    @Step("Click on store drop-down menu")
    public CheckoutPage clickSelectStoreDropDownMenu() {
        getSelectStoreDropDownMenu().click();
        return this;
    }

    @Step("Click on store by id in DOM")
    public CheckoutPage clickStoreInList(int storeNumber) {
        scrollForElement(getDeliveryOrPaymentOrRecipient("Оплата"), driver);
        WebElement element = getStoreList().get(storeNumber);
        element.click();
        return this;
    }

    @Step("Click on 'Submit order' button")
    public CheckoutPage clickSubmitOrderBtn() {
        getSubmitOrderBtn().click();
        return this;
    }

    @Step("Click on 'OK' button in error popup")
    public CheckoutPage clickOrderErrorBtn() {
        getOrderCreatingErrorBtn().click();
        return this;
    }
}
