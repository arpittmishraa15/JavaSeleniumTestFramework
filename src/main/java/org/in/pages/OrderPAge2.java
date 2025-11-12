package org.in.pages;

import org.apache.http.util.Asserts;
import org.in.base.SeleniumComponents;
import org.in.utils.LogUtil;
//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class OrderPAge2 extends SeleniumComponents {


    private final By mobile= By.xpath("//snbvb kcknsc knsc ']");
    private final By searchTab= By.name("q");
    private final By searchButton= By.xpath("//button[@class='MJG8Up']");
    private final By MensTab= By.xpath(  "(//span[@class='TSD49J'])[3]");
    private final By login= By.xpath(  "(//img[@alt='Login'])[1]");

    private final By phoneNumber= By.xpath(  "//input[@class='r4vIwl+Dqf']");
    public void clickMobile2(){
        try{
            explicitWait(5);
            clickElement(mobile);
            LogUtil.info(" not able to click mobile tab");
            throw new Exception("click failed!");
        }catch(Exception e){
            LogUtil.error("unable to click mobile tab still continuing");
        }
    }
    public void GoToSearchTab2(){
        try{
            explicitWait(5);
            clickElement(searchTab);
            LogUtil.info("clicked search tab");
        }catch(Exception e){
            LogUtil.error("unable to click search tab");
        }
    }


    public void clickMensTab2(){
        try{
            explicitWait(5);
            clickElement(MensTab);
            LogUtil.info("clicked Mens tab");
        }catch(Exception e){
            LogUtil.error("unable to click Mens tab");
        }
    }
    public void ClickLogin(){
        try{
            explicitWait(5);
            clickElement(login);
            LogUtil.info("clicked login tab");
        }catch(Exception e){
            LogUtil.error("unable to click login tab");
        }
    }
    public void phNO(){
        try{
            explicitWait(5);
            clickElement(phoneNumber);
            LogUtil.info("clicked number filed");

        }catch(Exception e){
            LogUtil.error("unable to click number filed");
//            Assert.fail("message" + " - " + e.getMessage());
            Assertions.fail("message" + " - " + e.getMessage());
        }
    }


}
