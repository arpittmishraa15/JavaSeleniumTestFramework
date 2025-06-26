package org.in.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (driver.get() == null || driver.get().toString().contains("null")) {
            driver.set(initializeDriver());//Always start a fresh Webdriver session
        }
        return driver.get();
    }

    private static WebDriver initializeDriver() {
        WebDriver newDriver = null;
        String runMode = ConfigUtil.getProp("run.mode");
        LogUtil.info(runMode);
        try {
            switch (runMode.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    newDriver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    newDriver = new FirefoxDriver(firefoxOptions);
                    break;

                case "sauce-chrome":
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 11");
                    browserOptions.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("username", ConfigUtil.getProp("sauce.user"));
                    sauceOptions.put("accessKey", ConfigUtil.getProp("sauce.AccessKey"));
                    sauceOptions.put("build", "<your build id>");
                    sauceOptions.put("name", "<your test name>");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    newDriver = new RemoteWebDriver(new URL(ConfigUtil.getProp("sauce.url")), browserOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + runMode);


            }
        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed: " + e.getMessage(), e);
        }
        return newDriver;
    }


    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }


}
