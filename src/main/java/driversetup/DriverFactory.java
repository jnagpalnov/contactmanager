package driversetup;

import commonutils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Jatin on 9/29/2018.
 */
public class DriverFactory {

    private  AppiumDriver appiumDriver;

    /**
     * Singleton class
     */
    private DriverFactory() {
        intializeAppiumDriver();
    }

    private static DriverFactory instanceOfDriverFactory;

    public static DriverFactory getInstanceOfDriverFactory() {
        if(instanceOfDriverFactory ==null)
        {
            instanceOfDriverFactory = new DriverFactory();
        }
        return instanceOfDriverFactory;
    }

    /**
     * Intiliaze Appium driver
     */
    private void intializeAppiumDriver()  {
        File app = new File("src/test/resources", CommonUtils.getCentralData("App"));

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,CommonUtils.getCentralData("PlatformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,CommonUtils.getCentralData("PlatformVersion"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,CommonUtils.getCentralData("DeviceName"));
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage",CommonUtils.getCentralData("AppPackage"));
        capabilities.setCapability("appActivity",CommonUtils.getCentralData("AppActivity"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,120);

        try {
            appiumDriver= new AppiumDriver(new URL(CommonUtils.getCentralData("AppiumServerURL")),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return instance of appium driver
     */
    public AppiumDriver getAppiumDriver(){
        return  appiumDriver;
    }
}
