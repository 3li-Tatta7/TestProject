package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait getWait(){
        return wait;
    }

    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoblaze.com/");
    }
    @After
    public void exit(){
        driver.quit();
    }
}
