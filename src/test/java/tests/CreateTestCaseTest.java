package tests;

import lombok.extern.log4j.Log4j2;
import modals.TestCase;
import modals.TestCaseFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class CreateTestCaseTest extends BaseTest{

    @Test(description = "Creating new account")
    public void testCaseShouldBeCreated() throws InterruptedException {
        log.info("Creating new test case.");
        open("/login");
        loginPage.login(email,password);

        boolean isCreateTestCaseModalOpen = projectListPage
                .opened()
                .clickCase()
                .isPageOpen();
        Thread.sleep(1000);
        Assert.assertTrue(isCreateTestCaseModalOpen, "Creating test case is not opened.");
        TestCase testCase = TestCaseFactory.get();

        boolean isTestCaseDetailsPage = createTestCaseModalPage
                .create(testCase)
                .isPageOpen();
       Thread.sleep(1000);
        Assert.assertTrue(isTestCaseDetailsPage, "Страница Details не открылась.");

    }

}
