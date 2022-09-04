package pages.everikaPages;

import elements.HomeElements;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
    @SneakyThrows
    public HomePage enterRegistrationCredentials(String firstName, String lastName, String number, String email, String password, String passConf) {
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getTelephoneField().sendKeys(number);
        Thread.sleep(200);
        getEmailField().sendKeys(email);
        Thread.sleep(200);
        getPasswordField().sendKeys(password);
        Thread.sleep(200);
        getPasswordConfirmationField().sendKeys(passConf);
        return this;
    }

    @Step("")
    public HomePage clickIAgreeCheckBox() {
        Actions actions = new Actions(driver);
        int xOffset = -getIAgreeCheckBox().getSize().width / 2 + 50;
        actions.moveToElement(getIAgreeCheckBox(), xOffset, 0)
                .pause(1).click().build().perform();
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
}
