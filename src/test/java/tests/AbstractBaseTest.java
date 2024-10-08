package tests;

import common.Base;
import listner.TestListener;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Boolean.*;
import static java.lang.Boolean.parseBoolean;

@Listeners(TestListener.class)
public abstract class AbstractBaseTest extends Base {

    @Getter
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;
    public static final String browserVersion = "126.0";
    public static final Logger logger = LogManager.getLogger(AbstractBaseTest.class);

    @Parameters({"headless", "useSelenoid"})
    @BeforeMethod
    @SneakyThrows
    public void setup(Method method, @Optional("false") String headless, @Optional("false") String useSelenoid) {
        logger.info("Setting up driver");

        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setBrowserVersion(browserVersion);

        if (parseBoolean(headless)) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
        }

        if (parseBoolean(useSelenoid)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            capabilities.setBrowserName("chrome");
            capabilities.setVersion(browserVersion);

            // Генерация уникального имени файла для видео
            String testClassName = method.getDeclaringClass().getSimpleName();
            String testMethodName = method.getName();
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String videoName = testClassName + "_" + testMethodName + "_" + timestamp + ".mp4";

            // Используем W3C-совместимые ключи через 'selenoid:options'
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            selenoidOptions.put("videoName", videoName);
            selenoidOptions.put("screenResolution", "1920x1080x24");
            selenoidOptions.put("videoFrameRate", 24);

            capabilities.setCapability("selenoid:options", selenoidOptions);

            var selenoidUrl = new URL("http://selenoid:4444/wd/hub");
            driver = new RemoteWebDriver(selenoidUrl, capabilities);
        } else {
            chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }

        driver.manage().window().maximize();
        logger.info("Driver setup completed for test method: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        logger.info("Quitting driver");
        if (driver != null) {
            driver.quit();
        }
    }

    public void openUrl(String url) {
        driver.get(url);
        logger.info("Opened URL: " + url);
    }
}
