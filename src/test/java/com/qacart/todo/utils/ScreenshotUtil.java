package com.qacart.todo.utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, ITestResult result) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            attachScreenshot(file);
            String imagePathAndName = "target" + File.separator +
                    "screenshots" + File.separator +
                    result.getMethod().getMethodName() + ".png";
            FileUtils.copyFile(file , new File(imagePathAndName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void attachScreenshot(File file) {
        try {
            InputStream in = new FileInputStream(file);
            Allure.addAttachment("screenshot", in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
