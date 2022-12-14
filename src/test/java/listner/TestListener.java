package listner;

import common.Base;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.AbstractTestBase;

public class TestListener extends Base implements ITestListener {

    Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("---------------------------------------------------------------");
        logger.info("Failed because of - " + result.getThrowable());
        logger.info("---------------------------------------------------------------");
        WebDriver driver = ((AbstractTestBase) result.getInstance()).getDriver();
        if (driver != null) {
            captureScreen(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("---------------------------------------------------------------");
        logger.info("Skipped because of - " + result.getThrowable());
        logger.info("---------------------------------------------------------------");
        WebDriver driver = ((AbstractTestBase) result.getInstance()).getDriver();
        if (driver != null) {
            captureScreen(driver);
        }
    }
}