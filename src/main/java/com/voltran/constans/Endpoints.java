package com.voltran.constans;

import org.json.JSONObject;

public class Endpoints {
    public static String jsonObject;

    public static final String ACCOUNT_LOGIN = "/api/v1/AccountApi/Login";
    public static final String FORGOT_PASSWORD = "/api/v1/posta/AccountApi/ForgotPassword";
    public static final String GENERATE_PASSWORD = "/api/v1/posta/AccountApi/GeneratePassword";
    public static final String USER_LOGIN = "/v1/posta/AccountApi/Login";
    public static final String USERS_LIST = "/api/v1/posta/AccountApi/List";


    public static void json(String email, String password) {

        jsonObject = new JSONObject()
                .put("email", email)
                .put("password", password).toString();
    }
}
