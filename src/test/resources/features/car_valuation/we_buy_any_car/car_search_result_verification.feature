Feature: Car valuation checks - We buy any car

  Scenario: Check for car valuations
    Given an input file containing car registrations
    When a valuation search by registration is done on webuyanycar.com
    Then the user should see a search result
