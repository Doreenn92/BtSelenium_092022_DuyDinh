package doreen.com.BT_WebElement_Webdriver.Locators;

public class ProjectLocators {
    //xpath
    public String email = "//input[@id='iusername']";
    public String password = "//input[@type='password']";
    public String loginBtn = "//button[@class='btn btn-primary mt-2 ladda-button']";
    public String projectMenu = "//ul[@class='pc-navbar']//li//span[normalize-space()='Projects']";
    public String addProjectBtn = "//a[normalize-space()='Add Project']";
    public String pjTitle = "//div[@class='card-body']//input[@placeholder='Title']";
    public String pjClientSelection = "//div[@class='card-body']//span[@class='selection']//span[text()='Client']";
    public String pjClientOption = "//span[@class='select2-results']/ul/li[1]";
    public String pjEstHour = "//div[@class='card-body']//input[@name='budget_hours']";
    public String pjPriority = "//div[@class='card-body']//span[@class='selection']//span[text()='Highest']";
    public String pjPriorityOption = "//span[@class='select2-results']/ul/li[2]";
    public String pjStartDateField = "//div[@class='card-body']//input[@placeholder='Start Date']";
    public String pjStartDate = "//div[@class='dtp animated fadeIn']//div[@class='dtp-picker']//table/tbody//td/a[@class='dtp-select-day selected']";
    public String pjEndDateField = "//div[@class='card-body']//input[@placeholder='End Date']";
    public String pjNextMonthBtn = "//div[@class='dtp animated fadeIn']//div[@class='dtp-date']//div//a[@class='dtp-select-month-after']";
    public String pjEndDate = "//div[@class='dtp animated fadeIn']//div[@class='dtp-picker']//table/tbody//td/a[@class='dtp-select-day selected']";
    public String pjOkBtn = "//div[@class='dtp animated fadeIn']//button[text()='OK']";
    public String pjSummary = "//div[@class='card-body']//textarea[@placeholder='Summary']";
    public String pjTeamSelection = "//div[@class='card-body']//div[@id='employee_ajax']//span[@class='selection']";
    public String pjTeamOption = "//span[@class='select2-results']/ul[@class='select2-results__options']/li[1]";
    public String pjDescription = "//body";
    public String saveBtn = "//button[normalize-space()='Save']";
}
