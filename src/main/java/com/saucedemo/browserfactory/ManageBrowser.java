package com.saucedemo.browserfactory;


import com.saucedemo.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Created by Mahak
 * 1.) I have created a manager browser class where -
 * Logger: This is the class provided by the Log4j library for logging purposes.
 * log: This is the name given to the logger variable.
 * LogManager.getLogger(className.class.getName()): This is the initialization part of the logger.
 * It retrieves a logger instance associated with the class
 * 1.)In This manage browser class in browser factory package, I am declaring the reference variable driver for Webdriver interface.
 * 2.) Then I am calling properties from config.properties file such as baseurl and implicit wait
 * 3.) Then I am creating the constructor and initialising the webElements (Page Factory Model) and configuring the path for log4j and passing the
 * path for log4j properties.
 * 4.) Then I am creating selectBrowser method using if else condition to select the browser, with it I am using maximise method to maximise the window
 * post launching browser.
 * 5.) Then I am setting the implicitly wait for all the webElements.
 * 6.) After that setting the baseUrl using driver variable.
 * 7.) Then finally I am creating closeBrowser method to close all the browsers using quit method.
 */

public class ManageBrowser {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    static int implicitlyWait = Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait"));

    public ManageBrowser() {
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);
    }

    public void closeBrowser(){
        if (driver!= null){
            driver.quit();
        }
    }
}
