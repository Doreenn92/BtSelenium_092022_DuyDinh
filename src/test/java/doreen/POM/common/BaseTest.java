package doreen.POM.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public  void createBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với thời gian 10 giây
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));//Chờ đợi ngầm định cho đợi load trang là 30s (gồm JS, CSS,...)
        //driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30)); //chờ đỡi JS chạy xong hết
    }

    @AfterClass
    public void closeDriver(){
        //System.out.println("afterClass parent");
        driver.quit();
    }
}