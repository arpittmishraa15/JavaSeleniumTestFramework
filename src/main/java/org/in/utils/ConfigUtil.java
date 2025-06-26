package org.in.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    private static Properties prop = new Properties();

    static {
        try{
            prop=new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/Config.properties");
            prop.load(fis);
        }catch(IOException e){
            LogUtil.error("failed to load config.properties file"+e.getMessage());
        }
    }

    public static String getProp(String key) {
        return prop.getProperty(key);
    }
}
