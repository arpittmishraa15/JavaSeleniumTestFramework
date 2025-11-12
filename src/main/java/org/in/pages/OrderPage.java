package org.in.pages;

import org.in.base.SeleniumComponents;
import org.in.utils.DriverFactory;
import org.in.utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class OrderPage extends SeleniumComponents {


   private final By mobile= By.xpath("//img[@alt='Mobiles & Tablets']");
   private final By searchTab= By.name("q");
    private final By searchButton= By.xpath("//button[@class='MJG8Up']");
    private final By MensTab= By.xpath(  "(//span[@class='TSD49J'])[3]");



    public void clickMobile(){
        try{
            APITesting.triggerGetAPI();
            explicitWait(5);
            clickElement(mobile);
            LogUtil.info("clicked mobile tab");
        }catch(Exception e){
            LogUtil.error("unable to click mobile tab");
        }
    }
    public void GoToSearchTab(){
        try{
            explicitWait(5);
            clickElement(searchTab);
            LogUtil.info("clicked search tab");
        }catch(Exception e){
            LogUtil.error("unable to click search tab");
        }
    }

    public void searchMonitor(String product){
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
    public void clickMensTab(){
        try{
            explicitWait(5);
            clickElement(MensTab);
            LogUtil.info("clicked Mens tab");
        }catch(Exception e){
            LogUtil.error("unable to click Mens tab");
        }
    }

}
