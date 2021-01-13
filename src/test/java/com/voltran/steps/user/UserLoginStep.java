package com.voltran.steps.user;

import com.voltran.constans.Endpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginStep {


    @Then("I should see that is user login is successful")
    public void iShouldSeeThatIsUserLoginIsSuccessful() {
        UserLogin.verifyUserSuccessLogin();
    }


    @When("Enter valid {string} and {string}")
    public void enterValidEmailAndPassword(String email, String password) {
        Endpoints.json(email, password);

    }


}
