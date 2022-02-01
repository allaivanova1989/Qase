package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.TestRun;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class StartTestRunPage extends BasePage {
    private static final By START_RUN_BUTTON = By.id("save-run-button");
    private String nameTestRun;

    public String getNameTestRun() {
        return nameTestRun;
    }

    @Override
    public boolean isPageOpen() {
        log.info("Check if the page StartTestRunPage has opened");
        return isExist(START_RUN_BUTTON);
    }

    @Step("Creating startRun")
    public TestRunDetailsPage create(TestRun testRun) throws InterruptedException {
        log.info("Creating testRun");
        $(By.xpath("//label[contains(text(),'Run title')]/ancestor::div/input")).clear();
        new Input("Run title").write(testRun.getRunTitle());
        nameTestRun = $("#title").getValue();
        new Input("Description").write(testRun.getDescription());
        new DropDown("Plan").selectOption(testRun.getPlan());
        new DropDown("Environment").selectOption(testRun.getEnvironment());
        new DropDown("Milestone").selectOption(testRun.getMilestone());
        new DropDown("Default assignee").selectOption(testRun.getDefaultAssignee());
        $(By.id("edit-run-add-cases-button")).click();
        $(By.xpath("//span[@class='custom-control-indicator']")).click();
        $(By.xpath("//button[contains(text(),'Done')]")).click();

        return clickStartRun();
    }

    @Step("Click button SAVE on the page CreateTestCaseModalPage")
    private TestRunDetailsPage clickStartRun() {
        log.info("Click button start run.");
        $(By.id("save-run-button")).click();
        return new TestRunDetailsPage();
    }


}
