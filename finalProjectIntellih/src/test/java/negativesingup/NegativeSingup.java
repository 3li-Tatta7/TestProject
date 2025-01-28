package negativesingup;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeSingup extends BaseSteps {
    @Test
    public void negativSingup(){
        singUpwithexist.clickOnSingUpButton_home();

        singUp.insertUserName("alifathi");
        singUp.insertPassword("123456789");
        singUp.clickOnSingUp();

        String actualResult= singUp.successMessage();
        singUp.alertHandel();
        String expectedResult="This user already exist.";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}