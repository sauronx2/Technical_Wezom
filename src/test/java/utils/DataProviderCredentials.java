package utils;

import common.Base;
import org.testng.annotations.DataProvider;

public class DataProviderCredentials extends Base {
    private final static String FIRST_NAME = "Oleksandr";
    private final static String LAST_NAME = "Kachan";
    private final static String MIDDLE_NAME = "Dmitrievich";
    private final static String NUMBER = "0932342716";
    private final static String EMAIL = "wezomtest@gmail.com";
    private final static String PASSWORD = "testPass321";

    @DataProvider
    public static Object[][] randomUserDataRegistration() {
        return new Object[][]{
                {FIRST_NAME, LAST_NAME, NUMBER,
                        getRandomNumber() + EMAIL,
                        PASSWORD, PASSWORD, MIDDLE_NAME}
        };
    }
}
