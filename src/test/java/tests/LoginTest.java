package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {
    @Test(description = "Login to the site using a username and password")
    public void Login() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();

        $(By.id("createButton")).shouldBe(visible);

    }

}
