package com.voltran.steps.user;

import com.voltran.utils.ConfigManager;
import io.restassured.RestAssured;
import org.json.JSONObject;

import static com.voltran.constans.Endpoints.GENERATE_PASSWORD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

public class GeneratePassword {

    public static String jsonObject;

    public static void json(String email) {

        jsonObject = new JSONObject()
                .put("email", email).toString();
    }

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");

    public GeneratePassword() {

        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();

    }


    public static void successGeneratePassword(){

        given()
                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(GENERATE_PASSWORD)
                .then().assertThat()
                .body("hasError", is(false))
                .statusCode(200).log().all();
    }


    public static void userNotFoundGeneratePassword(){

        given()
                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(GENERATE_PASSWORD)
                .then().assertThat()
                .body("hasError", is(true))
                .body("errors",hasItem("User not found."))
                .statusCode(400).log().all();
    }

    public static void inValidEmailGeneratePassword(){

        given()
                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(GENERATE_PASSWORD)
                .then().assertThat()
                .body("hasError", is(true))
                .body("errors",hasItem("FieldName: Email , Message: Geçerli bir eposta adresi giriniz."))
                .statusCode(400).log().all();
    }

    public static void emptyEmailGeneratePassword(){

        given()
                .contentType("application/json")
                .when()
                .with()
                .body(jsonObject)
                .post(GENERATE_PASSWORD)
                .then().assertThat()
                .body("hasError", is(true))
                .body("errors",hasItem("FieldName: Email , Message: Eposta değeri boş olamaz."))
                .statusCode(400).log().all();
    }
}
