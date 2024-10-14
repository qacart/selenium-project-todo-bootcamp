package com.qacart.todo.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, ITestResult result) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            String imagePathAndName = "target" + File.separator +
                    "screenshots" + File.separator +
                    result.getMethod().getMethodName() + ".png";
            FileUtils.copyFile(file , new File(imagePathAndName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
