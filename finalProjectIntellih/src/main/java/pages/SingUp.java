package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUp {
    WebDriver driver;
    WebDriverWait wait;

    public SingUp(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    private By signUpButton = By.xpath("//*[@id=\"signin2\"]");
    private By userNameBox = By.xpath("//*[@id=\"sign-username\"]");
    private By passwordBox = By.xpath("//*[@id=\"sign-password\"]");
    private By clickSingUp = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    // Actions
    public void clickOnSingUpButton_home() {
        driver.findElement(signUpButton).click();
    }

    public String UserName(String baseUserName) {
        return baseUserName + System.currentTimeMillis();
    }

    public void insertUserName(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBox));
        driver.findElement(userNameBox).sendKeys(user);
    }

    public String Password(String basePassword) {
        return basePassword + System.currentTimeMillis();
    }

    public void insertPassword(String pass) {
        driver.findElement(passwordBox).sendKeys(pass);
    }

    public void clickOnSingUp() {
        driver.findElement(clickSingUp).click();
    }

    public String successMessage() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void alertHandel() {
        driver.switchTo().alert().accept();
    }
}