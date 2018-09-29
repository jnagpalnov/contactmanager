import driversetup.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.util.Random;

/**
 * Created by Jatin on 9/29/2018.
 */
public class ContactManagerTests {
    HomePage homePage;

    @BeforeTest()
    public void setUp() throws Exception {
        homePage=new HomePage(DriverFactory.getInstanceOfDriverFactory().getAppiumDriver());
    }

    @Test(priority = 1)
    public void testHomepageUI(){
        homePage
                .verifyTittle("Contact Manager")
                .verifyAddContactButtonPresent()
                .verifyShowInvisibleContactsChecBoxPresent()
                .verifyContactsPresent(2);
    }

    @Parameters({"showInvisibleContactsText","minimumContactsCount"})
    @Test(priority = 2)
    public void testInvisibleContacts(String showInvisibleContactsText, int minimumContactsCount){
        homePage
                .verifyShowInvisibleContactsChecBoxPresent()
                .verifyShowInvisibleContactsText(showInvisibleContactsText)
                .checkShowInvisibleContactsCheckBox()
                .verifyContactsPresent(minimumContactsCount);
    }

    @Test(priority = 1)
    public void AddContact(){
        Random rand = new Random();
        int num= rand.nextInt(2000);
        String name= "Aa" + num;
        int phone=num;
        String target="gmail";
        String email=name +"@gmail.com";
        homePage
                .clickAddContact()
                .addContact(target,name,phone,email)
                .verifyContactPresent(name);
    }


    @AfterTest()
    public void afterTest(){
        DriverFactory.getInstanceOfDriverFactory().getAppiumDriver().quit();
    }
}
