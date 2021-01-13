package com.voltran.steps.user;

import com.voltran.utils.ConfigManager;
import io.restassured.RestAssured;
import org.json.JSONObject;

import static com.voltran.constans.Endpoints.FORGOT_PASSWORD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Authentication {
    public static String jsonObject;

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");

    public static void json(String email) {

        jsonObject = new JSONObject()
                .put("email", email).toString();
    }

    public Authentication(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static void successforgotPassword() {

        given()
                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(FORGOT_PASSWORD)
                .then().assertThat()
                .body("hasError", is(false))
                .statusCode(200).log().all();
    }

    public static void emtyEmailForgotPassword() {
        given()
                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(FORGOT_PASSWORD)
                .then().assertThat()
                .body("hasError", is(true))
                .body("errors", hasItem("FieldName: Email , Message: Eposta değeri boş olamaz."))
                .statusCode(400).log().all();
    }

    public static void invalidEmailForgotPassword() {

        given()
                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(FORGOT_PASSWORD)
                .then().assertThat()
                .body("hasError", is(true))
                .body("errors", hasItem("FieldName: Email , Message: Geçerli bir eposta adresi giriniz."))
                .statusCode(400).log().all();
    }


    public static void notFoundEmailForgotPassword() {

        given()

                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(FORGOT_PASSWORD)
                .then().assertThat()
                .body("hasError", is(true))
                .body("errors", hasItem("Kullanıcı bulunamadı."))
                .statusCode(400).log().all();
    }
}
