package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class TestRunDetailsPage extends BasePage {
    private static final By DETAILS_RUN = By.xpath("//th[contains(text(), 'Status')]");

    @Override
    public boolean isPageOpen() {
        log.info("Check if the page DETAILS run has opened");
        return isExist(DETAILS_RUN);
    }
}
