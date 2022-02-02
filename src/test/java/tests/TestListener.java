package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

@Log4j2
public class TestListener implements ITestListener {
    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        AllureUtils.takescreenshot();
    }
}