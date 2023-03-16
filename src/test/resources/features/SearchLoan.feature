@searchLoans @regression
Feature: Searching loans
  This feature validates some scenarios about searching loans

  Background: User is Logged In
    Given    User navigates to LoanPro Portal

  Scenario: Search loans and validate controls
    When    I validate login controls are visible
    Then    I login with default credentials
    Then    Validate menu bar has these controls
      | title      |
      | user image |
      | loan link  |
    And    Validate loan manager page has has these controls
      | new loan button |
      | reports icon    |
    Then  select loan status equal to "Approved"
    Then  validate summary accounts is equal to 5
    And   validate loan sub status equal to "Approved" for 5 rows