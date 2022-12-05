package doreen.testng.BT4;

import doreen.testng.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AddProduct extends BaseTest {
    Locators locators = new Locators();
    SoftAssert assertSoft = new SoftAssert();
    String categoryName = "Doreen Watch";
    String categoryNameEdit = "Doreen Watch Edit";
    String productName = "Romantic Vibes";
    int countColor = 2;
    String productColor1 = "AntiqueWhite";
    String productColor2 = "DarkBlue";

    @BeforeClass
    public void loginEMS() {
        openURL("https://demo.activeitzone.com/ecommerce/login");
        assertSoft.assertEquals(driver.getTitle(), "Active eCommerce | Demo of Active eCommerce CMS", "Sai tiêu đề trang đăng nhập");
        assertSoft.assertTrue(driver.findElement(By.xpath(locators.loginDialog)).isDisplayed());
        assertSoft.assertEquals(getText(locators.loginDialog), "Welcome to Active eCommerce CMS", "Tiêu đề của khung Login không phải là 'Welcome to Active eCommerce CMS'");
        click(locators.copyBtn);
        click(locators.loginBtn);
        sleep(1);
        assertSoft.assertAll();
    }

    @Test(priority = 2)
    public void addCategory() {
        assertSoft.assertEquals(getText(locators.activeMenu), "Dashboard"); //kt trang hiện tại à trang Dashboard

        click(locators.productsMenu);
        click(locators.categoryMenu);
        assertSoft.assertEquals(getText(locators.activeMenu), "Category");
        sleep(2);
        assertSoft.assertTrue(driver.findElement(By.xpath(locators.pageHeader)).isDisplayed(), "Page header không hiển thị");
        assertSoft.assertEquals(getText(locators.pageHeader), "All Categories");
        click(locators.addCategoryBtn);
        sleep(0.5);

        assertSoft.assertEquals(getText(locators.cardHeader), "Category Information");
        input(locators.nameCategory, categoryName);

        click(locators.parentCategory);
        input(locators.parentCategorySearch, "Women watch");
        driver.findElement(By.xpath(locators.parentCategorySearch)).sendKeys(Keys.ENTER);

        input(locators.orderingCategory, "1");

        Select type = new Select(driver.findElement(By.xpath(locators.typeCategory)));
        type.selectByIndex(1);

        click(locators.bannerBrowserBtn);
        sleep(1);
        assertSoft.assertTrue(driver.findElement(By.xpath(locators.addFileModelBtn)).isEnabled(), "Nút Add Files không cho phép bấm");
        driver.findElement(By.xpath(locators.selectModelSearch)).sendKeys("flash deal 1", Keys.ENTER);
        sleep(5);
        click(locators.uploadSelectedImage);
        click(locators.addFileModelBtn);
        sleep(1);

        click(locators.iconBrowserBtn);
        sleep(1);
        assertSoft.assertTrue(driver.findElement(By.xpath(locators.addFileModelBtn)).isEnabled(), "Nút Add Files không cho phép bấm");
        driver.findElement(By.xpath(locators.selectModelSearch)).sendKeys("flash deal 1", Keys.ENTER);
        sleep(5);
        click(locators.uploadSelectedImage);
        click(locators.addFileModelBtn);

        input(locators.metaTitle, "New brand watch made by Doreen");

        input(locators.metaDescription, "Affordable price watches for loved women in your life");

        click(locators.filtering);
        input(locators.filteringSearch, "Size");
        driver.findElement(By.xpath(locators.filteringSearch)).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.xpath(locators.saveBtn)).isDisplayed(), "Nút Save không được hiển thị");
        Assert.assertTrue(driver.findElement(By.xpath(locators.saveBtn)).isEnabled(), "Nút Save cho phép bấm");
        click(locators.saveBtn);

        sleep(3);
        assertSoft.assertEquals(getText(locators.pageHeader), "All Categories");
        driver.findElement(By.xpath(locators.searchField)).sendKeys(categoryName, Keys.ENTER);
        sleep(5);

        ArrayList<WebElement> searchResults = (ArrayList<WebElement>) driver.findElements(By.xpath(locators.resultList));
        Assert.assertEquals(searchResults.get(0).getText(), categoryName, "Không tìm thấy category vừa tạo");
        assertSoft.assertAll();
    }

    @Test(priority = 1)
    public void addProduct() throws AWTException {
        // addCategory();
        Actions action = new Actions(driver);
        Robot robot = new Robot();
        click(locators.productsMenu);
        click(locators.addNewProductMenu);
        sleep(1);
        assertSoft.assertEquals(getText(locators.cardHeader), "Add New product");

        //input product name
        input(locators.productName, productName);

        //input category
        click(locators.productCategory);
        action.sendKeys(categoryName).sendKeys(Keys.ENTER).build().perform();
        //  action.sendKeys(findElementXpath(locators.parentCategorySearch),categoryName).sendKeys(Keys.ENTER).build().perform(); //use Actions
        sleep(0.3);

        //input unit
        input(locators.productUnit, "pc");

        //input tags
        click(locators.productTags);
        //action.sendKeys(findElementXpath(locators.productTags), "watch").sendKeys(Keys.ENTER).build().perform();//use Actions
        action.sendKeys(findElementXpath(locators.productTags), "watch").sendKeys(Keys.ENTER).build().perform();//use Actions

        //input Colors
        action.click(findElementXpath(locators.productColorToggle)).build().perform();  //turn on Colors toggle
        action.click(findElementXpath(locators.productColor)).build().perform();
        action.click(findElementXpath(locators.productColorSearch)).build().perform();
        action.sendKeys(productColor1).sendKeys(Keys.ENTER).build().perform(); //color 1
        action.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).build().perform(); // Ctrl A + Delete
        /*action.keyDown(Keys.COMMAND).build().perform();
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        action.keyUp(Keys.COMMAND).build().perform();*/
        findElementXpath(locators.productColorSearch).sendKeys(Keys.DELETE);
        action.sendKeys(productColor2).sendKeys(Keys.ENTER).build().perform(); //color 2

        //input unitPrice
        action.click(findElementXpath(locators.productUnitPrice)).build().perform();
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).sendKeys("1200").build().perform();

        //kiểm tra số lượng màu đã add
        List<WebElement> list = driver.findElements(By.xpath(locators.productSelectedColor));
        Assert.assertEquals(list.size(), countColor, "Không hiển thị đủ số lượng màu đã chọn");

        //click Save&Published btn
        action.click(findElementXpath(locators.savePublishBtn)).build().perform();
        sleep(3);

        // tìm product vừa tạo
        assertSoft.assertEquals(getText(locators.pageHeader), "All Products");
        action.sendKeys(findElementXpath(locators.searchField), productName).sendKeys(Keys.ENTER).build().perform();
        sleep(1);
        ArrayList<WebElement> searchResults = (ArrayList<WebElement>) driver.findElements(By.xpath(locators.resultList));
        Assert.assertEquals(searchResults.get(0).getText(), productName, "Không tìm thấy product vừa tạo");

        assertSoft.assertAll();
    }


    /*@Test(priority = 2)
    public void editCategory() {
        click(category.productsMenu);
        click(category.categoryMenu);
        assertSoft.assertEquals(getText(category.activeMenu), "Category");
        sleep(1);
        assertSoft.assertTrue(driver.findElement(By.xpath(category.pageHeader)).isDisplayed(), "Page header không hiển thị");
        assertSoft.assertEquals(getText(category.pageHeader), "All Categories");

        driver.findElement(By.xpath(category.categoriesSearchField)).sendKeys(categoryName, Keys.ENTER);
        sleep(5);

        ArrayList<WebElement> searchResults = (ArrayList<WebElement>) driver.findElements(By.xpath(category.categoryResultList));
        Assert.assertEquals(searchResults.get(0).getText(), categoryName, "Không tìm thấy category cần tìm");
        Assert.assertTrue(driver.findElement(By.xpath(category.editCategoryBtn)).isEnabled(), "Nút Edit không cho phép bấm");
        click(category.editCategoryBtn);
        sleep(1);

        assertSoft.assertEquals(getText(category.cardHeader), "Category Information");
        driver.findElement(By.xpath(category.nameCategory)).clear();
        sleep(3);
        input(category.nameCategory, categoryNameEdit);
        Assert.assertTrue(driver.findElement(By.xpath(category.saveBtn)).isDisplayed(), "Nút Save không được hiển thị");
        Assert.assertTrue(driver.findElement(By.xpath(category.saveBtn)).isEnabled(), "Nút Save cho phép bấm");
        click(category.saveBtn);

        sleep(1);
        click(category.categoryMenu);
        sleep(1);
        assertSoft.assertEquals(getText(category.pageHeader), "All Categories");
        driver.findElement(By.xpath(category.categoriesSearchField)).sendKeys(categoryNameEdit, Keys.ENTER);
        sleep(3);
        Assert.assertEquals(getText(category.category1stResult), categoryNameEdit, "Không tìm thấy category vừa sửa");

        assertSoft.assertAll();
    }

    @Test(priority = 3)
    public void deleteCategory() {
        click(category.productsMenu);
        click(category.categoryMenu);
        assertSoft.assertEquals(getText(category.activeMenu), "Category");
        sleep(1);
        assertSoft.assertTrue(driver.findElement(By.xpath(category.pageHeader)).isDisplayed(), "Page header không hiển thị");
        assertSoft.assertEquals(getText(category.pageHeader), "All Categories");

        driver.findElement(By.xpath(category.categoriesSearchField)).sendKeys(categoryNameEdit, Keys.ENTER);
        sleep(3);

        Assert.assertEquals(getText(category.category1stResult), categoryNameEdit, "Không tìm thấy category cần xóa");

        Assert.assertTrue(driver.findElement(By.xpath(category.deleteCategoryBtn)).isEnabled(), "Nút Delete không cho phép bấm");
        click(category.deleteCategoryBtn);
        sleep(1);
        assertSoft.assertEquals(getText(category.deleteModalHeader), "Delete Confirmation");

        Assert.assertTrue(driver.findElement(By.xpath(category.deleteBtn)).isDisplayed(), "Nút Delete không được hiển thị");
        Assert.assertTrue(driver.findElement(By.xpath(category.deleteBtn)).isEnabled(), "Nút Delete cho phép bấm");
        click(category.deleteBtn);

        sleep(5);

        assertSoft.assertEquals(getText(category.pageHeader), "All Categories");
        driver.findElement(By.xpath(category.categoriesSearchField)).sendKeys(categoryNameEdit, Keys.ENTER);
        sleep(3);

        Assert.assertTrue(driver.findElement(By.xpath(category.nothingFound)).isDisplayed());

        assertSoft.assertAll();
    }*/
}
