package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class HomePage {

    public static final By HYPERLINK_LOGIN = By.id("signin");
    public static final By START_FOR_FREE_BUTTON = By.id("signup");
    public static final By HYPERLINK_BOOK_A_DEMO = By.xpath("//a[contains(text(),'Book a demo')]");
    public static final By HYPERLINK_PRICING = By.xpath("//a[contains(text(),'Pricing')]");
    public static final By BUTTON_REQUEST_A_DEMO = By.xpath("//a[contains(text(),'REQUEST A DEMO')]");
    public static final By HYPERLINK_WATCH_VIDEO = By.xpath("//i[@class='fa fa-play']");
    public static final By HYPERLINK_TERMS_OF_SERVICE = By.xpath("//a[contains(text(),'Terms of Service')]");
    public static final By HYPERLINK_PRIVACY_POLICE = By.xpath("//a[contains(text(),'Privacy policy')]");

    public void clickOnLogin() {
        $(HYPERLINK_LOGIN).click();
    }

    public void clickOnPricing() {
        $(HYPERLINK_PRICING).click();
    }

    public void clickOnBookADemo() {
        $(HYPERLINK_BOOK_A_DEMO).click();
    }

    public void clickOnStartForFree() {
        $(START_FOR_FREE_BUTTON).click();
    }

    public void clickOnRequestADemo() {
        $(BUTTON_REQUEST_A_DEMO).click();
    }

    public void clickOnWatchVideo() {
        $(HYPERLINK_WATCH_VIDEO).click();
    }

    public void clickOnTermsOfService() {
        $(HYPERLINK_TERMS_OF_SERVICE).click();
    }

    public void clickOnPrivacyPolice() {
        $(HYPERLINK_PRIVACY_POLICE).click();
    }

  }
