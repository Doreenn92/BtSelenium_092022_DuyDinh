package doreen.com.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Base {
    public static WebDriver driver;

    public static void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quitBrowser() {
        driver.quit();
    }

    public static void openURL(String url) {
        driver.get(url);
    }

    public static void input(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public static void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void sleep(double seconds){
        try{
            Thread.sleep((long) (seconds*1000));
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
