package scenario2;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndSenario extends BaseSteps {
    @Test
    public void endToEndSenario() throws InterruptedException {

        loginPage.clickOnLoginButtonHome();
        loginPage.insertUsername("alifathi");
        loginPage.insertPassword("123456789");
        loginPage.clickOnLogin();
        //loginPage.alert_handel();
        String actualResult = loginPage.checkText();
        String expectedResult = "Welcome alifathi";
        Assert.assertTrue(actualResult.contains(expectedResult));
        //Add First Product to Cart
        productPage.clickOnLaptopsButton();
        productPage.clickOnSonyVaioi5Button();
        productPage.clickOnAddToCartButton();
        String actualResult_ = productPage.checkText();
        productPage.alertHandel();
        String expectedResult_ = "Product added";
        Assert.assertTrue(actualResult_.contains(expectedResult_));

        productPage.clickOnHomeButton();


        //Add Second Product to Cart
        productPage.clickOnLaptopsButton();
        productPage.clickOnSonyVaioi7Button();
        productPage.clickOnAddToCartButton();

        String ActualResult =productPage.checkText();
        productPage.alertHandel();
        String expectedResult__ = "Product added";
        Assert.assertTrue(ActualResult.contains(expectedResult__));

        //Check Products
        cartPage.clickOnCartButton();
        Thread.sleep(3000);
        String actualResultOfProductOne = cartPage.checkProductOne();
        String expectedResultOfProductOne = "Sony vaio i5";
        Assert.assertTrue(actualResultOfProductOne.contains(expectedResultOfProductOne));
        String actualResultOfPriceProductOne = cartPage.checkPriceOfProductOne();
        String expectedResultOfPriceProductOne = "790";
        Assert.assertTrue(actualResultOfPriceProductOne.contains(expectedResultOfPriceProductOne));

        String actualResultOfProductTwo = cartPage.checkProductTwo();
        String expectedResultOfProductTwo = "Sony vaio i7";
        Assert.assertTrue(actualResultOfProductTwo.contains(expectedResultOfProductTwo));
        String actualResultOfPriceProductTwo = cartPage.checkPriceOfProductTwo();
        String expectedResultOfPriceProductTwo = "790";
        Assert.assertTrue(actualResultOfPriceProductTwo.contains(expectedResultOfPriceProductTwo));

        String actualResultOfTotal = cartPage.checkTotalPriceOfProducts();
        String expectedResultOTotal = "1580";
        Assert.assertTrue(actualResultOfTotal.contains(expectedResultOTotal));

        //checkOrder
        cartPage.clickOnPalceOrderButton();
        cartPage.insertName("ali");
        cartPage.insertCountry("egy");
        cartPage.insertCity("shar");
        cartPage.insertCreditCard("0111");
        cartPage.insertMonth("2");
        cartPage.insertYear("2022");
        cartPage.clickOnPurchaseButton();
        Thread.sleep(3000);
        String actualResultOfTankYouMessage = cartPage.checkThankYouMessage();
        String expectedOfTankYouMessage = "Thank you for your purchase!";
        Assert.assertTrue(actualResultOfTankYouMessage.contains(expectedOfTankYouMessage));
        cartPage.clickOnOkButton();



    }
}
/*

 */