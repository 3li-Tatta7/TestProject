package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    public ProductPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;

    }
    //Allocators
    private By laptopsButton = By.xpath("//a[@onclick=\"byCat('notebook')\"]\n");
    private By homeButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    private By Sony_Vaio_i5_Button = By.linkText("Sony vaio i5");
    private By Sony_Vaio_i7_Button = By.linkText("Sony vaio i7");
    private By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");

    //Actions
    public void clickOnLaptopsButton(){
        driver.findElement(laptopsButton).click();
    }
    public void clickOnSonyVaioi5Button(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Sony_Vaio_i5_Button));
        driver.findElement(Sony_Vaio_i5_Button).click();
    }
    public void clickOnAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }
    public String checkText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void alertHandel(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    public void clickOnHomeButton(){
        driver.findElement(homeButton).click();
    }
    public void clickOnSonyVaioi7Button(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Sony_Vaio_i7_Button));
        driver.findElement(Sony_Vaio_i7_Button).click();
    }




}
