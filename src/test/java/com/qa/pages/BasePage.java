package com.qa.pages;

import com.qa.utils.DriverManager;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {
    private AppiumDriver driver;


    public BasePage(){
       // this.driver = new DriverManager().getDriver();
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(WebElement e, String msg) {
        waitForVisibility(e);

        e.click();
    }

    public void click(By e, String msg) {
        waitForVisibility(e);

        driver.findElement(e).click();
    }

    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void sendKeys(WebElement e, String txt, String msg) {
        waitForVisibility(e);

        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(WebElement e, String msg) {
        String txt;
        txt = getAttribute(e, "text");
                return txt;
        }





    public String getText(By e, String msg) {
        String txt;
        txt = getAttribute(e, "text");

            return txt;
        }

        public void closeApp () {
            switch ("Android") {
                case "Android":
                    ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                            getCapability("appPackage").toString());
                    break;
                case "iOS":
                    ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                            getCapability("bundleId").toString());
            }
        }

        public void launchApp () {
            switch ("Android") {
                case "Android":
                    ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                            getCapability("appPackage").toString());
                    break;
                case "iOS":
                    ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                            getCapability("bundleId").toString());
            }
        }

        public WebElement andScrollToElementUsingUiScrollable (String childLocAttr, String childLocValue){
            return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                            + "new UiSelector()." + childLocAttr + "(\"" + childLocValue + "\"));"));
        }

        public WebElement iOSScrollToElementUsingMobileScroll (WebElement e){
            RemoteWebElement element = ((RemoteWebElement) e);
            String elementID = element.getId();
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
            scrollObject.put("toVisible", "sdfnjksdnfkld");
            driver.executeScript("mobile:scroll", scrollObject);
            return e;
        }

        public By iOSScrollToElementUsingMobileScrollParent (WebElement parentE, String predicateString){
            RemoteWebElement parent = (RemoteWebElement) parentE;
            String parentID = parent.getId();
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("element", parentID);
//	  scrollObject.put("direction", "down");
            scrollObject.put("predicateString", predicateString);
//	  scrollObject.put("name", "test-ADD TO CART");
//        scrollObject.put("toVisible", "sdfnjksdnfkld");
            driver.executeScript("mobile:scroll", scrollObject);
            By m = AppiumBy.iOSNsPredicateString(predicateString);
            System.out.println("Mobilelement is " + m);
            return m;
        }



        public boolean find ( final WebElement element, int timeout){
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                return wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        if (element.isDisplayed()) {
                            return true;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                return false;
            }
        }

        public boolean find ( final By element, int timeout){
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                return wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        if (driver.findElement(element).isDisplayed()) {
                            return true;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                return false;
            }
        }


    }