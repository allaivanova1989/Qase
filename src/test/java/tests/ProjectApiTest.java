package tests;

import adapters.ProjectAdapter;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import modals.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Log4j2
public class ProjectApiTest {
    static Faker faker = new Faker();
    public static String code;
    public static String title;

    @Test
    public void negativeProjectApiTest() {
        log.info("Creating new project with incorrect code.");
        Project project = Project.builder()
                .title("blabla")
                .code("!!!!!")
                .build();
        NegativeResponseStatus actual = new ProjectAdapter().postWithIncorrectData(project, 422);

        NegativeResponseStatus expected = NegativeResponseStatus.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();

        assertEquals(actual, expected);

    }

    @Test
    public void positiveProjectApiTest() {
        log.info("Creating new project with correct code.");
        Project project = Project.builder()
                .title(faker.pokemon().name())
                .code(faker.regexify("[A-Z]{7}"))
                .build();
       code = project.getCode();
        title = project.getTitle();
        PositiveResponsStatusForCreatProject actual = new ProjectAdapter().postWithCorrectData(project, 200);

        PositiveResponsStatusForCreatProject expected = PositiveResponsStatusForCreatProject.builder()
                .status(true)
                .build();


        assertEquals(actual, expected);

    }

    @Test
    public void getProjectByInvalidNameTest() {
        log.info("Search project by incorrect code.");
        NegativeResponseStatus actual = new ProjectAdapter().getProjectWithIncorrectCode(404, "QWEQWwws");
        NegativeResponseStatus expected = NegativeResponseStatus.builder()
                .status(false)
                .errorMessage("Project is not found.")
                .build();

        assertEquals(actual, expected);
    }

    @Test
    public void getProjectByRealNameAndNotEmptyTest() {
        log.info("Search project by correct code and name with cases, suites and other.");
        PositiveResponseStatus actual = new ProjectAdapter().getProjectWithCorrectCode(200, code);
        PositiveResponseStatus expected = PositiveResponseStatus.builder()
                .status(true)
                .result(Result.builder()
                        .title(title)
                        .code(code)
                        .counts(Counts.builder()
                                .cases(10)
                                .suites(3)
                                .milestones(2)
                                .runs(Runs.builder()
                                        .total(0)
                                        .active(0)
                                        .build())
                                .defects(Defects.builder()
                                        .total(0)
                                        .open(0)
                                        .build())
                                .build())
                        .build())
                .build();

        assertEquals(actual, expected);
    }

    @Test
    public void getEmptyProjectByRealNameTest() {
        log.info("Search project by correct code and name without cases, suites and other.");
        PositiveResponseStatus actual = new ProjectAdapter().getProjectWithCorrectCode(200, "TPN");
        PositiveResponseStatus expected = PositiveResponseStatus.builder()
                .status(true)
                .result(Result.builder()
                        .title("test project Name")
                        .code("TPN")
                        .counts(Counts.builder()
                                .cases(0)
                                .suites(0)
                                .milestones(0)
                                .runs(Runs.builder()
                                        .total(0)
                                        .active(0)
                                        .build())
                                .defects(Defects.builder()
                                        .total(0)
                                        .open(0)
                                        .build())
                                .build())
                        .build())
                .build();

        assertEquals(actual, expected);
    }


    @Test
    public void deleteProjectByCodeTest() {
        log.info("Delete project by code.");
        PositiveResponsStatusForCreatProject actual = new ProjectAdapter().deleteProjectByCorrectCode(200, "VERMITHRAX");
        PositiveResponsStatusForCreatProject expected = PositiveResponsStatusForCreatProject.builder()
                .status(true)
                .build();

        assertEquals(actual, expected);
    }
}
