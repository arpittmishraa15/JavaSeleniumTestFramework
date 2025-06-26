package org.in.utils;

public class NavigationUtils {

    private static final String BASE_URL = ConfigUtil.getProp("url");


    public static void navigateTo() {
        DriverFactory.getDriver().get(BASE_URL);
        LogUtil.info("Navigating to URL: " + BASE_URL);
    }

}
