package modals;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestRunFactory {
    static Faker faker = new Faker();

    public static TestRun get() {
        log.debug("Create new test run.");
        return TestRun.builder()
                .runTitle(faker.gameOfThrones().dragon())
                .description(faker.backToTheFuture().character())
                .plan("Arbolez Mentorosos")
                .environment("Not set")
                .milestone("Not set")
                .defaultAssignee("Иванова Алла")
                .build();

    }
}
