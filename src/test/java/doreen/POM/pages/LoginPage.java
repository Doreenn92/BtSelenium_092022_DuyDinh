package doreen.POM.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private String url = "https://cms.anhtester.com/login";
    private String pageText = "Welcome to Anh Tester Demo";
    private String invalidEmailPassword = "Invalid login credentials";

    //----Lưu Object của trang Login
    private By headerPage = By.xpath("//h1");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By messageError = By.xpath("//div[@data-notify='container']");

    //---hàm xây dựng để truyền vào driver
    private WebDriver driver;

    public LoginPage(WebDriver _driver) {
        driver = _driver;
    }

    //----Các hàm xử lý cho trang Login
    public void verifyHeaderPage() {
        Assert.assertEquals(driver.findElement(headerPage).getText(), pageText, "FAILED. Header is not " + pageText);
    }

    public void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void verifyErrorMessage() {
        Assert.assertTrue(driver.findElement(messageError).isDisplayed(), "FALIED. Error message is not displayed");
        Assert.assertEquals(driver.findElement(messageError).getText(), invalidEmailPassword, "FAILED. Message is not " + invalidEmailPassword);

    }

    public void login(String email, String password) {
        driver.get(url);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }
}

