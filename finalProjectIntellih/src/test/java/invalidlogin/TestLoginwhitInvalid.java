package invalidlogin;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginwhitInvalid extends BaseSteps {
    @Test
    public void loginWithInvalid(){
        loginPage.clickOnLoginButtonHome();
        loginPage.insertUsername("aaaaaaaaaaaa");
        loginPage.insertPassword("aaaaaaaaaaaaa");
        loginPage.clickOnLogin();
        String actualResult =loginPage.alertText();
        String expectedResult="Wrong password.";
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage.alert_handel();
    }
}
