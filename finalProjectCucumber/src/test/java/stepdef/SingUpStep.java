package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.SingUp;

public class SingUpStep {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = Hooks.getWait();
    SingUp singUp = new SingUp(driver, wait);

    @Given("User open homepage and click on Sing Up button")
    public void user_open_homepage_and_click_on_sing_up_button() {
        singUp.clickOnSingUpButton_home();
    }

    @When("enter a unique {string} and {string} and click on Sign Up confirmation button")
    public void enter_a_unique_user_and_pass_and_click_on_sign_up_confirmation_button(String user,String pass) {

        String newUserName = singUp.UserName(user);
        String newPassword = singUp.Password(pass);

        singUp.insertUserName(newUserName);
        singUp.insertPassword(newPassword);
        singUp.clickOnSingUp();
    }

    @Then("User should see a Sign up message")
    public void user_should_see_a_sign_up_message() {
        String actualResult = singUp.successMessage();
        singUp.alertHandel();
        String expectedResult = "Sign up successful.";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}