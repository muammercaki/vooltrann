package com.voltran.steps.user;


import com.voltran.utils.ConfigManager;
import io.restassured.RestAssured;
import static com.voltran.constans.Endpoints.USER_LOGIN;
import static com.voltran.constans.Endpoints.jsonObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserLogin {

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");

    public UserLogin() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static void verifyUserSuccessLogin() {
        given()
                .pathParam("tenant-name", "posta")
                .header("Accept", "application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(USER_LOGIN)
                .then()
                .assertThat()
                .body("hasError", is(false))
                .statusCode(200).log().all();

    }
}
