package elements;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2

public class DropDown {
    private String dropDownLocator = "//label[contains(text(),'%s')]/ancestor::div/input/../div[span]";
    String label;

    public DropDown(String label) {
        this.label = label;
    }

    public void selectOption(String option) throws InterruptedException {
        log.info("Selecting an option from the list by name ");
        $(By.xpath(String.format(dropDownLocator, this.label))).click();
        Thread.sleep(1000);
        $(byText(option)).click();

    }

}
