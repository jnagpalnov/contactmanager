package pageobjects;

import baseclasses.BasePage;
import driversetup.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Jatin on 9/29/2018.
 */
public class HomePage extends BasePage {

    By title=By.id("android:id/title");
    By addContacts=xpathWithResourceId("addContactButton");
    By invisibleContactsCheckbox=By.xpath("//*[contains(@resource-id,'showInvisible')]");
    By contacts=xpathWithResourceId("contactEntryText");

    public HomePage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    /**
     * @param contactName search contact by contact name in both first page and invisible contacts,
     *                    perform swipe down till the contact not found
     * @return current page instance
     */
    public HomePage verifyContactPresent(String contactName){
        By contact=By.xpath("//*[contains(@resource-id,'contactEntryText') and contains(@text,'"+ contactName+"')]");
        if(swipeDownToElement(contact,5)==null){
            clickElement(find(invisibleContactsCheckbox));
        }
        Assert.assertNotNull(swipeDownToElement(contact,5));
        clickElement(find(invisibleContactsCheckbox));
        return this;
    }

    /**
     * Method for Clicking "Add Contact" Button
     * @return current page instance
     */
    public AddContactPage clickAddContact(){
      clickElement(find(addContacts));
      return new AddContactPage(appiumDriver);
    }

    /**
     * Method for Clicking "Show Invisible Contact" Checkbox
     * @return current page instance
     */
    public HomePage checkShowInvisibleContactsCheckBox(){
        clickElement(find(invisibleContactsCheckbox));
        return this;
    }

    /**
     * Method for verifying title
     * @return current instance
     */
    public HomePage verifyTittle(String title){
        Assert.assertEquals(getElementText(this.title),title);
        return this;
    }

    /**
     * Method for verifying Add Contact button visibility
     * @return current instance
     */
    public HomePage verifyAddContactButtonPresent(){
        Assert.assertTrue(isElementPresent(addContacts),"Add contacts button is not present");
        return this;
    }

    /**
     * Method for verifying Add Contact button visibility
     * @return current instance
     */
    public HomePage verifyShowInvisibleContactsChecBoxPresent(){
        Assert.assertTrue(isElementPresent(invisibleContactsCheckbox));
        return this;
    }

    /**
     * Method for verifying Add Contact button visibility
     * @param show invisible contacts text
     * @return current instance
     */
    public HomePage verifyShowInvisibleContactsText(String text){
        Assert.assertTrue(getElementText(invisibleContactsCheckbox).equals(text),"Text '"+"' is not equal to:" +getElementText(invisibleContactsCheckbox)) ;
        return this;
    }

    /**
     * @param expectedMinimumContactsCount
     * @return current instance
     */
    public HomePage verifyContactsPresent(int expectedMinimumContactsCount){
       Assert.assertTrue(findElements(contacts).size()>=expectedMinimumContactsCount,"Less than " +expectedMinimumContactsCount+ " contacts are present");
       return this;
    }
}
