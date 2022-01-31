package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ProjectsTest extends BaseTest{
    @Test(description = "Create new projects.")
    public void createProject (){
        open("/login");
        loginPage.login(email,password);
        projectsPage.createNewProject();
        $(By.xpath("//div[@class='app']//div//h1")).shouldHave(Condition.text(projectsPage.getCODE()));

    }

    @Test(description = "Go to the page workspace.")
    public void goToWorkspace (){
        open("/login");
        loginPage.login(email,password);
        projectsPage.goToPageWorkSpace();
        $(By.xpath("//p[contains(text(),'Workspace')]")).shouldBe(Condition.visible);
    }
    @Test(description = "Go to the page reports.")
    public void goToReports (){
        open("/login");
        loginPage.login(email,password);
        projectsPage.goToPageReports();
        $(By.xpath("//div[@class='modal-body']/h1")).shouldHave(Condition.text("Upgrade your subscription"));
    }
    @Test(description = "Go to the page projects.")
    public void goToProjects (){
        open("/login");
        loginPage.login(email,password);
        projectsPage.goToPageProjects();
        $(ProjectsPage.CREATE_NEW_PROJECT_BUTTON).shouldBe(Condition.visible);
    }
    @Test(description = "Choose status:select all.")
    public void chooseStatus (){
        open("/login");
        loginPage.login(email,password);
        projectsPage.chooseStatusAll();
        $(ProjectsPage.STATUS_BUTTON).shouldHave(Condition.text("multiple"));
    }
    @Test(description = "Add filter > test run >has any run.")
    public void addFilter (){
        open("/login");
        loginPage.login(email,password);
        projectsPage.chooseHasAnyRun();
        $(By.xpath("//span[contains(text(),'Test runs: Has any run')]")).shouldBe(Condition.visible);
    }
}
