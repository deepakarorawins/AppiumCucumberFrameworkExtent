package com.deesite.stepdefinitions;

import com.deesite.pages.LoginPage;
import com.deesite.pages.ProductDetailsPage;
import com.deesite.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;

public class ProductStepDefinitions {
    @Given("I'm logged in")
    public void iMLoggedIn() throws InterruptedException {
        new LoginPage().login("standard_user", "secret_sauce");
    }

    @Then("The product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String title, String price) throws Exception {
        Boolean titleCheck = new ProductsPage().getProductTitle(title).equalsIgnoreCase(title);
        Boolean priceCheck = new ProductsPage().getProductPrice(title, price).equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", priceCheck = " + priceCheck, titleCheck & priceCheck);
    }

    @When("I click product title {string}")
    public void iClickProductTitle(String title) throws Exception {
        new ProductsPage().pressProductTitle(title);
    }


    @Then("I should be on product details page with title {string}, price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String desc) throws Exception {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(title);
        Boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(price);
        Boolean descriptionCheck = productDetailsPage.getDesc().equalsIgnoreCase(desc);
        Assert.assertTrue("titleChek = " + titleCheck + ", priceCheck = " + price + ", descriptionCheck = " + descriptionCheck, titleCheck & priceCheck);
    }
}



