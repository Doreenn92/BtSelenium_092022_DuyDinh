package doreen.com.BT_WebElement_Webdriver.Locators;

public class TaskLocators {
    //xpath
    public String email = "//input[@id='iusername']";
    public String password = "//input[@type='password']";
    public String loginBtn = "//button[@class='btn btn-primary mt-2 ladda-button']";
    public String taskMenu = "//ul[@class='pc-navbar']//li//span[normalize-space()='Tasks']";
    public String addTaskBtn = "//a[normalize-space()='Add Task']";
    public String taskTitle = "//div[@class='card-body']//input[@placeholder='Title']";
    public String taskEstHour = "//div[@class='card-body']//input[@name='task_hour']";
    public String taskStartDateField = "//div[@class='card-body']//input[@placeholder='Start Date']";
    public String taskStartDate = "//div[@class='dtp animated fadeIn']//div[@class='dtp-picker']//table/tbody//td/a[@class='dtp-select-day selected']";
    public String taskEndDateField = "//div[@class='card-body']//input[@placeholder='End Date']";
    public String taskNextMonthBtn = "//div[@class='dtp animated fadeIn']//div[@class='dtp-date']//div//a[@class='dtp-select-month-after']";
    public String taskEndDate = "//div[@class='dtp animated fadeIn']//div[@class='dtp-picker']//table/tbody//td/a[@class='dtp-select-day selected']";
    public String taskOkBtn = "//div[@class='dtp animated fadeIn']//button[text()='OK']";
    public String taskProjectSelection = "//div[@class='card-body']//div[@id='project_ajax']//span[@class='selection']";
    public String taskProjectOption = "//span[@class='select2-results']/ul[starts-with(@id,'select2-project_id')]/li";
    public String taskSummary = "//div[@class='card-body']//textarea[@placeholder='Summary']";
    public String taskDescription = "//body";
    public String saveBtn = "//button[normalize-space()='Save']";
}
