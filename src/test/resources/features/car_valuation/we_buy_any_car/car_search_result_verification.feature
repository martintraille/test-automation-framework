Feature: Car valuation checks - We buy any car

  Scenario: Check for car valuations
    Given a list of car registrations extracted from an input file
    When a valuation search by registration is done on webuyanycar.com
    Then the user should see a search result
