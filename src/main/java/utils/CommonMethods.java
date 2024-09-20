package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static String readPropertiesFile(String key) {
        // Code to read properties file
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("C:\\Users\\rahul.chaudhary\\RahulAutomation\\BDDFramework\\src\\test\\resources\\Config\\config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
