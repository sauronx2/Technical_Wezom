package tests.evrikaTests;

import elements.CabinetElements;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.everikaPages.CheckoutPage;
import pages.everikaPages.HomePage;
import tests.AbstractTestBase;

public class TestRegistration extends AbstractTestBase {

    private final String firstName = "Oleksandr";
    private final String lastName = "Serhadov";
    private final String middleName = "Dmitrievich";
    private final String number = "0936192812";
    private final String email = "wezomtest@gmail.com";
    private final String password = "testPass321";
    private final String homePageUrl = "https://evrika.wezom.agency/";

    @DataProvider
    public Object[][] randomUserDataRegistration() {
        return new Object[][]{
                {firstName, lastName, number,
                        getRandomNumber() + email,
                        password, password, middleName}
        };
    }

    @Test(dataProvider = "randomUserDataRegistration")
    public void checkRegistration(String firstName, String lastName, String number, String email,
                                  String password, String passConf, String middleName) {
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CabinetElements cabinetElements = new CabinetElements(driver);

        openUrl(homePageUrl);
        homePage
                .goToRegistrationWindow();

        assertEquals(homePage.getRegistrationAuthorizationPopUpText().getText(), "Регистрация");

        homePage
                .enterRegistrationCredentials(firstName, lastName, number, email, password, passConf)
                .clickIAgreeCheckBox()
                .clickSubmitRegistrationBtn();

        assertTrue(cabinetElements.getCredentialsInCabinet().getText().contains(firstName));
        assertTrue(cabinetElements.getCredentialsInCabinet().getText().contains(lastName));

        homePage
                .moveToProductCatalogueMenu()
                .moveToHouseHoldAppliances()
                .moveAndClickToFansCategory()
                .clickOnProductAddToCartBtn("Вентилятор Maxwell MW-3546")
                .clickXClosePopUpBtn()
                .clickOnProductAddToCartBtn("Вентилятор Tefal VF6670F0");

        assertEquals(homePage.getBasketPopUpText().getText(), "Корзина");

        double valueInBasketPopUp = homePage.getParsedPriceValue(homePage.getBasketPopUpTotalCostValue());

        homePage
                .clickXClosePopUpBtn()
                .moveToBasketAncClickSubmitOrder();

        double valueInCheckout = homePage.getParsedPriceValue(checkoutPage.getTotalCost());
        assertEquals(valueInBasketPopUp, valueInCheckout);

        checkoutPage
                .setMiddleNameField(middleName)
                .clickDeliveryOrPaymentType("Самовывоз из магазина")
                .clickSelectStoreDropDownMenu()
                .clickStoreInList(1)
                .clickDeliveryOrPaymentType("Картой онлайн");

        assertTrue(checkoutPage.isVisibleContactsOtherRecipientRadioBtn());

        checkoutPage
                .clickSubmitOrderBtn();
    }
}
