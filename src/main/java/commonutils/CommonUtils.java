package commonutils;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Jatin on 9/29/2018.
 */
public class CommonUtils {

    public static String getCentralData(String name)  {
      String  filePath="src/test/resources/CentralData.properties";
       return getProperty(filePath,name);
    }

    public static String getProperty(String filePath, String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;
        String value=null;
        try {
            input = new FileInputStream(filePath);
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            value= prop.getProperty(propertyName);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    Assert.fail(e.getMessage());
                }
            }
        }
        return value;
    }
}
