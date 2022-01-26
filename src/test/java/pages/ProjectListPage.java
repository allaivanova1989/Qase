package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectListPage extends BasePage{
    private static final By Projects_PICTURE = By.xpath("//h1[contains(text(), 'Projects')]");


@Override
    public boolean isPageOpen() {
        log.info("Check if the page ProjectListPage has opened");
        return isExist(Projects_PICTURE);
    }

    public ProjectListPage opened() {
        log.info("Open the page ProjectListPage");
        open( "https://app.qase.io/project/TMSALLA?view=2&suite=1");
        return this;
    }

    public CreateTestCaseModalPage clickCase() {
        log.info("Click button case on the page ProjectListPage");
        $(By.id("create-case-button")).click();
        return new CreateTestCaseModalPage();
    }

}

