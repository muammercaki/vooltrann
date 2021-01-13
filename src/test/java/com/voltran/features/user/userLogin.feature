Feature:
  User login success and failure scenarios

  Scenario Outline: Verify Parameter of IDP user successful login
    Given I perform POST operation for "/post"
    When Enter valid <email> and <password>
    Then I should see that is user login is successful
    Examples:
      | email                   | password  |
      | "mcaki@hurriyet.com.tr" | "test123" |