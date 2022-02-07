package tests;

import lombok.extern.log4j.Log4j2;
import modals.TestRun;
import modals.TestRunFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class RunningTest extends BaseTest {
    @Test(description = "Creat and start new test run")
    public void createNewTestRun() throws InterruptedException {
        log.info("Create test run");
                open("/login");
                loginPage.login(email,password);
        $(By.xpath("//a[@class='defect-title'][text()='Project for TMS']")).click();
        boolean isStartTestRunPageOpen = pageForProjectForTMS
                .opened()
                .startCreatingNewRun()
                .isPageOpen();
        Assert.assertTrue(isStartTestRunPageOpen, "Creating test run is not opened.");
       TestRun testRun = TestRunFactory.get();

        boolean isTestRunDetailsPage = startTestRunPage
                .create(testRun)
                .isPageOpen();
        Thread.sleep(1000);
        Assert.assertTrue(isTestRunDetailsPage, "Страница Details не открылась.");

 AllureUtils.takeScreenshot();
    }
}
