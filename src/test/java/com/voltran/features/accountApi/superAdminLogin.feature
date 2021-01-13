Feature:
  Super Admin login success and failure scenarios

  Scenario Outline: Verify Parameter of IDP Super Admin successful login |Başarılı giriş|
    Given I perform POST operation for "/post"
    When Enter <email> and <password>
    Then I should see that is super admin login is successful
    Examples:
      | email                                  | password       |
      | "batuhan.temiz@demirorenteknoloji.com" | "Password!123" |

  Scenario Outline: Verify IDP Super Admin failed login parameter |Boş email&şifre|
    Given I perform POST operation for "/post"
    When Enter <email> and <password>
    Then I should see that it cannot login
    Examples:
      | email | password |
      | ""    | ""       |


  Scenario Outline: Verify IDP Super Admin Invalid Email Failed Login |Geçersiz email|
    Given I perform POST operation for "/post"
    When Enter <email> and <password>
    Then I should see that it cannot login
    Examples:
      | email                              | password       |
      | "batuhan.temiz@demirorenteknoloji" | "Password!123" |

  Scenario Outline: Invalid IDP Super Admin failed login
    Given I perform POST operation for "/post"
    When Enter <email> and <password>
    Then I should see that it cannot login
    Examples:
      | email           | password     |
      | "batuhan.temiz" | "Password!1" |