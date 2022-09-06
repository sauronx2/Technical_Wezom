package tests;

import common.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import listner.TestListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class AbstractTestBase extends Base {

    protected WebDriver driver;

    private final Logger logger = LogManager.getLogger(AbstractTestBase.class);

    @BeforeMethod
    public void setup() {
        logger.info("Start set up driver");
        String headless = System.getProperty("headless");
        if (headless == null) {
            headless = "";
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless.contains("true")) {
            chromeOptions.setHeadless(true);
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        if (headless.equals("headless")) {
            driver.manage().window().setSize(new Dimension(1920, 1200));
        } else {
            driver.manage().window().maximize();
        }
        logger.info("Finish set up driver");
    }

    @AfterMethod(alwaysRun = true)
    public void quiteDriver() {
        logger.info("Quite driver");
        driver.quit();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}