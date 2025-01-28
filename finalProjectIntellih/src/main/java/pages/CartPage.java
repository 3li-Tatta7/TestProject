package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }
    //Allocators
    private By cartButton = By.linkText("Cart");
    private By checkSonyi5 = By.xpath("//td[text()='Sony vaio i5']");
    private By checkSonei7 = By.xpath("//td[normalize-space(text())='Sony vaio i7']");
    private By checkPriceSonyi5 = By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[3]");
    private By checkPriceSonyi7 = By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[3]");
    private By checkTotalPrice = By.xpath("//*[@id=\"totalp\"]");
    private By palceOrdeButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private By Name_Box = By.id("name");
    private By Country_Box = By.id("country");
    private By City_Box = By.id("city");
    private By CreditCard_Box = By.id("card");
    private By Month_Box = By.id("month");
    private By Year_Box = By.id("year");
    private By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private By thanhYouMessage = By.xpath("//h2[text()='Thank you for your purchase!']");
    private By okButton = By.xpath("//button[contains(text(), 'OK')]");

    //Actions
    public void clickOnCartButton(){
        driver.findElement(cartButton).click();
    }
    public String checkProductOne(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkSonyi5));
        return driver.findElement(checkSonyi5).getText();
    }
    public String checkProductTwo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkSonei7));
        return driver.findElement(checkSonei7).getText();
    }
    public String checkPriceOfProductOne(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkPriceSonyi5));
        return driver.findElement(checkPriceSonyi5).getText();
    }
    public String checkPriceOfProductTwo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkPriceSonyi7));
        return driver.findElement(checkPriceSonyi7).getText();
    }
    public String checkTotalPriceOfProducts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkTotalPrice));
        return driver.findElement(checkTotalPrice).getText();
    }
    public void clickOnPalceOrderButton(){
        driver.findElement(palceOrdeButton).click();
    }
    public void insertName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name_Box));
        driver.findElement(Name_Box).sendKeys(name);
    }
    public void insertCountry(String country){
        driver.findElement(Country_Box).sendKeys(country);
    }
    public void insertCity(String city){
        driver.findElement(City_Box).sendKeys(city);
    }
    public void insertCreditCard(String credit){
        driver.findElement(CreditCard_Box).sendKeys(credit);
    }
    public void insertMonth(String month){
        driver.findElement(Month_Box).sendKeys(month);
    }
    public void insertYear(String year){
        driver.findElement(Year_Box).sendKeys(year);
    }
    public void clickOnPurchaseButton(){
        driver.findElement(purchaseButton).click();
    }
    public String checkThankYouMessage(){
        return driver.findElement(thanhYouMessage).getText();
    }
    public void clickOnOkButton(){
        driver.findElement(okButton).click();
    }




}
