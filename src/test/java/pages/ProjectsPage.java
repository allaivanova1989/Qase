package pages;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectsPage {
    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    public static final By ADD_FILTER = By.cssSelector("[class='add-filter-button']");
    public static final By STATUS_BUTTON = By.xpath("//span[contains(text(),'Status: ')]");
    public static final By HYPERLINK_PROJECTS = By.xpath("//span[contains(text(),'Projects')]");
    public static final By HYPERLINK_WORKSPACE = By.xpath("//span[contains(text(),'Workspace')]");
    public static final By HYPERLINK_REPORTS = By.xpath("//span[contains(text(),'Reports')]");
    static Faker faker = new Faker();

    public void goToPageReports() {
        log.info("Go to reports page");
        $(HYPERLINK_REPORTS).click();
    }

    public void goToPageWorkSpace() {
        log.info("Go to workspace page");
        $(HYPERLINK_WORKSPACE).click();
    }

    public void goToPageProjects() {
        log.info("Go to projects page");
        $(HYPERLINK_PROJECTS).click();
    }

    public void chooseStatusAll() {
        log.info("Change status");
        $(STATUS_BUTTON).click();
        $(By.xpath("//button[contains(text(),'Select all')]")).click();
    }

    public void chooseHasAnyRun() {
        log.info("Change  filter");
        $(ADD_FILTER).click();
        $(By.xpath("//button[contains(text(),'Test runs')]")).click();
        $(By.xpath("//label[contains(text(),'Has any run')]")).click();


    }
    public void createNewProject() {
        log.debug("Create new project");
        $(CREATE_NEW_PROJECT_BUTTON).click();
        $("[placeholder='For example: Web Application']").sendKeys(faker.gameOfThrones().dragon());
        $("[placeholder='For example: WA']").sendKeys("QAQA");
        $(By.xpath("//label[contains(text(),'Public')]")).click();
        $(By.xpath("//label[@for='accessAll']")).click();
        $("[type='submit']").click();

    }
}
