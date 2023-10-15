package tests;

import common.Base;
import listner.TestListener;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Boolean.parseBoolean;

@Listeners(TestListener.class)
public abstract class AbstractBaseTest extends Base {

    @Getter
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;
    public static final Logger logger = LogManager.getLogger(AbstractBaseTest.class);

    @Parameters({"headless"})
    @BeforeMethod
    public void setup(@Optional("false") String headless) {
        logger.info("Setting up driver");

        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        if (parseBoolean(headless)) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
        }

        chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        logger.info("Driver setup completed");
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        logger.info("Quitting driver");
        driver.quit();
    }

    public void openUrl(String url) {
        driver.get(url);
        logger.info("Opened URL: " + url);
    }
}
