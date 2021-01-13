package com.voltran.steps.user;


import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserListStep {
    private UserList userList;

    @Before
    public void beforeScenario(){
         userList=new UserList();
    }

    @Then("user list")
    public void userList() {
        UserList.postListUser();

    }

    @When("base urle gidildiğinde")
    public void baseUrleGidildiğinde() {

    }
}
