
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    public void TestApi() {
       given().
                header("Token", "21de4a7cd8a374e88bb6a500bab9b0fbbd0a35f6").
                header("Content-Type", "application/json").
                body("{'title':'BlaBla','code':'!!!!!'}").
        when().
                post("https://api.qase.io/v1/project").
        then().
                statusCode(400).
                body("errorMessage",equalTo("Invalid payload."));
    }
}
