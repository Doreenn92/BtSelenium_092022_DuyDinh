package doreen.POM.test_cases;

import doreen.POM.common.BaseTest;
import doreen.POM.pages.LoginPage;
import doreen.com.keywords.WebUI;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginTestSuccess(){
        // khởi tạo đối tươn trang login Page
        // truyển driver từ BaseTest
        loginPage = new LoginPage(driver);

        //gọi hàm login từ LoginPage để dùng
        loginPage.login("admin@example.com","123456");
    }

    @Test
    public void loginInvalidEmail(){
        loginPage = new LoginPage(driver);
        loginPage.login("abc@12.o","123456");
        WebUI.sleep(1);
        loginPage.verifyErrorMessage();
    }
}
