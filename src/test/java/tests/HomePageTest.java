package tests;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
@Log4j2
public class HomePageTest extends BaseTest {
    @Test(description = "Go to the login page")
    public void clickOnLogin() {
        log.debug("Go to the login page");
        open("");
        homePage.clickOnLogin();
        $("[class='form-signin']").shouldBe(Condition.visible);
    }

    @Test(description = "Go to the plans page")
    public void clickOnPricingHyperlink() {
        log.info("Go to the plans page");
        open("");
        homePage.clickOnPricing();
        $(By.xpath("//h1[contains(text(),'Flexible plans for any team')]")).should(exist);
    }

    @Test(description = "Go to the information about Demo project")
    public void clickOnBookADemo() {
        log.info("Go to the information about Demo project");
        open("");
        homePage.clickOnBookADemo();
        $(".calendly-close-overlay").shouldBe(visible);
    }

    @Test(description = "Go to the page signUp")
    public void clickOnStartForFree() {
        log.debug("Go to the page signUp");
        open("");
        homePage.clickOnStartForFree();
        $("[type='submit']").shouldHave(exactText("Create your Qase account >"));
    }

    @Test(description = "Go to the information about Demo project")
    public void clickOnRequestADemo() {
        log.info("Go to the information about Demo project");
        open("");
        homePage.clickOnRequestADemo();
        $(".calendly-close-overlay").shouldBe(visible);
    }

    @Test(description = "Viewing videos")
    public void clickOnWatchVideo() {
        log.info("Viewing videos");
        open("");
        homePage.clickOnWatchVideo();
        $(".modal-video-inner").shouldBe(visible);
    }

    @Test(description = "Viewing usage information")
    public void cheсkTermsOfService() {
        log.info("Viewing usage information");
        open("");
        homePage.clickOnTermsOfService();
        $(By.xpath("//section[@class='text-left']")).shouldHave(text("Terms of Use"));
    }

    @Test(description = "Viewing privacy police")
    public void checkPrivacyPolice() {
        log.info("Viewing privacy police");
        open("");
        homePage.clickOnPrivacyPolice();
        $(".col").shouldHave(text("Privacy Policy"));
    }

    @Test(description = "Checking the possibility of going to a page in Telegram")
    public void checkTelegramPicture() {
        log.debug("Checking the possibility of going to a page in Telegram");
        open("");
        $("[title='Telegram']").shouldHave(attribute("href", "https://t.me/qaseio/"));
    }

    @Test(description = "Checking the possibility of going to a page in Facebook")
    public void checkFacebookPicture() {
        log.debug("Checking the possibility of going to a page in Facebook");
        open("");
        $("[title='Facebook']").shouldHave(attribute("href", "https://www.facebook.com/qase.io/"));
    }

    @Test(description = "Checking the possibility of going to a page in Twitter")
    public void checkTwitterPicture() {
        log.debug("Checking the possibility of going to a page in Twitter");
        open("");
        $("[title='Twitter']").shouldHave(attribute("href", "https://twitter.com/qase_io"));

    }

}
