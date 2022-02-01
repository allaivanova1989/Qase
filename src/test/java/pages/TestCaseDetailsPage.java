package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class TestCaseDetailsPage extends BasePage {
    private static final By DETAILS_CASE = By.xpath("//span[@class='style_titleText-3QMtk']");


    @Override
    public boolean isPageOpen() {
        log.info("Check if the page DETAILS CASE has opened");
        return isExist(DETAILS_CASE);
    }

}
