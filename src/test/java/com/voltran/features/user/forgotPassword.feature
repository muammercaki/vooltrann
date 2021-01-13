Feature: Authentication
  In order to protect my assets stored within a system
  As any user
  I would like to be verified as the rightful owner of those assets through authentication

  Scenario Outline: Authenticated user within the system
    Given I perform POST operation for "/post"
    When I enter valid <email>
    Then I should see that the mail is received
    Examples:
      | email                                  |
      | "mcaki@hurriyet.com" |

  Scenario: Emty email user not authenticated within the system
    Given I perform POST operation for "/post"
    Then I should see the error message when the email field is empty

  Scenario: Invalid email user not authenticated within the system
    Given I perform POST operation for "/post"
    Then I should see the error message when the email field is invalid

  Scenario: Not Found email user not authenticated within the system
    Given I perform POST operation for "/post"
    Then I should see the error message when the email field is not found