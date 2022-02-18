package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@Log4j2
public abstract class BaseTest {
    String email, password;
    HomePage homePage;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    PageForProjectForTMS pageForProjectForTMS;
    CreateTestCaseModalPage createTestCaseModalPage;
    TestCaseDetailsPage testCaseDetailsPage;
    StartTestRunPage startTestRunPage;
    TestRunDetailsPage testRunDetailsPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        log.info("Setup options and configurations.");

        if (browser.equals("chrome")) {
            Configuration.browser = "chrome";
        } else if (browser.equals("firefox")) {
            Configuration.browser = "firefox";
        } else if (browser.equals("edge")) {
            Configuration.browser = "edge";
        }
           Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        //  Configuration.browser = "chrome";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 10000;
        homePage = new HomePage();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        pageForProjectForTMS = new PageForProjectForTMS();
        createTestCaseModalPage = new CreateTestCaseModalPage();
        testCaseDetailsPage = new TestCaseDetailsPage();
        startTestRunPage = new StartTestRunPage();
        testRunDetailsPage = new TestRunDetailsPage();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Browser close.");
        getWebDriver().quit();

    }
}
