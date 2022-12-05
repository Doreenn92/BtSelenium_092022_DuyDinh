package doreen.testng.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void createBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void input(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getText(String xpath) {
        return (driver.findElement(By.xpath(xpath)).getText());
    }

    public void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean checkElementExist(By by) {
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element existing: " + true);
            return true;
        } else {
            System.out.println("Element existing: " + false);
            return false;
        }
    }

    public WebElement findElementXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
