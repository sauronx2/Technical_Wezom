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

    @Step("")
    public HomePage goToRegistrationWindow() {
        getRegistrationAuthorizationBtn().click();
        getRegistrationPopUpBtn().click();
        return this;
    }

    @Step("")
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
        return this;
    }

    @Step("")
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

    public HomePage clickSubmitRegistrationBtn() {
        getSubmitRegistrationBtn().click();
        return this;
    }

    public HomePage moveToProductCatalogueMenu() {
        moveToElement(driver, getProductCatalogueMenu());
        return this;
    }

    public HomePage moveToHouseHoldAppliances() {
        moveToElement(driver, getHouseHoldAppliances());
        return this;
    }

    public HomePage moveAndClickToFansCategory() {
        moveToElement(driver, getFansCategory());
        getFansCategory().click();
        return this;
    }

    public HomePage moveToBasketAncClickSubmitOrder() {
        ElementUtil.moveToElement(driver, getBasketBtn());
        getSubmitOrderBtn().click();
        return this;
    }

    public HomePage clickOnProductAddToCartBtn(String productName) {
        getCurrentPurchaseBasketBtn(productName).click();
        return this;
    }

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
}
