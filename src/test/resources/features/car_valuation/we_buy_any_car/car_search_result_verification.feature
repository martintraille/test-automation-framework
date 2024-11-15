Feature: Car valuation checks

  Scenario: Check for car value
    Given an input file containing car registrations
    When a valuation search by registration is done on webuyanycar.com
    Then the user should see a search result
