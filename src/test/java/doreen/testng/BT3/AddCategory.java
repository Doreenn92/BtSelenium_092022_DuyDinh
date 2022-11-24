package doreen.testng.BT3;

import doreen.testng.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class AddCategory extends BaseTest {
    CategoryLocators category = new CategoryLocators();
    SoftAssert assertSoft = new SoftAssert();
    String categoryName = "Doreen Watch";
    String categoryNameEdit = "Doreen Watch Edit";

    @BeforeClass
    public void loginEMS() {
        openURL("https://demo.activeitzone.com/ecommerce/login");
        assertSoft.assertEquals(driver.getTitle(), "Active eCommerce | Demo of Active eCommerce CMS", "Sai tiêu đề trang đăng nhập");
        assertSoft.assertTrue(driver.findElement(By.xpath(category.loginDialog)).isDisplayed());
        assertSoft.assertEquals(getText(category.loginDialog), "Welcome to Active eCommerce CMS", "Tiêu đề của khung Login không phải là 'Welcome to Active eCommerce CMS'");
        click(category.copyBtn);
        click(category.loginBtn);
        sleep(1);
        assertSoft.assertAll();
    }

    @Test(priority = 1)
    public void addCategory() {
        assertSoft.assertEquals(getText(category.activeMenu), "Dashboard"); //kt trang hiện tại à trang Dashboard

        click(category.productsMenu);
        click(category.categoryMenu);
        assertSoft.assertEquals(getText(category.activeMenu), "Category");
        sleep(1);
        assertSoft.assertTrue(driver.findElement(By.xpath(category.pageHeader)).isDisplayed(), "Page header không hiển thị");
        assertSoft.assertEquals(getText(category.pageHeader), "All Categories");
        click(category.addCategoryBtn);
        sleep(0.5);

        assertSoft.assertEquals(getText(category.cardHeader), "Category Information");
        input(category.nameCategory, categoryName);

        click(category.parentCategory);
        input(category.parentCategorySearch, "Women watch");
        driver.findElement(By.xpath(category.parentCategorySearch)).sendKeys(Keys.ENTER);

        input(category.orderingCategory, "1");

        Select type = new Select(driver.findElement(By.xpath(category.typeCategory)));
        type.selectByIndex(1);

        click(category.bannerBrowserBtn);
        sleep(1);
        assertSoft.assertTrue(driver.findElement(By.xpath(category.addFileModelBtn)).isEnabled(), "Nút Add Files không cho phép bấm");
        driver.findElement(By.xpath(category.selectModelSearch)).sendKeys("restaurant-icon", Keys.ENTER);
        sleep(5);
        click(category.uploadSelectedImage);
        click(category.addFileModelBtn);

        click(category.iconBrowserBtn);
        sleep(1);
        assertSoft.assertTrue(driver.findElement(By.xpath(category.addFileModelBtn)).isEnabled(), "Nút Add Files không cho phép bấm");
        driver.findElement(By.xpath(category.selectModelSearch)).sendKeys("restaurant-icon", Keys.ENTER);
        sleep(5);
        click(category.uploadSelectedImage);
        click(category.addFileModelBtn);

        input(category.metaTitle, "New brand watch made by Doreen");

        input(category.metaDescription, "Affordable price watches for loved women in your life");

        click(category.filtering);
        input(category.filteringSearch, "Size");
        driver.findElement(By.xpath(category.filteringSearch)).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.xpath(category.saveBtn)).isDisplayed(), "Nút Save không được hiển thị");
        Assert.assertTrue(driver.findElement(By.xpath(category.saveBtn)).isEnabled(), "Nút Save cho phép bấm");
        click(category.saveBtn);

        sleep(3);
        assertSoft.assertEquals(getText(category.pageHeader), "All Categories");
        driver.findElement(By.xpath(category.categoriesSearchField)).sendKeys(categoryName, Keys.ENTER);
        sleep(5);

        ArrayList<WebElement> searchResults = (ArrayList<WebElement>) driver.findElements(By.xpath(category.categoryResultList));
        Assert.assertEquals(searchResults.get(0).getText(), categoryName, "Không tìm thấy category vừa tạo");
        assertSoft.assertAll();
    }

    @Test(priority = 2)
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
    }
}
