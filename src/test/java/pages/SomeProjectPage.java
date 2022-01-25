package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SomeProjectPage {
    public static final By REPOSITORY = By.xpath("//span[contains(text(),'Repository')]");
    public static final By TEST_REVIEW = By.xpath("//span[contains(text(),'Test Review')]");
    public static final By SHARED_STEPS = By.xpath("//span[contains(text(),'Shared Steps')]");
    public static final By MILESTONES = By.xpath("//span[contains(text(),'Milestones')]");
    public static final By TEST_PLANS = By.xpath("//span[contains(text(),'Test Plans')]");
    public static final By TEST_RUNS = By.xpath("//span[contains(text(),'Test Runs')]");
    public static final By DEFECTS = By.xpath("//span[contains(text(),'Defects')]");
    public static final By REQUIREMENTS = By.xpath("//span[contains(text(),'Requirements')]");
    public static final By SETTINGS = By.xpath("//span[contains(text(),'Settings')]");

    public void switghToRepository(){
        $(REPOSITORY).click();
    }
    public void switchToTestReview(){
        $(TEST_REVIEW).click();
    }
    public void switchToSharedSteps(){
        $(SHARED_STEPS).click();
    }
    public void switchToMilestones(){
        $(MILESTONES).click();
    }
    public void switchToTestPlans(){
        $(TEST_PLANS).click();
    }
    public void switchToTestRuns(){
        $(TEST_RUNS).click();
    }
    public void switchToDefects(){
        $(DEFECTS).click();
    }
    public void switchToRequirements(){
        $(REQUIREMENTS).click();
    }
    public void switchToSettings(){
        $(SETTINGS).click();
    }
    public void createNewTestCase(){
        $(REPOSITORY).click();
        $(By.xpath("//a[contains(text(),'Case')]")).click();

    }


}
