package doreen.POM.pages;

import doreen.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    //1. Data trong nội bộ trang
    private String url = "https://cms.anhtester.com/admin";

    //2. Objects
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By menuAddProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");

    private WebDriver driver;

    //3. Hàm xây dựng
    public DashboardPage(WebDriver _driver) {
        driver = _driver;
    }

    //4. các hàm
    public void verifyDashboardPage() {
        Assert.assertEquals(driver.getCurrentUrl(), url, "FAILED. Current page is not Dashboard page");
    }

/*
    public void getConvertedLeadTotal() {
        System.out.println(driver.findElement(textConvertedLead).getText());
    }
*/

    public void openCustomerPage() {
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuCustomer).click();
    }

    public void openProductPage() {
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuProduct).click();
    }
    public void openAddNewProductPage() {
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuAddProduct).click();
    }




    /*public void verifyFilterStatistics(){
        //kiểm tra widget này đang hiển thị (visible)
        Assert.assertTrue(WebUI.verifyElementVisible(driver, widgetStatistics,5),"Widget Statistics should be visible as default");

        // nhấn uncheck widget
        clickCheckboxQuickStatistics();

        //kiểm tra widget đã bị ẩn (not visible)
        Assert.assertTrue(WebUI.verifyElementNOTVisible(driver, widgetStatistics,5),"Widget Statistics should be invisible");

    }*/
}
