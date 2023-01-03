package doreen.POM.pages;


import doreen.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class AddNewProductPage {
    SoftAssert assertSoft = new SoftAssert();
    private String url = "https://cms.anhtester.com/admin/products/create";
    private String pageText = "Add New Product";


    //----Lưu Object của trang Login
    private By headerPage = By.xpath("//div[@class='aiz-main-content']//div[starts-with(@class,'aiz-titlebar')]//h5");
    private By productName = By.xpath("//input[@placeholder='Product Name']");
    private By productCategory = By.xpath("//div[@id='category']//button[@data-id='category_id']");
    private By productCategorySearch = By.xpath("//div[@id='category']//div[@class='bs-searchbox']/input");
    private By productUnit = By.xpath("//input[@name='unit']");
    private By productTags = By.xpath("//label[normalize-space()='Tags *']/span");
    private By productColorToggle = By.xpath("//h5[normalize-space()='Product Variation']/parent::div//following-sibling::div[@class='card-body']//div[@class='col-md-1']//span");
    private By productColor = By.xpath("//button[@data-id='colors']");
    private By productColorSearch = By.xpath("//select[@id='colors']/following-sibling::div[@class='dropdown-menu show']/div[@class='bs-searchbox']/input");
    private By productUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By productQuantity = By.xpath("//input[@placeholder='Quantity']");
    private By productSelectedColor = By.xpath("//div[@id='sku_combination']//tbody/tr/td/label");
    private By savePublishBtn = By.xpath("//button[normalize-space()='Save & Publish']");

    //---hàm xây dựng để truyền vào driver
    private WebDriver driver;

    public AddNewProductPage(WebDriver _driver) {
        driver = _driver;
    }

    //----Các hàm xử lý cho trang Login
    public void verifyHeaderPage() {
        Assert.assertEquals(driver.findElement(headerPage).getText(), pageText, "FAILED. Header is not " + pageText);
    }

    public void inputProductName(String name) {
        Assert.assertTrue(driver.findElement(productName).isDisplayed(), "FAILED. Product Name field is not displayed");
        driver.findElement(productName).sendKeys(name);
    }

    public void inputProductCategory(String category) {
        Actions action = new Actions(driver);
        Assert.assertTrue(driver.findElement(productCategory).isDisplayed(), "FAILED. Product Category field is not displayed");
        driver.findElement(productCategory).click();
        action.sendKeys(category).sendKeys(Keys.ENTER).build().perform();
        WebUI.sleep(0.3);
    }

    public void inputProductUnit(String unit) {
        Assert.assertTrue(driver.findElement(productUnit).isDisplayed(), "FAILED. Product Unit field is not displayed");
        driver.findElement(productUnit).sendKeys(unit);
    }

    public void inputProductTag(String tag) {
        Actions action = new Actions(driver);
        Assert.assertTrue(driver.findElement(productTags).isDisplayed(), "FAILED. Product Tag field is not displayed");
        driver.findElement(productTags).click();
        action.sendKeys(driver.findElement(productTags),tag).sendKeys(Keys.ENTER).build().perform();
    }
    public void inputProductColor(String color1, String color2) {
        Actions action = new Actions(driver);
        Assert.assertTrue(driver.findElement(productColorToggle).isDisplayed(), "FAILED. Product Color Toggle field is not displayed");
        driver.findElement(productColorToggle).click();
        driver.findElement(productColor).click();
        driver.findElement(productColorSearch).click();
        action.sendKeys(color1).sendKeys(Keys.ENTER).build().perform();
        action.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).build().perform();
        driver.findElement(productColorSearch).sendKeys(Keys.DELETE);
        action.sendKeys(color2).sendKeys(Keys.ENTER).build().perform();
        WebUI.sleep(5);
    }

    public void verifyCountAddedColor(int countColor) {
        List<WebElement> list = driver.findElements(productSelectedColor);
        Assert.assertEquals(list.size(), countColor, "FAILED. Không hiển thị đủ số lượng màu đã chọn");
    }
    public void inputProductUnitPrice(String price) {
        Actions action = new Actions(driver);
        //Assert.assertTrue(driver.findElement(productUnitPrice).isDisplayed(), "FAILED. Product Unit Price field is not displayed");
        driver.findElement(productUnitPrice).click();
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).sendKeys(price).build().perform();
    }

    public void inputProductQuantity(String quantity) {
        Actions action = new Actions(driver);
        Assert.assertTrue(driver.findElement(productQuantity).isDisplayed(), "FAILED. Product Unit Quantity field is not displayed");
        driver.findElement(productQuantity).click();
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).sendKeys(quantity).build().perform();
    }

    public void clickSavePublishBtn() {
        Assert.assertTrue(driver.findElement(savePublishBtn).isDisplayed(), "FALIED. Save & Publish button is not displayed");
        Assert.assertTrue(driver.findElement(savePublishBtn).isEnabled(), "FALIED. Save & Publish button is not enabled");
        driver.findElement(savePublishBtn).click();
        WebUI.sleep(3);
    }


}

