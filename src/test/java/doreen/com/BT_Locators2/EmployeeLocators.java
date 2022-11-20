package doreen.com.BT_Locators2;

public class EmployeeLocators {
    //xpath
    String email = "//input[@id='iusername']";
    String password = "//input[@type='password']";
    String loginBtn = "//button[@class='btn btn-primary mt-2 ladda-button']";
    String employeeMenu = "//ul[@class='pc-navbar']//li//span[normalize-space()='Employees']";
    String addEmployeeBtn = "//a[normalize-space()='Add New']";
    String empFirstName = "//label[@for='company_name']/following-sibling::div[@class='input-group']//input";
    String empLastName = "//label[@for='last_name']/parent::div/descendant::input";
    String empId = "//label[normalize-space()='Employee ID']/following-sibling::input";
    String empContactNumber = "//input[@name='contact_number']";
    String empGenderSelection = "//span[starts-with(@id,'select2-gender')]";
    String empGenderOption = "//ul[@class='select2-results__options' and starts-with(@id,'select2-gender')]/li[normalize-space()='Female']";
    String empEmail = "//input[@name='email']";
    String empUsername = "//input[@name='username']";
    String empPassword = "//label[@for='website']/following::div//input[@placeholder='Password']";
    String empShiftSelection = "//span[starts-with(@id,'select2-office_shift')]";
    String empShiftOption = "//ul[@class='select2-results__options' and starts-with(@id,'select2-office_shift')]/li[1]";
    String empRoleSelection = "//span[starts-with(@id,'select2-role')]";
    String empRoleOption = "//ul[@class='select2-results__options' and starts-with(@id,'select2-role')]/li[2]";
    String empDepSelection = "//span[starts-with(@id,'select2-department')]";
    String empDepOption = "//ul[@class='select2-results__options' and starts-with(@id,'select2-department')]/li[1]";
    String empDesignSelection = "//span[starts-with(@id,'select2-designation')]";
    String empDesignOption = "//ul[starts-with(@id,'select2-designation')]/li[1]";
    String empSalary = "//input[@name='basic_salary']";
    String empHourlyRate = "//input[@name='hourly_rate']";
    String empPayslipSelection = "//span[starts-with(@id,'select2-salay_type')]";
    String empPayslipOption = "//ul[starts-with(@id,'select2-salay_type')]/li[1]";
    String empPic = "//input[@type='file']";
    String saveBtn = "//button[normalize-space()='Save']";
}
