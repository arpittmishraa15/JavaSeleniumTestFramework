package org.in.base;

import org.in.utils.DriverFactory;
import org.in.utils.LogUtil;
import org.in.utils.WaitUtil;
import org.in.utils.WindowFrameUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class SeleniumComponents {

    private static WebDriver driver = null;

    public SeleniumComponents() {
        this.driver = DriverFactory.getDriver();
    }

    public void explicitWait(int timeInSeconds){
        try{
            Thread.sleep(timeInSeconds*1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void clickElement(By locator) {
        try {
            WaitUtil.waitForElementToBeClickable(driver, locator);
            driver.findElement(locator).click();
            LogUtil.info("Clicked element: " + locator);
        } catch (Exception e) {
            LogUtil.error("Failed to click element: " + locator);
            throw new RuntimeException("Click failed on: " + locator, e); // ❗Fail test
        }
    }

    // Send keys
    public void sendKeysToElement(By locator, String text) {
        try {
            WaitUtil.waitForElementToBeVisible(driver, locator);
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
            LogUtil.info("send keys to element: " + locator);
        }catch (Exception e) {
            LogUtil.error("Failed to send keys to element: " + locator);
            throw new RuntimeException("send keys  failed on: " + locator, e); // ❗Fail test
        }

    }

    public void clearElement(By locator) {
        try {
        WaitUtil.waitForElementToBeVisible(driver, locator);
        driver.findElement(locator).clear();
        }catch (Exception e) {
            LogUtil.error("Failed to clear element to element: " + locator);
            throw new RuntimeException("clear element failed on: " + locator, e); // ❗Fail test
        }
    }

    //  Get text

    public String getElementText(By locator) {
        try {
            WaitUtil.waitForElementToBeVisible(driver, locator);
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            LogUtil.error("Failed to get element text: " + locator);
            throw new RuntimeException("get element text failed on: " + locator, e); // ❗Fail test
        }
    }
    // Select from dropdown by visible text
    public void selectByVisibleText(By locator, String visibleText) {
        WaitUtil.waitForElementToBeVisible(driver, locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(visibleText);
    }


    /**
     * force click
     */
    public static void fireClick(By locator) {
        try {
            WebElement element= driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        } catch (Exception e) {
            LogUtil.error("Failed to click element: " + locator);
            throw new RuntimeException("click element failed on: " + locator, e); // ❗Fail test
        }
    }

    public void selectFromDropdown(By locator, String selectionType, String value){
        WaitUtil.waitForElementToBeVisible(driver, locator);
        Select dropdown=new Select(driver.findElement(locator));
        switch(selectionType.toLowerCase()){
            case "text":
                dropdown.selectByVisibleText(value);
                break;
            case "index":
                dropdown.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                dropdown.selectByValue(value);
                break;

            default:
                throw new IllegalArgumentException("Invalid selection type. use 'text', 'value' or 'index'." );
        }
    }
    //  Accept Alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // Dismiss Alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //  Get Alert Text
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    //  Frame switchers
    public void switchToFrame(By locator) {
        WindowFrameUtils.switchToFrame(locator);
    }

    public void switchToFrame(String nameOrId) {
        WindowFrameUtils.switchToFrame(nameOrId);
    }

    public void switchToFrame(int index) {
        WindowFrameUtils.switchToFrame(index);
    }

    public void switchToDefaultContent() {
        WindowFrameUtils.switchToDefaultContent();
    }

    //  Window switching
    public void switchToWindowByTitle(String title) {
        WindowFrameUtils.switchToWindowByTitle(title);
    }


    //  Element visibility checks
    public boolean isElementVisible(By locator) {
        try {
            WaitUtil.waitForElementToBeVisible(driver, locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //  Get attribute value
    public String getAttributeValue(By locator, String attributeName) {
        WaitUtil.waitForElementToBeVisible(driver, locator);
        return driver.findElement(locator).getAttribute(attributeName);
    }

    //  Dropdown: Select by value
    public void selectFromDropdownByValue(By locator, String value) {
        WaitUtil.waitForElementToBeVisible(driver, locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(value);
    }

    //  Dropdown: Select by index
    public void selectFromDropdownByIndex(By locator, int index) {
        WaitUtil.waitForElementToBeVisible(driver, locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(index);
    }

    //  JavaScript Click for hidden or stubborn elements
    public void jsClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    //  Scroll into view before action
    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //  Is element enabled
    public boolean isElementEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //  Is checkbox or radio selected
    public boolean isElementSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //  Scroll down (by pixels)
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    // Scroll up (by pixels)
    public void scrollUp(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-" + pixels + ")");
    }

    //  Check checkbox if not already selected
    public void checkCheckbox(By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    //  Uncheck checkbox if selected
    public void uncheckCheckbox(By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    //  Upload file using input[type='file']
    public void uploadFile(By locator, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException(" File not found at path: " + filePath);
        }
        WebElement fileInput = driver.findElement(locator);
        fileInput.sendKeys(file.getAbsolutePath());
    }

    //  Right-click (context click)
    public void rightClickElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.contextClick(element).perform();
    }

    public void doubleClickElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.doubleClick(element).perform();
    }


}
