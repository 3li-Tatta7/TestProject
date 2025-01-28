package addSameProductTwice;

import base.BaseSteps;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddingSameProductTwice extends BaseSteps {
    @Test
    public void verifyAddingSameProductTwiceUpdatesQuantity() throws InterruptedException {
        loginPage.clickOnLoginButtonHome();
        loginPage.insertUsername("eideid");
        loginPage.insertPassword("011244");
        loginPage.clickOnLogin();

        String actualResult = loginPage.checkText();
        String expectedResult = "Welcome eideid";
        Assert.assertTrue(actualResult.contains(expectedResult));


        productPage.clickOnLaptopsButton();
        productPage.clickOnSonyVaioi5Button();
        productPage.clickOnAddToCartButton();

        String actualResult1 = productPage.checkText();
        productPage.alertHandel();
        String expectedResult1 = "Product added";
        Assert.assertTrue(actualResult1.contains(expectedResult1));

        productPage.clickOnHomeButton();


        productPage.clickOnLaptopsButton();
        productPage.clickOnSonyVaioi5Button();
        productPage.clickOnAddToCartButton();

        String actualResult2 = productPage.checkText();
        productPage.alertHandel();
        String expectedResult2 = "Product added";
        Assert.assertTrue(actualResult2.contains(expectedResult2));


        cartPage.clickOnCartButton();
        Thread.sleep(3000);


        int productaddingnum = driver.findElements(By.xpath("//td[text()='Sony vaio i5']")).size();
        Assert.assertEquals(productaddingnum, 2);

        String actualTotalPrice = cartPage.checkTotalPriceOfProducts();
        String expectedTotalPrice = "1580";
        Assert.assertTrue(actualTotalPrice.contains(expectedTotalPrice));
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
