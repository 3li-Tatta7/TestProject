package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;

public class Scenario2 {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = Hooks.getWait();
    LoginPage loginPage = new LoginPage(driver, wait);
    ProductPage productPage = new ProductPage(driver, wait);
    CartPage cartPage = new CartPage(driver, wait);


    @Given("User opens homepage and logs in with {string} and {string} User sees their username on the homepage")
    public void userOpensHomepageAndLogsIn(String username, String password) throws InterruptedException {
        loginPage.clickOnLoginButtonHome();
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLogin();
        String actualMessage = loginPage.checkText();
        Assert.assertTrue(actualMessage.contains(username));
    }

    @And("User is on the homepage")
    public void userIsOnTheHomepage() {
    }

    @And("User clicks on Laptops category")
    public void userClicksOnLaptopsCategory() {
        productPage.clickOnLaptopsButton();
    }

    @And("User selects Sony Vaio i5")
    public void userSelectsSonyVaioI5() {
        productPage.clickOnSonyVaioi5Button();
    }

    @And("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        productPage.clickOnAddToCartButton();
    }

    @And("User sees a confirmation message")
    public void userSeesAConfirmationMessage() {
        String actualMessage = productPage.checkText();
        productPage.alertHandel();
        Assert.assertTrue(actualMessage.contains("Product added"));
    }

    @And("User clicks on Home button")
    public void userClicksOnHomeButton() {
        productPage.clickOnHomeButton();
    }

    @And("User selects Sony Vaio i7")
    public void userSelectsSonyVaioI7() {
        productPage.clickOnSonyVaioi7Button();
    }

    @When("User clicks on Cart button")
    public void userClicksOnCartButton() {
        cartPage.clickOnCartButton();
    }

    @And("User checks that the products are in the cart")
    public void userCheckThatProductIsInTheCart() throws InterruptedException {
        Thread.sleep(3000);
        String actualResultOfProductOne = cartPage.checkProductOne();
        String expectedResultOfProductOne = "Sony vaio i5";
        Assert.assertTrue(actualResultOfProductOne.contains(expectedResultOfProductOne));
        String actualResultOfProductTwo = cartPage.checkProductTwo();
        String expectedResultOfProductTwo = "Sony vaio i7";
        Assert.assertTrue(actualResultOfProductTwo.contains(expectedResultOfProductTwo));
    }

    @And("User checks the price of each product and the total price")
    public void userCheckThePriceOfEachAndTheTotalPrice() {
        String actualResultOfPriceProductOne = cartPage.checkPriceOfProductOne();
        String expectedResultOfPriceProductOne = "790";
        Assert.assertTrue(actualResultOfPriceProductOne.contains(expectedResultOfPriceProductOne));
        String actualResultOfPriceProductTwo = cartPage.checkPriceOfProductTwo();
        String expectedResultOfPriceProductTwo = "790";
        Assert.assertTrue(actualResultOfPriceProductTwo.contains(expectedResultOfPriceProductTwo));
        String actualResultOfTotal = cartPage.checkTotalPriceOfProducts();
        String expectedResultOTotal = "1580";
        Assert.assertTrue(actualResultOfTotal.contains(expectedResultOTotal));
    }

    @And("User places an order")
    public void userPlacesAnOrder() {
        cartPage.clickOnPalceOrderButton();
    }

    @And("User fills in the order details with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsInOrderDetails(String name, String country, String city, String creditCard, String month, String year) {
        cartPage.insertName(name);
        cartPage.insertCountry(country);
        cartPage.insertCity(city);
        cartPage.insertCreditCard(creditCard);
        cartPage.insertMonth(month);
        cartPage.insertYear(year);
    }

    @And("User clicks on Purchase button")
    public void userClicksOnPurchaseButton() {
        cartPage.clickOnPurchaseButton();
    }

    @Then("User should see a thank you message")
    public void userShouldSeeAThankYouMessage() throws InterruptedException {
        Thread.sleep(3000);
        String actualResultOfTankYouMessage = cartPage.checkThankYouMessage();
        String expectedOfTankYouMessage = "Thank you for your purchase!";
        Assert.assertTrue(actualResultOfTankYouMessage.contains(expectedOfTankYouMessage));
    }

    @And("User verifies the order is completed successfully")
    public void userVerifiesOrderIsCompletedSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        cartPage.clickOnOkButton();
    }
}
