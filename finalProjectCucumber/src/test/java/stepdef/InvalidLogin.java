package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

public class InvalidLogin {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = Hooks.getWait();
    LoginPage loginPage = new LoginPage(driver, wait);
    @Given("User open homepage and click on Login button")
    public void user_open_homepage_and_click_on_login_button() {
        loginPage.clickOnLoginButtonHome();
    }

    @When("User logs in with invalid {string} and {string}")
    public void user_logs_in_with_invalid_and(String username, String password) {
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLogin();
    }

    @Then("User should see an {string} alert")
    public void user_should_see_an_alert(String alertMessage) {
        String actualMessage = loginPage.alertText();
        Assert.assertTrue(actualMessage.contains(alertMessage));
        loginPage.alert_handel();
    }


}
