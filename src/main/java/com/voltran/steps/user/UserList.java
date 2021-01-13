package com.voltran.steps.user;

import com.voltran.model.AcountUserList;
import com.voltran.utils.ConfigManager;
import io.restassured.RestAssured;

import static com.voltran.constans.Endpoints.USERS_LIST;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserList {

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");


    public UserList(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static void postListUser() {

        AcountUserList acountUserList = new AcountUserList();
        acountUserList.setGetPageCount(true);
        acountUserList.setPage(1);
        acountUserList.setPageSize(10);
        acountUserList.setDescending(true);


        given().log().all()
                .contentType("application/json")
                .when()
                .with()
                .body(acountUserList)
                .post(USERS_LIST)
                .then()
                .assertThat()
                .body("hasError", is(false))
                .statusCode(200).log().all();

    }

}
