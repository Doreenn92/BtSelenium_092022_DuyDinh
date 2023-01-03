package doreen.com.BT_Locators2;

import doreen.com.Base.Base_old;

public class AddEmployee extends Base_old {
    public static void main(String[] args) throws InterruptedException {
        EmployeeLocators xp  = new EmployeeLocators();
        AddEmployee addEmp = new AddEmployee();

        addEmp.setupBrowser();

        //open website
        addEmp.openURL("https://app.hrsale.com/");

        //input Email, Password login
        addEmp.input(xp.email,"frances.burns");
        addEmp.input(xp.password,"frances.burns");
        addEmp.click(xp.loginBtn);
        Thread.sleep(1000);

        addEmp.click(xp.employeeMenu);
        addEmp.click(xp.addEmployeeBtn);
        Thread.sleep(100);

        //input First Name, Last Name
        addEmp.input(xp.empFirstName,"Doreen");
        addEmp.input(xp.empLastName,"Nguyen");

        //input Employee id
        addEmp.input(xp.empId,"689101");

        //input Contact Number
        addEmp.input(xp.empContactNumber,"0987654321");

        //input Gender
        addEmp.click(xp.empGenderSelection);
        addEmp.click(xp.empGenderOption);

        //input Email employee
        addEmp.input(xp.empEmail,"doreen@yopmail.com");

        //input Username employee
        addEmp.input(xp.empUsername,"doreen 123");

        //input Password employee
        addEmp.input(xp.empPassword,"yopmail.com");

        //input Office Shift
        addEmp.click(xp.empShiftSelection);
        addEmp.click(xp.empShiftOption);

        //input Role Shift
        addEmp.click(xp.empRoleSelection);
        addEmp.click(xp.empRoleOption);

        //select Department
        addEmp.click(xp.empDepSelection);
        addEmp.click(xp.empDepOption);
        Thread.sleep(1000);

        //select Designation
        addEmp.click(xp.empDesignSelection);
        Thread.sleep(500);
        addEmp.click(xp.empDesignOption);

        //input Basic Salary
        addEmp.input(xp.empSalary,"1500");

        //input Hour rate
        addEmp.input(xp.empHourlyRate,"10");

        //select Payslip type
        addEmp.click(xp.empPayslipSelection);
        Thread.sleep(2000);
        addEmp.click(xp.empPayslipOption);
        Thread.sleep(1000);


        addEmp.input(xp.empPic,"/Users/dinhnguyen/Downloads/restaurant-icon.png");

        //click Save button
        addEmp.click(xp.saveBtn);
        Thread.sleep(2000);

        //close browser
        addEmp.quitBrowser();
    }
}
