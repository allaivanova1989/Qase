import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateTestPlanTest extends BaseTest {
    @Test(description = "Creating a new test plan for the site ShareLane.")
    public void createNewTestPlan() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();
        $(By.xpath("//a[@class=\"defect-title\"][text()='ShareLane']")).click();
        $(By.xpath("//span[@class=\"submenu-item-text\"][text()='Test Plans']")).click();
        $("#createButton").click();
        $("#title").sendKeys("Regression2");
        $(By.xpath("//p[@class='empty-node']")).sendKeys("Full Regression");
        $("#edit-plan-add-cases-button").click();
        $("#suite-1-checkbox").click();
        $("#suite-2-checkbox").click();
        $("#suite-3-checkbox").click();
        $("#select-cases-done-button").click();
        $("#save-plan").click();

        $(By.xpath("//div/a[@class='defect-title']")).shouldHave(exactText("Regression2"));

    }
}

