package baseclasses;

import commonutils.CommonUtils;
import driversetup.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Jatin on 9/29/2018.
 */
public class BasePage {
    public AppiumDriver appiumDriver;
    WebDriverWait wait;
    String appPackage;

   public BasePage(AppiumDriver appiumDriver){
       this.appiumDriver=appiumDriver;
       setWait(Integer.parseInt(CommonUtils.getCentralData("WaitTimeoutInSeconds")));
       appPackage=CommonUtils.getCentralData("AppPackage");
   }

    /**
     * @param by
     * @return wait for visiblity of element and then return true if element is present else false
     */
   public boolean isElementPresent(By by){
       try {
           return wait.until(ExpectedConditions.visibilityOfElementLocated(by)) != null;
       }
       catch (TimeoutException ex){
           return false;
       }
   }

    /**
     * @param by element
     * @param swipeMaxCount maximum swipe attempt to find the element
     * @return WebElement
     */
    public WebElement swipeDownToElement(By by,int swipeMaxCount)  {
        setWait(5);
        while (find(by) == null && swipeMaxCount>0) {
            Dimension size = appiumDriver.manage().window().getSize();
            int sx = (int) (size.getWidth() * 0.50);
            int sy = (int) (size.getHeight() * 0.80);
            int ex = (int) (size.getWidth() * 0.50);
            int ey = (int) (size.getHeight() * 0.20);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(sx, sy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10))).moveTo(PointOption.point(ex, ey)).release().perform();
            swipeMaxCount--;
        }
        return find(by);
    }

    /**
     * @param by
     * @return return @text property of element
     */
   public String getElementText(By by){
       return find(by).getAttribute("text");
   }

   public List<WebElement> findElements(By by){
       try {
           return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
       }
       catch (TimeoutException ex){
           return null;
       }
   }

    public WebElement find(By by){
       try {
          return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
       }
        catch (TimeoutException ex){
           return null;
        }
    }

   public By xpathWithResourceId(String resourceId){
       By by=By.xpath("//*[contains(@resource-id,'"+ resourceId +"')]") ;
       return by;
   }

    public By resourceId(String resourceId){
        return By.id(appPackage + ":id/" + resourceId);
    }

    public By xpathWithText(String text){
        return By.xpath("//*[contains(@text,'"+ text +"')]");
    }

    public void clickElement(WebElement webElement){
       webElement.click();
   }

   public void enterText(WebElement webElement, String text){
        webElement.sendKeys(text);
    }


   private void setWait(long timeoutInSeconds ){
       wait=new WebDriverWait(appiumDriver,timeoutInSeconds);
   }
}
