package org.in.pages;

import org.in.base.SeleniumComponents;
import org.in.utils.LogUtil;
import org.openqa.selenium.By;

public class OrderPAge2 extends SeleniumComponents {


    private final By mobile= By.xpath("//snbvb kcknsc knsc ']");
    private final By searchTab= By.name("q");
    private final By searchButton= By.xpath("//button[@class='MJG8Up']");
    private final By MensTab= By.xpath(  "(//span[@class='TSD49J'])[3]");
//    private final By MensTab= By.xpath(  "//span[contains(text(), 'Men')]");


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

    public void searchMonitor2(String product){
        try{
            explicitWait(5);
            sendKeysToElement(searchTab, product);
            LogUtil.info("Entered data in search tab");
//            sendKeysToElement(searchTab, String.valueOf(Keys.ENTER));
            clickElement(searchButton);
            explicitWait(10);
        }catch(Exception e){
            LogUtil.error("unable Enter data in search tab");
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

}
