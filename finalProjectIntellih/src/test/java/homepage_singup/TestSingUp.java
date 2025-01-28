package homepage_singup;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSingUp extends BaseSteps {
    @Test
    public void checkSingUp()  {
        singUp.clickOnSingUpButton_home();

        String baseUserName = "Ali";
        String basePassword = "AliPass";
        String newUserName = singUp.UserName(baseUserName);
        String newPassword = singUp.Password(basePassword);

        singUp.insertUserName(newUserName);
        singUp.insertPassword(newPassword);
        singUp.clickOnSingUp();

        String actualResult= singUp.successMessage();
        singUp.alertHandel();
        String expectedResult="Sign up successful.";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

}
