package doreen.com.BT_Locators;

import doreen.com.Base.Base;
import org.openqa.selenium.WindowType;

public class AddProject extends Base {
    public static void main(String[] args) {
        LearningLocators xp = new LearningLocators();
        AddProject addPj = new AddProject();

        addPj.setupBrowser();

        //open website
        addPj.openURL("https://app.hrsale.com/");

        //input Email, Password
        addPj.input(xp.email, "frances.burns");
        addPj.input(xp.password, "frances.burns");
        addPj.click(xp.loginBtn);
        sleep(1);

        addPj.click(xp.projectMenu);
        addPj.click(xp.addProjectBtn);
        sleep(0.2);

        //input Title
        addPj.input(xp.pjTitle, "New Selenium project");

        //input Client
        addPj.click(xp.pjClientSelection);
        addPj.click(xp.pjClientOption);

        //input Estimate hour
        addPj.input(xp.pjEstHour, "160");

        //select Priority
        addPj.click(xp.pjPriority);
        addPj.click(xp.pjPriorityOption);

        //select Start date
        addPj.click(xp.pjStartDateField);
        addPj.click(xp.pjStartDate);
        addPj.click(xp.pjOkBtn);

        //select End date
        addPj.click(xp.pjEndDateField);
        addPj.click(xp.pjNextMonthBtn);
        addPj.click(xp.pjEndDate);
        addPj.click(xp.pjOkBtn);

        //input Summary
        addPj.input(xp.pjSummary, "Selenium xpath exercise");

        //select Team
        addPj.click(xp.pjTeamSelection);
        addPj.click(xp.pjTeamOption);

        //input description
        driver.switchTo().frame(0);
        addPj.input(xp.pjDescription, "This is a short description");
        driver.switchTo().parentFrame();

        //click Save button
        addPj.click(xp.saveBtn);
        sleep(2);

        //close browser
        addPj.quitBrowser();
    }
}
