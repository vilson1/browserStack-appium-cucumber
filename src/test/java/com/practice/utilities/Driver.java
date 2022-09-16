package com.practice.utilities;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver; // value is null by default

    private static ThreadLocal<AppiumDriver> driver=new ThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static AppiumDriver getDriver(){
             return driver.get();
        }
        public static void setDriver(AppiumDriver driver1){
        driver.set(driver1);
        }
        public static void initializeDriver(String deviceID) throws Exception{
        AppiumDriver driver;

        String userName=System.getenv("BROWSERSTACK_USERNAME");
        String accessKey=System.getenv("BROWSERSTACK_ACCESS_KEY");
        String buildName=System.getenv("BROWSERSTACK_BUILD_NALE");
        String app=System.getenv("BROWSERsTUCK_APP_ID");

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("device",ConfigurationReader.getProperty("device"));
        

        }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }
    }

}
