package pages;

import elements.DropDownForCreateTestCase;
import elements.InputForCreateTestCase;
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
    public TestCaseDetailsPage create(TestCase testCase) {
        log.info("Creating testCase");
        new InputForCreateTestCase( "Title").write(testCase.getTitle());

        new DropDownForCreateTestCase("Status").selectOption(testCase.getStatus());
        new InputForCreateTestCase( "Description").write(testCase.getDescription());
        new DropDownForCreateTestCase("Suite").selectOption(testCase.getSuite());
        new DropDownForCreateTestCase("Severity").selectOption(testCase.getSeverity());
        new DropDownForCreateTestCase("Priority").selectOption(testCase.getPriority());
        new DropDownForCreateTestCase("Type").selectOption(testCase.getType());
        new DropDownForCreateTestCase("Layer").selectOption(testCase.getLayer());
        new DropDownForCreateTestCase("Is Flaky").selectOption(testCase.getIsFlaky());
        new DropDownForCreateTestCase("Milestone").selectOption(testCase.getMilestone());
        new DropDownForCreateTestCase("Behavior").selectOption(testCase.getBehavior());
        new DropDownForCreateTestCase("Automation status").selectOption(testCase.getAutomationStatus());
        new InputForCreateTestCase( "Pre-conditions").write(testCase.getPreConditions());
        new InputForCreateTestCase( "Post-conditions").write(testCase.getPostConditions());
        $(By.xpath("//a[contains(text(),' Add step')]")).click();
        new InputForCreateTestCase( "Action").writeForAddSteps(testCase.getAction());
        new InputForCreateTestCase( "Input data").writeForAddSteps(testCase.getInputData());
        new InputForCreateTestCase( "Expected result").writeForAddSteps(testCase.getExpectedResult());

        return clickSave();

    }
    private TestCaseDetailsPage clickSave() {
        log.info("Click button SAVE on the page CreateTestCaseModalPage");
        $(By.id("save-case")).click();
        return new TestCaseDetailsPage();
    }

}
