package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommonActions {

    @SneakyThrows
    public static void scrollForElement(WebElement element, WebDriver drv) {
        ((JavascriptExecutor) drv).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(200);
    }
}
