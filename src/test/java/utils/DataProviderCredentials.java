package utils;

import common.Base;
import org.testng.annotations.DataProvider;

public class DataProviderCredentials extends Base {
    private final static String firstName = "Oleksandr";
    private final static String lastName = "Serhadov";
    private final static String middleName = "Dmitrievich";
    private final static String number = "0936192812";
    private final static String email = "wezomtest@gmail.com";
    private final static String password = "testPass321";

    @DataProvider
    public static Object[][] randomUserDataRegistration() {
        return new Object[][]{
                {firstName, lastName, number,
                        getRandomNumber() + email,
                        password, password, middleName}
        };
    }
}
