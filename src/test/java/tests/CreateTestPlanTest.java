package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class CreateTestPlanTest extends BaseTest {
    @Test(description = "Creating a new test plan for the site ShareLane.")
    public void createNewTestPlan() {
        log.info("Creating new test plan.");
        open("/login");
        loginPage.login(email, password);
        $(By.xpath("//a[@class='defect-title'][text()='Project for TMS']")).click();
        pageForProjectForTMS.createTestPlan();
        $("[class='defect-title']").shouldHave(text(pageForProjectForTMS.getNameOfTestPlan()));

    }
}

