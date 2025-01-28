package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SingUpwithexist;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SingUp;

import java.time.Duration;

public class BaseSteps {
    public WebDriver driver;
    public WebDriverWait wait;
    public SingUp singUp;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public SingUpwithexist singUpwithexist;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        openhome();
        singUp =new SingUp(driver,wait);
        loginPage = new LoginPage(driver,wait);
        productPage =new ProductPage(driver,wait);
        cartPage =new CartPage(driver,wait);
        singUpwithexist =new SingUpwithexist(driver,wait);

    }

    @BeforeMethod
    public void openhome(){
        driver.get("https://demoblaze.com/");
    }
    @AfterClass
    public void exit(){
        driver.quit();
    }
}
