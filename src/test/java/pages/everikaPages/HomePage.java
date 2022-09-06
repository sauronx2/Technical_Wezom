package pages.everikaPages;

import elements.HomeElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.ElementUtil;

import static utils.CommonActions.scrollForElement;
import static utils.ElementUtil.moveToElement;

public class HomePage extends HomeElements {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on registration icon and click 'Registration'")
    public HomePage goToRegistrationWindow() {
        getRegistrationAuthorizationBtn().click();
        getRegistrationPopUpBtn().click();
        return this;
    }

    @Step("Enter credentials in registration fields")
    public HomePage enterRegistrationCredentials(String firstName, String lastName, String number, String email, String password, String passConf) {
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getTelephoneField().sendKeys(number);
        sleep(200);
        getEmailField().sendKeys(email);
        sleep(200);
        getPasswordField().sendKeys(password);
        sleep(200);
        getPasswordConfirmationField().sendKeys(passConf);
        captureScreen(driver);
        return this;
    }

    @Step("Click on 'Agree Terms Of Use' checkbox")
    public HomePage clickIAgreeCheckBox() {
        scrollForElement(getIAgreeCheckBox(), driver);
        Actions actions = new Actions(driver);
        int xOffset = -getIAgreeCheckBox().getSize().width / 2 + 30;
        Action act = actions.moveToElement(getIAgreeCheckBox(), xOffset, 0)
                .pause(1).click().build();
        sleep(500);
        act.perform();
        return this;
    }

    @Step("Click on 'Submit registration' button")
    public HomePage clickSubmitRegistrationBtn() {
        getSubmitRegistrationBtn().click();
        return this;
    }

    @Step("Move cursor to 'Product catalogue' menu")
    public HomePage moveToProductCatalogueMenu() {
        moveToElement(driver, getProductCatalogueMenu());
        return this;
    }

    @Step("Move cursor to 'House hold Appliances' category")
    public HomePage moveToHouseHoldAppliances() {
        moveToElement(driver, getHouseHoldAppliances());
        return this;
    }

    @Step("Move cursor to 'Fans' and click")
    public HomePage moveAndClickToFans() {
        moveToElement(driver, getFansProduct());
        getFansProduct().click();
        return this;
    }

    @Step("Move cursor to basket and click 'Submit order'")
    public HomePage moveToBasketAncClickSubmitOrder() {
        ElementUtil.moveToElement(driver, getBasketBtn());
        getSubmitOrderBtn().click();
        return this;
    }

    @Step("Chose product by 'productName' and click add to basket")
    public HomePage clickOnProductAddToBasketBtn(String productName) {
        scrollForElement(getCurrentPurchaseBasketBtn(productName), driver);
        getCurrentPurchaseBasketBtn(productName).click();
        if (getBasketPopUpCartBody().isDisplayed()) {
            captureScreen(driver);
        }
        return this;
    }

    @Step("Click on 'X - close' button in popup window")
    public HomePage clickXClosePopUpBtn() {
        getXClosePopUpBtn().click();
        return this;
    }

    public double getParsedPriceValue(WebElement element) {
        double totalSum = 0;
        String amountString = element.getText();
        double price = Double.parseDouble(amountString.replaceAll("[^\\d.]", ""));
        totalSum = totalSum + price;
        return totalSum;
    }

    @Step("Get price in basket and checkout for equals it")
    public void getParsedPriceInBasketAndEqualsPriceInCheckout() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        double valueInBasketPopUp = getParsedPriceValue(getBasketPopUpTotalCostValue());
        clickXClosePopUpBtn();
        moveToBasketAncClickSubmitOrder();
        double valueInCheckout = getParsedPriceValue(checkoutPage.getTotalCost());
        assertEquals(valueInBasketPopUp, valueInCheckout);
    }
}
