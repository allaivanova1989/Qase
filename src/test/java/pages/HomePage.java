package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class HomePage {

    public static final By HYPERLINK_LOGIN = By.id("signin");
    public static final By START_FOR_FREE_BUTTON = By.id("signup");
    public static final By HYPERLINK_BOOK_A_DEMO = By.xpath("//a[contains(text(),'Book a demo')]");
    public static final By HYPERLINK_PRICING = By.xpath("//a[contains(text(),'Pricing')]");
    public static final By BUTTON_REQUEST_A_DEMO = By.xpath("//a[contains(text(),'REQUEST A DEMO')]");
    public static final By HYPERLINK_WATCH_VIDEO = By.xpath("//i[@class='fa fa-play']");
    public static final By HYPERLINK_PRIVACY_POLICE = By.xpath("//a[contains(text(),'Privacy policy')]");

    @Step("Click on login")
    public void clickOnLogin() {
        log.info("Click on login");
        $(HYPERLINK_LOGIN).click();
    }

    @Step("Click on Pricing")
    public void clickOnPricing() {
        log.info("Click on Pricing");
        $(HYPERLINK_PRICING).click();
    }

    @Step("Click on Book A Demo")
    public void clickOnBookADemo() {
        log.info("Click on Book A Demo");
        $(HYPERLINK_BOOK_A_DEMO).click();
    }

    @Step("Click on Start for free")
    public void clickOnStartForFree() {
        log.info("Click on Start for free");
        $(START_FOR_FREE_BUTTON).click();
    }

    @Step("Click on Request a Demo")
    public void clickOnRequestADemo() {
        log.info("Click on Request a Demo");
        $(BUTTON_REQUEST_A_DEMO).click();
    }

    @Step("Click on Watch video")
    public void clickOnWatchVideo() {
        log.info("Click on Watch video");
        $(HYPERLINK_WATCH_VIDEO).click();
    }

    @Step("Click on Privacy Police")
    public void clickOnPrivacyPolice() {
        log.info("Click on Privacy Police");
        $(HYPERLINK_PRIVACY_POLICE).scrollIntoView(true);
        $(HYPERLINK_PRIVACY_POLICE).click();
    }

}
