package org.in.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private static final int DEFAULT_WAIT=30;

    public static void waitForElementToBeClickable(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT)).until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForElementToBeVisible(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForPresenceOfAnElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
