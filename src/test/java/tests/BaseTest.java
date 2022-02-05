package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest {
    String email, password;
    HomePage homePage;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    PageForProjectForTMS pageForProjectForTMS;
    CreateTestCaseModalPage createTestCaseModalPage;
    TestCaseDetailsPage testCaseDetailsPage;
    StartTestRunPage startTestRunPage;
    TestRunDetailsPage testRunDetailsPage;


    @BeforeMethod
    public void setUp() {
        log.info("Setup options and configurations.");
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        //      Configuration.clickViaJs = true;
        Configuration.savePageSource = false;
        Configuration.timeout = 20000;
        homePage = new HomePage();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        pageForProjectForTMS = new PageForProjectForTMS();
        createTestCaseModalPage = new CreateTestCaseModalPage();
        testCaseDetailsPage = new TestCaseDetailsPage();
        startTestRunPage = new StartTestRunPage();
        testRunDetailsPage = new TestRunDetailsPage();


//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
//        Configuration.browserCapabilities = chromeOptions;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Browser close.");
        getWebDriver().quit();

    }
}
