package tests;

import adapters.ProjectAdapter;
import modals.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ProjectApiTest {
    @Test
    public void negativeProjectApiTest() {
        Project project = Project.builder()
                .title("blabla")
                .code("!!!!!")
                .build();
        NegativeResponseStatus actual = new ProjectAdapter().post(project, 422);

        NegativeResponseStatus expected = NegativeResponseStatus.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();


        assertEquals(actual, expected);
//        assertEquals(actual.isStatus(), expected.isStatus());
//        assertEquals(actual.getErrorMessage(), expected.getErrorMessage());

    }

    @Test
    public void getProjectByInvalidNameTest() {
        NegativeResponseStatus actual = new ProjectAdapter().getProject(404, "QWEQWwws");
        NegativeResponseStatus expected = NegativeResponseStatus.builder()
                .status(false)
                .errorMessage("Project is not found.")
                .build();

        assertEquals(actual, expected);
    }

    @Test
    public void getProjectByRealNameAndNotEmptyTest() {
        PositiveResponseStatus actual = new ProjectAdapter().getProject2(200, "DEMO");
        PositiveResponseStatus expected = PositiveResponseStatus.builder()
                .status(true)
                .result(Result.builder()
                        .title("Demo Project")
                        .code("DEMO")
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
        PositiveResponseStatus actual = new ProjectAdapter().getProject2(200, "B000BSH8AQ");
        PositiveResponseStatus expected = PositiveResponseStatus.builder()
                .status(true)
                .result(Result.builder()
                        .title("The Doors of Perception")
                        .code("B000BSH8AQ")
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
//    @Test
//    public void positiveApiTest() {
//        Project project = Project.builder()
//                .title("ForApiTestProject")
//                .code("QWERTY")
//                .build();
//        String actual = new ProjectAdapter().post(project, 200);
//
//                assertEquals(actual,
//                "{\"status\":true,\"result\":{\"code\":\"QWERTY\"}}");
//    }
}