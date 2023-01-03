package doreen.POM.test_cases;

import doreen.POM.common.BaseTest;
import doreen.POM.pages.AddNewProductPage;
import doreen.POM.pages.AllProductPage;
import doreen.POM.pages.DashboardPage;
import doreen.POM.pages.LoginPage;
import org.testng.annotations.Test;

public class AddNewProductTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddNewProductPage addProductPage;
    AllProductPage allProductPage;
    String productName = "Doreen watch";
    @Test
    public void testAddNewProduct(){
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        dashboardPage.openProductPage();
        dashboardPage.openAddNewProductPage();

        addProductPage = new AddNewProductPage(driver);
        addProductPage.verifyHeaderPage();
        addProductPage.inputProductName(productName);
        addProductPage.inputProductCategory("Demo category 1");
        addProductPage.inputProductUnit("pc");
        addProductPage.inputProductTag("watch");
        addProductPage.inputProductUnitPrice("100");
        addProductPage.inputProductQuantity("999");
        addProductPage.clickSavePublishBtn();

        allProductPage = new AllProductPage(driver);
        allProductPage.verifyHeaderPage();
        allProductPage.verifyAddProduct(productName);
    }
}
