@login
Feature: Login
  The main purpose of this feature is to make sure Login function works
  correctly and allows user to log in with valid credentials only.

  Scenario: new user registers with valid credentials.
    Given Web site is opened
    When User types valid email
    And Click Enter button
    And User types valid password
    And Click RegisterWithEmail button
    Then User gets home page
