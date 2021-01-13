package com.voltran.steps.accountApi;

import com.voltran.utils.ConfigManager;
import io.restassured.RestAssured;
import static com.voltran.constans.Endpoints.ACCOUNT_LOGIN;
import static com.voltran.constans.Endpoints.jsonObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class SuperAdminLogin {

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");


    public SuperAdminLogin() {

        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();

    }


    public static void superAdminLogin() {


        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(ACCOUNT_LOGIN)
                .then().assertThat()
                .body("hasError", is(false))
                .body("result.message", containsString("Welcome admin"))
                .statusCode(200).log().all();
    }


    public static void superAdminInvalidUserNameOrPassword() {

        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(ACCOUNT_LOGIN)
                .then().assertThat()
                .body("errors", hasItem("Invalid Username or Password"))
                .body("hasError", is(true))
                .statusCode(400).log().all();
    }


}
