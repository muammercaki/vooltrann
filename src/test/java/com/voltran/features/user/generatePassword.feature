Feature: Authentication
  To protect my assets stored in a system
  As any user
  I want to receive e-mail via password renewal

  Scenario Outline:Generate Authenticated user within the system
    Given I perform POST operation for "/post"
    When I enter valid <email> generate password
    Then I should see my new password in the mail
    Examples:
      | email                   |
      | "mcaki@hurriyet.com.tr" |


  Scenario Outline: Send mail for invalid email
    Given I perform POST operation for "/post"
    When I enter valid <email> generate password
    Then Please enter a valid email address. I should see the warning
    Examples:
      | email   |
      | "mcaki" |

  Scenario Outline: Send mail for empty email
    Given I perform POST operation for "/post"
    When I enter valid <email> generate password
    Then  I should see email value cannot be empty
    Examples:
      | email   |
      | " " |