package pageobjects;

import baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Jatin on 9/29/2018.
 */
public class AddContactPage extends BasePage {

    By targetAccountDropDown=resourceId("accountSpinner");
    By targetAccountDropDownText=xpathWithResourceId("text1");
    By contactName=resourceId("contactNameEditText");
    By contactPhone=resourceId("contactPhoneEditText");
    By contactEmail=resourceId("contactEmailEditText");
    By saveButton=resourceId("contactSaveButton");

    public AddContactPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public HomePage addContact(String targetAccount, String name, int phone, String email){
        if(!(getElementText(targetAccountDropDownText).contains(targetAccount))) {
            clickElement(find(targetAccountDropDown));
            clickElement(find(xpathWithText(targetAccount)));
        }
        enterText(find(contactName),name);
        enterText(find(contactPhone),String.valueOf(phone));
        enterText(find(contactEmail),email);
        clickElement(find(saveButton));
      return  new HomePage(appiumDriver);
    }

}
