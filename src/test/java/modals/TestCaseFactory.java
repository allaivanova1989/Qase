package modals;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestCaseFactory {
    static Faker faker = new Faker();

    public static TestCase get() {
        log.debug("Create new test case.");
        return TestCase.builder()
                .title(faker.gameOfThrones().dragon())
                .status("Actual")
                .description(faker.expression("Description for test case."))
                .suite("SignUp")
                .severity("Normal")
                .priority("Low")
                .type("Smoke")
                .layer("E2E")
                .isFlaky("No")
                .milestone("Not set")
                .behavior("Positive")
                .automationStatus("To be automated")
                .preConditions(faker.rickAndMorty().location())
                .postConditions(faker.gameOfThrones().city())
                .action("Open signup in page")
                .inputData(faker.internet().emailAddress())
                .expectedResult(faker.expression("Enter is success."))
                .build();

    }
}
