package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {
    protected boolean isExist(By locator) {
        log.warn("Can get an exception NoSuchElementException");
        try {
            return $(locator).shouldBe(Condition.visible).isDisplayed();

        } catch (NoSuchElementException ex) {
            log.error("......" + ex.getMessage());
            return false;
        }

    }
    public abstract boolean isPageOpen();
}
