package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RunningTest extends BaseTest {
    @Test(description = "Creat and start new test run")
    public void createNewTestPlan() throws InterruptedException {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();
        $(By.xpath("//a[@class='defect-title'][text()='ShareLane']")).click();
        $(By.xpath("//span[@class='submenu-item-text'][text()='Test Runs']")).click();
        $("#start-new-test-run-button").click();
        $(By.xpath("//div[@class='ProseMirror toastui-editor-contents']")).sendKeys("Full regression for homework");
        $("#title").clear();
        Thread.sleep(100);
        $("#title").sendKeys("Test run 2022/01/19");
        $(By.xpath("//div[@id='planGroup']/div/div/div[2]")).click();
        $(byText("Regression2")).click();
        $(By.xpath("//label[@class='me-sm-2']/ancestor::div[@class='col-lg-4 col-sm-12 col-xs-12']/div")).click();
        $(byText("Иванова Алла")).click();
        $("#save-run-button").click();

        $(".defect-title").shouldHave(exactText("Test run 2022/01/19"));

    }
}
