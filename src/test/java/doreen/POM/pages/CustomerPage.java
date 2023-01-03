package doreen.POM.pages;

import doreen.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    //1. Data trong nội bộ trang
    private String url = "https://crm.anhtester.com/admin/clients";
    private String pageText = "Customers";

    //2. Objects
    private By headerPageCustomer = By.xpath("//div[@class='panel-body']//h4[contains(.,'" + pageText + "')]");
    private WebDriver driver;

    //3. Hàm xây dựng
    public CustomerPage(WebDriver _driver) {
        driver = _driver;
    }

    //4. các hàm
    public void verifyCustomerPage() {
        Assert.assertEquals(driver.getCurrentUrl(), url, "FAILED. Current page is not Customer page");
        Assert.assertTrue(WebUI.checkElementExist(driver, headerPageCustomer), "FAILED. Missing Customer header page");
        Assert.assertEquals(driver.findElement(headerPageCustomer).getText(), "Customers Summary", "FAILED. Header page is not Customers Summary");
    }
}
