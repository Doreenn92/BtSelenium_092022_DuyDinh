package doreen.com.BT_Locators;

public class LearningLocators {
    //xpath
    String email = "//input[@id='iusername']";
    String password = "//input[@type='password']";
    String loginBtn = "//button[@class='btn btn-primary mt-2 ladda-button']";
    String projectMenu = "//ul[@class='pc-navbar']//li//span[normalize-space()='Projects']";
    String addProjectBtn = "//a[normalize-space()='Add Project']";
    String pjTitle = "//div[@class='card-body']//input[@placeholder='Title']";
    String pjClientSelection = "//div[@class='card-body']//span[@class='selection']//span[text()='Client']";
    String pjClientOption = "//span[@class='select2-results']/ul/li[1]";
    String pjEstHour = "//div[@class='card-body']//input[@name='budget_hours']";
    String pjPriority = "//div[@class='card-body']//span[@class='selection']//span[text()='Highest']";
    String pjPriorityOption = "//span[@class='select2-results']/ul/li[2]";
    String pjStartDateField = "//div[@class='card-body']//input[@placeholder='Start Date']";
    String pjStartDate = "//div[@class='dtp animated fadeIn']//div[@class='dtp-picker']//table/tbody//td/a[@class='dtp-select-day selected']";
    String pjEndDateField = "//div[@class='card-body']//input[@placeholder='End Date']";
    String pjNextMonthBtn = "//div[@class='dtp animated fadeIn']//div[@class='dtp-date']//div//a[@class='dtp-select-month-after']";
    String pjEndDate = "//div[@class='dtp animated fadeIn']//div[@class='dtp-picker']//table/tbody//td/a[@class='dtp-select-day selected']";
    String pjOkBtn = "//div[@class='dtp animated fadeIn']//button[text()='OK']";
    String pjSummary = "//div[@class='card-body']//textarea[@placeholder='Summary']";
    String pjTeamSelection = "//div[@class='card-body']//div[@id='employee_ajax']//span[@class='selection']";
    String pjTeamOption = "//span[@class='select2-results']/ul[@class='select2-results__options']/li[1]";
    String pjDescription = "//body";
    String saveBtn = "//button[normalize-space()='Save']";
}
