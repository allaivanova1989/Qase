package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class LoginPage {
    public static final By FIELD_EMAIL = By.id("inputEmail");
    public static final By FIELD_PASSWORD = By.xpath("//*[@id='inputPassword']");
    public static final By BUTTON_LOGIN = By.cssSelector("#btnLogin");

    public void login(String email, String password){
        log.info("Enter to the site with  email and password");
        $(FIELD_EMAIL).sendKeys(email);
        $(FIELD_PASSWORD).sendKeys(password);
        $(BUTTON_LOGIN).click();
    }
}
