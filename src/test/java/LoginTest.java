import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{
    @Test
    public void Login() {
        open("/login");
        $("#inputEmail").sendKeys("baby20086@rambler.ru");
        $(By.xpath("//*[@id='inputPassword']")).setValue("19891206Ai");
        $("#btnLogin").click();

        $(By.id("createButton")).shouldBe(visible);

    }
}
