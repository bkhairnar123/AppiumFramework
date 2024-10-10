package com.qa.utils;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {


    public UiAutomator2Options getCaps() throws IOException {

        Properties props = new PropertyManager().getProps();

        try{


            UiAutomator2Options options=new UiAutomator2Options();
            options.setPlatformName(props.getProperty("platformName"));
            options.setUdid("emulator-5554");
            options.setDeviceName("Android_Pixel_8");


            switch ("Android"){
                case "Android":
                    options.setAutomationName(props.getProperty("androidAutomationName"));
                    options.setAppPackage(props.getProperty("androidAppPackage"));
                    options.setAppActivity(props.getProperty("androidAppActivity"));
                    options.setSystemPort(4723);
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
                    options.setApp(androidAppUrl);
                    break;

                case "IOS":
                    break;

            }
            return options;
        } catch(Exception e){
            e.printStackTrace();
            //utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
