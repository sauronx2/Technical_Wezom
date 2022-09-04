package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class CabinetElements extends AbstractBasePage {
    public CabinetElements(WebDriver driver) {
        super(driver);
    }

    private static final String CREDENTIALS_IN_CABINET = "//div[@class='_grid _grid--1 _sm:grid--2 _spacer _spacer--df']";

    public WebElement getCredentialsInCabinet() {
        return waitVisibleOfElement(CREDENTIALS_IN_CABINET);
    }
}
