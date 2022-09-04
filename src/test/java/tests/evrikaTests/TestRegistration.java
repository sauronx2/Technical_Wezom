package tests.evrikaTests;

import org.testng.annotations.Test;
import tests.AbstractTestBase;

public class TestRegistration extends AbstractTestBase {

    @Test
    public void checkRegistration() {
        openUrl("https://evrika.wezom.agency/");
    }
}
