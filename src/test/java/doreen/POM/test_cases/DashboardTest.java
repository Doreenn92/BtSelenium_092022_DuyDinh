package doreen.POM.test_cases;

import doreen.POM.common.BaseTest;
import doreen.POM.pages.CustomerPage;
import doreen.POM.pages.DashboardPage;
import doreen.POM.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    CustomerPage customerPage;

    @Test
    public void testTotalOnDashBoard(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.login("admin@example.com","123456");
       // dashboardPage.getConvertedLeadTotal();

    }

    @Test
    public void testOpenCustomerPage(){
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        dashboardPage.openCustomerPage();

        customerPage = new CustomerPage(driver);
        customerPage.verifyCustomerPage();
    }

    @Test
    public void testHideStaticWidget(){
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
       // dashboardPage.verifyFilterStatistics();
    }
}
