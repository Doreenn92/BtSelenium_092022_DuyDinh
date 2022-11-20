package doreen.com.BT_WebElement_Webdriver;

import doreen.com.BT_WebElement_Webdriver.Locators.ProjectLocators;
import doreen.com.BT_WebElement_Webdriver.Locators.TaskLocators;
import doreen.com.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.List;

public class AddProjectTask extends Base {
    public static void main(String[] args) {
        ProjectLocators pj = new ProjectLocators();
        TaskLocators task = new TaskLocators();
        AddProjectTask add = new AddProjectTask();

        add.setupBrowser();

        //open website
        add.openURL("https://app.hrsale.com/");

        //input Email, Password
        add.input(pj.email, "frances.burns");
        add.input(pj.password, "frances.burns");
        driver.findElement(By.xpath(pj.loginBtn)).submit();
        //add.click(pj.loginBtn);
        sleep(1);

        System.out.println("----Add new Project----");
        add.click(pj.projectMenu);
        add.click(pj.addProjectBtn);
        sleep(0.2);

        //input Project Title
        add.input(pj.pjTitle, "New Selenium project 2");

        //input Project Client
        add.click(pj.pjClientSelection);
        add.click(pj.pjClientOption);

        //input Project Estimate hour
        add.input(pj.pjEstHour, "160");

        //select Project Priority
        add.click(pj.pjPriority);
        add.click(pj.pjPriorityOption);

        //select Project Start date
        add.click(pj.pjStartDateField);
        add.click(pj.pjStartDate);
        add.click(pj.pjOkBtn);

        //select Project End date
        add.click(pj.pjEndDateField);
        add.click(pj.pjNextMonthBtn);
        add.click(pj.pjEndDate);
        add.click(pj.pjOkBtn);

        //input Project Summary
        add.input(pj.pjSummary, "Selenium xpath exercise");

        //select Project Team
        add.click(pj.pjTeamSelection);
        add.click(pj.pjTeamOption);

        //input Project description
        driver.switchTo().frame(0);
        add.input(pj.pjDescription, "This is a short description");
        driver.switchTo().parentFrame();

        //click Project Save button
        add.click(pj.saveBtn);
        sleep(2);

        System.out.println("----Add new Task----");
        //click on Task menu
        add.click(task.taskMenu);
        add.click(task.addTaskBtn);
        sleep(0.2);

        //input Task Title
        add.input(task.taskTitle, "New Selenium task");

        //select Task Start date
        add.click(task.taskStartDateField);
        add.click(task.taskStartDate);
        add.click(task.taskOkBtn);

        //select Task End date
        add.click(task.taskEndDateField);
        add.click(task.taskNextMonthBtn);
        add.click(task.taskEndDate);
        add.click(task.taskOkBtn);

        //input Task Estimate hour
        add.input(task.taskEstHour, "15");

        //select task Project
        add.click(task.taskProjectSelection);
        sleep(0.2);
        List<WebElement> selection = driver.findElements(By.xpath(task.taskProjectOption));
        task.taskProjectOption = task.taskProjectOption + "[" + selection.size() + "]"; // đổi xpath để lấy phần tử cuối cùng trong list cũng là project mới tạo ở bước trên
        add.click(task.taskProjectOption);

        //input Task Summary
        add.input(task.taskSummary, "Selenium WebElement WebDriver exercise. Summary field must be at least 60 characters in length.");

        //input Task description
        driver.switchTo().frame(0);
        add.input(task.taskDescription, "This is a short description for new task");
        driver.switchTo().parentFrame();

        //click Save button
        add.click(task.saveBtn);
        sleep(2);

        //close browser
        add.quitBrowser();
    }
}
