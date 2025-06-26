package org.in.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowFrameUtils {



    // Switch to frame by name or ID
    public static void switchToFrame(String nameOrId) {
        DriverFactory.getDriver().switchTo().frame(nameOrId);
    }

    // Switch to frame by index
    public static void switchToFrame(int index) {
        DriverFactory.getDriver().switchTo().frame(index);
    }

    // Switch to frame using By locator (XPath, CSS etc.)
    public static void switchToFrame(By locator) {
        WebElement frameElement =  DriverFactory.getDriver().findElement(locator);
        DriverFactory.getDriver().switchTo().frame(frameElement);
    }

    // Switch  back to default content
    public static void switchToDefaultContent() {
        DriverFactory.getDriver().switchTo().defaultContent();
    }

    // Switch  to window by title
    public static void switchToWindowByTitle(String expectedTitle) {
        Set<String> handles =  DriverFactory.getDriver().getWindowHandles();
        for (String handle : handles) {
            DriverFactory.getDriver().switchTo().window(handle);
            if ( DriverFactory.getDriver().getTitle().equalsIgnoreCase(expectedTitle)) {
                return;
            }
        }
        throw new RuntimeException("Window with title '" + expectedTitle + "' not found.");
    }

    // Switch  to specific window handle
    public static void switchToWindow(String windowHandle) {
        DriverFactory.getDriver().switchTo().window(windowHandle);
    }

    //  Get current window handle
    public static String getCurrentWindowHandle() {
        return  DriverFactory.getDriver().getWindowHandle();
    }

    // Get all open window handles
    public static Set<String> getAllWindowHandles() {
        return  DriverFactory.getDriver().getWindowHandles();
    }


}
