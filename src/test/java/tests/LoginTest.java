package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginTest extends BaseTest {
    @Test(description = "Login to the site using  valid email and password")
    public void loginWithValidEmailAndPassword() {
        log.debug("Login to the site using  valid email and password");
        open("/login");
        loginPage.login(email,password);

        $(".avatar-sm ").shouldBe(visible);
    }

    @Test(description = "Login to the site using a email and empty password")
    public void loginWithValidEmailAndEmptyPassword() {
        log.debug("Login to the site using a email and empty password");
        open("/login");
        loginPage.login(email,"");

        $(LoginPage.FIELD_PASSWORD).shouldHave(attribute("validationMessage"));
    }

    @Test(description = "Login to the site using an empty email and valid password")
    public void loginWithEmptyEmailAndValidPassword() {
        log.debug("Login to the site using an empty email and valid password");
        open("/login");
        loginPage.login("",password);

        $(LoginPage.FIELD_EMAIL).shouldHave(attribute("validationMessage"));
    }

    @Test(description = "Login to the site using an empty email and empty password")
    public void loginWithEmptyEmailAndEmptyPassword() {
        log.debug("Login to the site using an empty email and empty password");
        open("/login");
        loginPage.login("","");

        $(LoginPage.FIELD_EMAIL).shouldHave(attribute("validationMessage"));
    }

    @Test(description = "Login to the site using an invalid email and invalid password")
    public void loginWithInvalidEmailAndInvalidPassword() {
        log.debug("Login to the site using an invalid email and invalid password");
        open("/login");
        loginPage.login("ggiih","dtdtfyig");

        $(LoginPage.FIELD_EMAIL).shouldHave(attribute("validationMessage"));
    }


}
