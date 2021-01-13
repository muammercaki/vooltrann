package com.voltran.steps.user;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeneratePasswordStep {


    @When("I enter valid {string} generate password")
    public void iEnterValidEmailGeneratePassword(String email) {
        GeneratePassword.json(email);
    }

    @Then("I should see my new password in the mail")
    public void iShouldSeeMyNewPasswordInTheMail() {
        GeneratePassword.successGeneratePassword();
    }


    @Then("I should get the user not found error")
    public void iShouldGetTheUserNotFoundError() {
        GeneratePassword.userNotFoundGeneratePassword();
    }

    @Then("Please enter a valid email address. I should see the warning")
    public void pleaseEnterAValidEmailAddressIShouldSeeTheWarning() {
        GeneratePassword.inValidEmailGeneratePassword();
    }

    @Then("I should see email value cannot be empty")
    public void iShouldSeeEmailValueCannotBeEmpty() {
        GeneratePassword.emptyEmailGeneratePassword();
    }
}
