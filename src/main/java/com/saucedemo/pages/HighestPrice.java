package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HighestPrice extends Utility {

    private static final Logger log = LogManager.getLogger(HighestPrice.class.getName());



    // Enter username
    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement enterUsername;

    //Enter password
    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement enterPassword;

    //Click on login button

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//button[@class ='btn btn_primary btn_small btn_inventory ']")
    WebElement clickOnAddToCart;

    public void enterUsernameAndPassword(String username, String password) {
        sendTextToElement(enterUsername, username);
        sendTextToElement(enterPassword, password);
        log.info("Enter username: " + enterUsername.toString());
        log.info("Enter password: " + enterPassword.toString());
    }

    //Getting Current URL
    public String getTheCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Click on login button: " + loginButton.toString());
    }


    public void allElementsPrices() {
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        {
            //This initializes two variables: maximumPrice to 0 (default value for comparison)
            // and highestPriceItemAddedToCartButton to null.
            double maximumPrice = 0;
            WebElement highestPriceItemAddedToCartButton = null;
            for (WebElement priceElement : prices) {
                double price = Double.parseDouble(priceElement.getText().replace("$", ""));
                if (price > maximumPrice) {
                    maximumPrice = price;
                    highestPriceItemAddedToCartButton = priceElement.findElement(By.xpath("./ancestor::div[@class='inventory_item']//button[text()='Add to cart']"));

                }
            }
            highestPriceItemAddedToCartButton.click();
        }
    }
}











