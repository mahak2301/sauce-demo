package com.saucedemo.steps;

import com.saucedemo.pages.HighestPrice;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HighestPriceSteps {
    @Given("User is on the SauceDemo website {string}")
    public void userIsOnTheSauceDemoWebsite(String arg0) {
        new HighestPrice().getTheCurrentUrl();
    }

    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        new HighestPrice().enterUsernameAndPassword(username,password);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() throws InterruptedException {
        new HighestPrice().clickOnLoginButton();
    }

    @Then("User navigates to {string}")
    public void userNavigatesTo(String arg0) {
        String expected = "https://www.saucedemo.com/inventory.html";
        String actual = new HighestPrice().getTheCurrentUrl();
        Assert.assertEquals(actual, expected,"User is not on inventory page");

    }

    @Then("User selects the highest priced item and adds to cart")
    public void userSelectsTheHighestPricedItemAndAddsToCart() {
        new HighestPrice().allElementsPrices();
    }
}
