package doreen.com.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class WebUI {
    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds*1000));
        } catch (InterruptedException e) {}
    }

    public static void waitForElementVisible(WebDriver driver, By by, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClickable(WebDriver driver, By by, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static boolean verifyElementVisible(WebDriver driver, By by, int seconds)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (TimeoutException e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verifyElementNOTVisible(WebDriver driver, By by, int seconds)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        }catch (TimeoutException e){
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean checkElementExist(WebDriver driver, By by) {
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist(WebDriver driver, String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if (listElement.size() > 0) {
            System.out.println("Element " + xpath + " existing.");
            return true;
        } else {
            System.out.println("Element " + xpath + " NOT exist.");
            return false;
        }
    }

    public void openURL(WebDriver driver,String url) {
        driver.get(url);
    }

    public void setText(WebDriver driver,String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void setText(WebDriver driver,By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clickElement(WebDriver driver,String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickElement(WebDriver driver,By by) {
        driver.findElement(by).click();
    }

    public static String getText(WebDriver driver, By by)
    {
        return driver.findElement(by).getText();
    }

    public static String getText(WebDriver driver, String xpath)
    {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public static boolean isEnable(WebDriver driver, By by)
    {
        return driver.findElement(by).isEnabled();
    }

    public static boolean isEnable(WebDriver driver, String xpath)
    {
        return driver.findElement(By.xpath(xpath)).isEnabled();
    }

    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

}
