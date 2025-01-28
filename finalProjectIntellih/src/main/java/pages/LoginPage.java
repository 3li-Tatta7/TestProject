package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait ;

    }

    //Allocators
    private By loginButton = By.xpath("//*[@id=\"login2\"]");
    private By userNameBox = By.xpath("//*[@id=\"loginusername\"]");
    private By passwordBox = By.xpath("//*[@id=\"loginpassword\"]");
    private By clickLogin = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private By text = By.xpath("//*[@id=\"nameofuser\"]");
    //Actions
    public void clickOnLoginButtonHome(){
        driver.findElement(loginButton).click();
    }
    public void insertUsername(String user){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBox));
        driver.findElement(userNameBox).sendKeys(user);
    }
    public void insertPassword(String pass){
        driver.findElement(passwordBox).sendKeys(pass);
    }
    public void clickOnLogin(){
        driver.findElement(clickLogin).click();
    }
    public String checkText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(text));
        return driver.findElement(text).getText();

    }
    public String alertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
    public void alert_handel(){
        driver.switchTo().alert().accept();
    }
}
