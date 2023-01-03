package doreen.POM.pages;

import doreen.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;

public class AllProductPage {
    private String pageText = "All products";

    //----Lưu Object của trang All Product
    private By headerPage = By.xpath("//h1");
    private By searchField = By.xpath("//input[@id='search']");
    private By resultList = By.xpath("//tbody/tr/td[2]");

    //---hàm xây dựng để truyền vào driver
    private WebDriver driver;

    public AllProductPage(WebDriver _driver) {
        driver = _driver;
    }

    //----Các hàm xử lý cho trang All Product
    public void verifyHeaderPage() {
        Assert.assertEquals(driver.findElement(headerPage).getText(), pageText, "FAILED. Header is not " + pageText);
    }

    public void verifyAddProduct(String productName) {
        Actions action = new Actions(driver);
        action.sendKeys(driver.findElement(searchField), productName).sendKeys(Keys.ENTER).build().perform();
        WebUI.sleep(1);
        ArrayList<WebElement> searchResults = (ArrayList<WebElement>) driver.findElements(resultList);
        Assert.assertEquals(searchResults.get(0).getText(), productName, "Không tìm thấy product vừa tạo");
    }
}
