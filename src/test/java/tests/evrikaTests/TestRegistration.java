package tests.evrikaTests;

import elements.CabinetElements;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.everikaPages.CabinetPage;
import pages.everikaPages.HomePage;
import tests.AbstractTestBase;

import static utils.ElementUtil.moveToElement;

public class TestRegistration extends AbstractTestBase {
    private final String email = "wezomtest@gmail.com";
    private final String password = "testPass321";
    private final String homePageUrl = "https://evrika.wezom.agency/";

    @DataProvider
    public Object[][] randomUserDataRegistration() {
        return new Object[][]{
                {"Oleksandr", "Serhadov", "0936192812",
                        createRandomNumber() + email,
                        password, password}
        };
    }

    @Test(dataProvider = "randomUserDataRegistration")
    public void checkRegistration(String firstName, String lastName, String number, String email, String password, String passConf) {
        HomePage homePage = new HomePage(driver);
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
                .moveAndClickToFansCategory();

    }
}
