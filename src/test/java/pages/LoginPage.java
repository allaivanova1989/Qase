package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class LoginPage {
    public static final By FIELD_EMAIL = By.id("inputEmail");
    public static final By FIELD_PASSWORD = By.xpath("//*[@id='inputPassword']");
    public static final By BUTTON_LOGIN = By.cssSelector("#btnLogin");

    @Step("Enter to the site with  email and password")
    public void login(String email, String password){
        log.info("Enter to the site with  email and password");
        $(FIELD_EMAIL).setValue(email);
        $(FIELD_PASSWORD).setValue(password);
        $(BUTTON_LOGIN).click();
    }
}
