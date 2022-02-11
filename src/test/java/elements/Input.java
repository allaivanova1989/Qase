package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {
    private String inputLocator = "//label[contains(text(),'%s')]/ancestor::div/input";
    private String inputLocatorAddSteps = "//label[contains(text(),'%s')]/ancestor::div[@class='form-group']/input";
    String Label;

    public Input(String label) {
        Label = label;
    }

    public void write(String text) {
        log.info("Write the text in the input field by the specified name ");
        $(By.xpath(String.format(inputLocator, this.Label))).setValue(text);
    }

    public void writeForAddSteps(String text) {
        $(By.xpath(String.format(inputLocatorAddSteps, this.Label))).setValue(text);
    }

}
