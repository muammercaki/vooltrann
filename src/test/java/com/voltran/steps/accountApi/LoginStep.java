package com.voltran.steps.accountApi;

import com.voltran.constans.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStep {


    @Given("I perform POST operation for {string}")
    public void iPerformPOSTOperationFor(String arg0) {
    }

    @When("Enter {string} and {string}")
    public void enterEmailAndPassword(String email, String password) {
        Endpoints.json(email,password);
    }

    @Then("I should see that is super admin login is successful")
    public void iShouldSeeThatIsSuperAdminLoginIsSuccessful() {
        SuperAdminLogin.superAdminLogin();
    }


    @Then("I should see that it cannot login")
    public void iShouldSeeThatItCannotLogin() {
        SuperAdminLogin.superAdminInvalidUserNameOrPassword();
    }


}
