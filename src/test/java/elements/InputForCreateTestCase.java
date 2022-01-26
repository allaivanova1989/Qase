package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class InputForCreateTestCase {
    private String inputLocator = "//label[contains(text(),'%s')]/ancestor::div/input";
    private String inputLocatorAddSteps = "//label[contains(text(),'%s')]/ancestor::div[@class='form-group']/input";
    String Label;

    public InputForCreateTestCase(String label) {
        Label = label;
    }

    public void write(String text) {
        log.info("Write the text in the input field by the specified name when creating test case");
        $(By.xpath(String.format(inputLocator, this.Label))).sendKeys(text);
    }

    public void writeForAddSteps(String text) {
        $(By.xpath(String.format(inputLocatorAddSteps, this.Label))).sendKeys(text);
    }

}
