package com.voltran.steps.user;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordStep {




    @Then("I should see the error message when the email field is empty")
    public void iShouldSeeTheErrorMessageWhenTheEmailFieldIsEmpty() {
        Authentication.emtyEmailForgotPassword();
    }

    @Then("I should see the error message when the email field is invalid")
    public void iShouldSeeTheErrorMessageWhenTheEmailFieldIsInvalid() {

        Authentication.invalidEmailForgotPassword();
    }

    @Then("I should see the error message when the email field is not found")
    public void iShouldSeeTheErrorMessageWhenTheEmailFieldIsNotFound() {

        Authentication.notFoundEmailForgotPassword();
    }

    @When("I enter valid {string}")
    public void iEnterValidEmailAndValidPassword(String email) {
        Authentication.json(email);
    }

    @Then("I should see that the mail is received")
    public void iShouldSeeThatTheMailIsReceived() {
        Authentication.successforgotPassword();
    }


}
