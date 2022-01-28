package elements;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2


public class DropDownForCreateTestCase {
    private String dropDownLocator = "//label[contains(text(),'%s')]/ancestor::div/input/../div[span]";
    private String optionLocator = "//div[contains(@class,'visible')]//a[text()='%s']";
    String label;

    public DropDownForCreateTestCase(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        log.info("Selecting an option from the list by name when creating test case");
        $(By.xpath(String.format(dropDownLocator,this.label))).click();
        $(byText(option)).click();

    }


}