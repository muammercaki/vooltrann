Feature:
  Super Admin login success and failure scenarios

  Scenario: Üye olan tüm kullanıcıların listelenmesi
    Given I perform POST operation for "/post"
    When base urle gidildiğinde
    Then user list