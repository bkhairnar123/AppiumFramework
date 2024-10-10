package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {

   private static AppiumDriver driver ;


    public AppiumDriver getDriver(){
        return driver;
    }



    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        PropertyManager props = new PropertyManager();

        if(driver == null){
            try{

                switch("Android"){
                    case "Android":
                        driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }

                this.driver=driver;
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

    }

}
