package org.in.pages;

import org.in.base.SeleniumComponents;
import org.in.utils.LogUtil;
import org.openqa.selenium.By;

public class LoginPage extends SeleniumComponents {


    private final By aboutUS = By.xpath("(//a[contains(text(),'About Us')])[1]");
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By products = By.xpath("//a[contains(text(),'Products')]");


    private final By home = By.xpath("//a[contains(text(),'home')]");
    private final By loginBtn = By.xpath("//input[@value='Log In']");
    private final By error = By.xpath("//p[@class='error']");

    public void clickAboutUS() {
        try {

            clickElement(aboutUS);
            LogUtil.info("clicked aboutUS");
        } catch (Exception e) {
            LogUtil.error("unable to click aboutUS");
            throw new RuntimeException("unable to click aboutUS: {}" + e.getMessage());
        }
    }

    public void goToProductsTab() {
        try {
            explicitWait(5);
            clickElement(products);
            LogUtil.info("clicked products tab");
        } catch (Exception e) {
            LogUtil.error("unable to click products tab");
            throw new RuntimeException("unable to click products tab: {}" + e.getMessage());
        }
    }

    public void clickHome() {
        try {

            clickElement(home);
            LogUtil.info("navigate to home page");
            explicitWait(10);
        } catch (Exception e) {
            LogUtil.error("unable to navigate to home page");
            throw new RuntimeException("unable to navigate to home page: {}" + e.getMessage());
        }
    }

    public void loginUser(String user, String pass) {
        try {

            sendKeysToElement(username, user);
            LogUtil.info("User sends username");
            sendKeysToElement(password, pass);
            LogUtil.info("User sends password");
            clickElement(loginBtn);
        } catch (Exception e) {
            LogUtil.error("unable to send username and password");
            throw new RuntimeException("unable to send username and password: {}" + e.getMessage());
        }
    }
    public void getError() {
        try {

           String str= getElementText(error);
            LogUtil.info("user fetches error string :{} "+str);
            explicitWait(10);
        } catch (Exception e) {
            LogUtil.error("unable to fetch error string :{}");
            throw new RuntimeException("unable to fetch error string :{}: {}" + e.getMessage());
        }
    }


}
