package tests;

import adapters.SuiteAdapter;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import modals.PositiveResponsStatusForSuite;
import modals.Suite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class SuiteApiTest extends BaseTest{
    static Faker faker = new Faker();
    @Test
    public void positiveSuiteCreating() {
        log.info("Creating new suite with correct code.");
        Suite suite = Suite.builder()
                .title(faker.pokemon().name())
                .description(faker.rickAndMorty().location())
                .preconditions(faker.expression("Site is open"))
                .parent_id(faker.number().randomDigitNotZero())

                .build();
        PositiveResponsStatusForSuite actual = new SuiteAdapter().post(suite, 200, "SL");

        PositiveResponsStatusForSuite expected = PositiveResponsStatusForSuite.builder()
                .status(true)
                .build();

        assertEquals(actual, expected);

    }
}
