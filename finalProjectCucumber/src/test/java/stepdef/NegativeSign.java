package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.SingUp;

public class NegativeSign {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = Hooks.getWait();
    SingUp singUp = new SingUp(driver, wait);

    @Given("User navigates to the sign-up page")
    public void userNavigatesToSignUpPage() {
        singUp.clickOnSingUpButton_home();
    }

    @When("User enters {string} and {string} and clicks on sign-up")
    public void userEntersCredentialsAndClicksSignUp(String username, String password) {
        singUp.insertUserName(username);
        singUp.insertPassword(password);
        singUp.clickOnSingUp();
    }

    @Then("User should see a {string} message for sign-up")
    public void userShouldSeeMessageForSignUp(String expectedMessage) {
        String actualMessage = singUp.successMessage();
        singUp.alertHandel();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}