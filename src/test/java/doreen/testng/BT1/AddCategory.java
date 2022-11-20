package doreen.testng.BT1;

import doreen.testng.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AddCategory extends BaseTest {
    CategoryLocators category = new CategoryLocators();

    @BeforeClass
    public void loginEMS() {
        openURL("https://demo.activeitzone.com/ecommerce/login");
        click(category.copyBtn);
        click(category.loginBtn);
        sleep(1);
    }

    @Test(priority = 1)
    public void addCategory() {
        String categoryName = "Doreen Watch";
        click(category.productsMenu);
        click(category.categoryMenu);
        sleep(1);
        click(category.addCategoryBtn);
        sleep(0.5);

        input(category.nameCategory, categoryName);

        click(category.parentCategory);
        input(category.parentCategorySearch, "Women watch");
        driver.findElement(By.xpath(category.parentCategorySearch)).sendKeys(Keys.ENTER);

        input(category.orderingCategory, "1");

        Select type = new Select(driver.findElement(By.xpath(category.typeCategory)));
        type.selectByIndex(1);

        click(category.bannerBrowserBtn);
        sleep(1);
        driver.findElement(By.xpath(category.selectModelSearch)).sendKeys("restaurant-icon", Keys.ENTER);
        sleep(5);
        click(category.uploadSelectedImage);
        click(category.addFileModelBtn);

        click(category.iconBrowserBtn);
        sleep(1);
        driver.findElement(By.xpath(category.selectModelSearch)).sendKeys("restaurant-icon", Keys.ENTER);
        sleep(5);
        click(category.uploadSelectedImage);
        click(category.addFileModelBtn);

        input(category.metaTitle, "New brand watch made by Doreen");

        input(category.metaDescription, "Affordable price watches for loved women in your life");

        click(category.filtering);
        input(category.filteringSearch, "Size");
        driver.findElement(By.xpath(category.filteringSearch)).sendKeys(Keys.ENTER);

        click(category.saveBtn);

        sleep(3);
        driver.findElement(By.xpath(category.categoriesSearchField)).sendKeys(categoryName, Keys.ENTER);
        sleep(5);


        ArrayList<WebElement> searchResults = (ArrayList<WebElement>) driver.findElements(By.xpath(category.categoryResultList));
        if (searchResults.get(0).getText().equalsIgnoreCase(categoryName)) {
            System.out.println("Tạo category thành công");
        } else {
            System.out.println("Thất bại, thử lại nhé");
        }
    }
}
