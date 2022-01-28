package adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new Gson();

    public String post(String body, int statusCode, String url) {

        return given().
                log().all().
                header("Token", "21de4a7cd8a374e88bb6a500bab9b0fbbd0a35f6").
                header("Content-Type", "application/json").
                body(body).
                when().
                post("https://api.qase.io/v1/" + url).
                then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();


    }

    public String get(int statusCode, String url) {

        return given().
                log().all().
                header("Token", "21de4a7cd8a374e88bb6a500bab9b0fbbd0a35f6").
                header("Content-Type", "application/json").
                when().
                get("https://api.qase.io/v1/" + url).
                then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();


    }
}
