package tests;

import common.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import listner.TestListener;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class AbstractTestBase extends Base {

    @Getter
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;

    @BeforeMethod
    public void setup() {
        System.out.println("Finish set up driver");
        var headless = System.getProperty("headless");
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        if (headless != null && headless.equals("true")) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        System.out.println("Start set up driver");
    }

    @AfterMethod(alwaysRun = true)
    public void quiteDriver() {
        System.out.println("Quite driver");
        driver.quit();
    }

    public void openUrl(String url) {
        driver.get(url);
    }
}