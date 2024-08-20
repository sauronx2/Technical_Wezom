package tests.evrikaTests;

import elements.CabinetElements;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.everikaPages.CheckoutPage;
import pages.everikaPages.HomePage;
import tests.AbstractBaseTest;
import utils.DataProviderCredentials;

public class TestRegistration1 extends AbstractBaseTest {
    public final String homePageUrl = "https://evrika.wezom.agency/";

    @Test(dataProvider = "randomUserDataRegistration", dataProviderClass = DataProviderCredentials.class)
    @Description("End-to-End registration with adding two product in basket and submitting order")
    public void checkRegistrationWithOrdering(String firstName, String lastName, String number, String email,
                                              String password, String passConf, String middleName) {
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CabinetElements cabinetElements = new CabinetElements(driver);

        openUrl(homePageUrl);
        homePage
                .goToRegistrationWindow();

        assertEquals(homePage.getRegistrationAuthorizationPopUpText().getText(), "Регистрация");
    }
}
