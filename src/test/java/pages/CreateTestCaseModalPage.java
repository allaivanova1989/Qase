package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.TestCase;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateTestCaseModalPage extends BasePage {

private static final By SAVE_AND_CREATE_ANOTHER_BUTTON =By.cssSelector("[class='btn btn-secondary me-1 save-button']");


@Override
    public boolean isPageOpen() {
        log.info("Check if the page CreateTestCaseModalPage has opened");
        return isExist(SAVE_AND_CREATE_ANOTHER_BUTTON);
    }
    @Step("Creating testCase")
    public TestCaseDetailsPage create(TestCase testCase) throws InterruptedException {
        log.info("Creating testCase");
        new Input( "Title").write(testCase.getTitle());
        new DropDown("Status").selectOption(testCase.getStatus());
        new Input( "Description").write(testCase.getDescription());
        new DropDown("Suite").selectOption(testCase.getSuite());
        new DropDown("Severity").selectOption(testCase.getSeverity());
        new DropDown("Priority").selectOption(testCase.getPriority());
        new DropDown("Type").selectOption(testCase.getType());
        new DropDown("Layer").selectOption(testCase.getLayer());
        new DropDown("Is Flaky").selectOption(testCase.getIsFlaky());
        new DropDown("Milestone").selectOption(testCase.getMilestone());
        new DropDown("Behavior").selectOption(testCase.getBehavior());
        new DropDown("Automation status").selectOption(testCase.getAutomationStatus());
        new Input( "Pre-conditions").write(testCase.getPreConditions());
        new Input( "Post-conditions").write(testCase.getPostConditions());
        $(By.xpath("//a[contains(text(),' Add step')]")).scrollIntoView(true);
        $(By.xpath("//a[contains(text(),' Add step')]")).click();
        new Input( "Action").writeForAddSteps(testCase.getAction());
        new Input( "Input data").writeForAddSteps(testCase.getInputData());
        new Input( "Expected result").writeForAddSteps(testCase.getExpectedResult());

        return clickSave();

    }
    @Step("Click button SAVE on the page CreateTestCaseModalPage")
    private TestCaseDetailsPage clickSave() {
        log.info("Click button SAVE on the page CreateTestCaseModalPage");
        $(By.id("save-case")).click();
        return new TestCaseDetailsPage();
    }

}
