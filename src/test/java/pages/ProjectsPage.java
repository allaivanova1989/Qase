package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
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
    public static final By FIELD_FOR_NAME = By.cssSelector("[placeholder='For example: Web Application']");
    public static final By FIELD_FOR_CODE_PROJECT = By.cssSelector("[placeholder='For example: WA']");
    private String CODE;

    public String getCODE() {
        return CODE;
    }

    static Faker faker = new Faker();

    @Step("Go to reports page")
    public void goToPageReports() {
        log.info("Go to reports page");
        $(HYPERLINK_REPORTS).click();
    }

    @Step("Go to workspace page")
    public void goToPageWorkSpace() {
        log.info("Go to workspace page");
        $(HYPERLINK_WORKSPACE).click();
    }

    @Step("Go to projects page")
    public void goToPageProjects() {
        log.info("Go to projects page");
        $(HYPERLINK_PROJECTS).click();
    }

    @Step("Change status")
    public void chooseStatusAll() {
        log.info("Change status");
        $(STATUS_BUTTON).click();
        $(By.xpath("//button[contains(text(),'Select all')]")).click();
    }

    @Step("Change  filter")
    public void chooseHasAnyRun() {
        log.info("Change  filter");
        $(ADD_FILTER).click();
        $(By.xpath("//button[contains(text(),'Test runs')]")).click();
        $(By.xpath("//label[contains(text(),'Has any run')]")).click();

    }

    @Step("Create new project")
    public void createNewProject() throws InterruptedException {
        log.debug("Create new project");
        $(CREATE_NEW_PROJECT_BUTTON).click();
        $(FIELD_FOR_NAME).sendKeys(faker.gameOfThrones().dragon());
        Thread.sleep(10000);
        CODE = $(FIELD_FOR_CODE_PROJECT).getValue();
        $(By.xpath("//label[contains(text(),'Public')]")).click();
        $("[type='submit']").click();
    }


}
