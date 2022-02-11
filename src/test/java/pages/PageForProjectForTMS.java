package pages;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2

public class PageForProjectForTMS extends BasePage {
    private static final By Projects_PICTURE = By.xpath("//h1[contains(text(), 'Projects')]");
    private String nameOfTestPlan;
    static Faker faker = new Faker();

    public String getNameOfTestPlan() {
        return nameOfTestPlan;
    }

    @Override
    public boolean isPageOpen() {
        log.info("Check if the page PageForProjectForTMS has opened");
        return isExist(Projects_PICTURE);
    }

    @Step("Open the page PageForProjectForTMS")
    public PageForProjectForTMS opened() {
        log.info("Open the page PageForProjectForTMS");
        open("https://app.qase.io/project/TMSALLA?view=2&suite=1");
        return this;
    }

    @Step("Click button case on the page PageForProjectForTMS")
    public CreateTestCaseModalPage clickCase() {
        log.info("Click button case on the page PageForProjectForTMS");
        $(By.id("create-case-button")).click();
        return new CreateTestCaseModalPage();
    }

    @Step("Click Test Plans on the page ProjectPage")
    public void createTestPlan() {
        log.info("Create test plans on the page ProjectPage");
        $(By.xpath("//span[contains(text(),'Test Plans')]")).click();
        $(By.id("createButton")).click();
        $(By.id("title")).sendKeys(faker.rickAndMorty().location());
        nameOfTestPlan = $(By.id("title")).getValue();
        $(By.xpath("//p[@data-placeholder='For example: Full regression']")).sendKeys(faker.rickAndMorty().character());
        $(By.id("edit-plan-add-cases-button")).click();
        $(By.cssSelector("[class='custom-control-indicator']")).click();
        $(By.id("select-cases-done-button")).click();
        $(By.id("save-plan")).click();
    }

    @Step("Create new run for test")
    public StartTestRunPage startCreatingNewRun() throws InterruptedException {
        $(By.xpath("//span[contains(text(), 'Test Runs')]")).click();
        Thread.sleep(1000);
        if ($(By.xpath("//tr[1]//a[@class='btn btn-dropdown']")).is(Condition.exist)) {
            Thread.sleep(1000);
            $(By.xpath("//tr[1]//a[@class='btn btn-dropdown']")).click();
            $(By.xpath("//a[contains(text(),'Delete')]")).click();
            $(By.xpath("//button[contains(text(),' Delete run')]")).click();
            $(By.id("start-new-test-run-button")).click();
        } else {
            $(By.id("start-new-test-run-button")).click();
        }
        return new StartTestRunPage();
    }

}

