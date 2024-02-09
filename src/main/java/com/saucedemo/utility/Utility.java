package com.saucedemo.utility;


import com.saucedemo.browserfactory.ManageBrowser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

/**
 * Created By Mahak
 * I am creating a Utility class which extends with Manage Browser using Inheritance concept for the driver to find locators.
 * By creating this class , I am making the re-usability of the code.
 * All common methods are fixed in the utility Class.
 */

public class Utility extends ManageBrowser {

    /**
     * This method will click on element
     */

    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(str);
    }


    //************************** ScreenShot Methods *********************************************//

    /**
     * Take screenshot in Byte Format
     */
    public static byte[] getScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}











