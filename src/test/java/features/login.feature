Feature: Login functionality

  Background: As a user of the system
  I want to log in with my valid credentials
  So that I can access the dashboard

  @login
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When User enters valid credentials
    Then User is redirected to the Dashboard

  @login
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid "<username>" or "<password>"
    Then an error message "Invalid username or password" should be displayed
    Examples:
      | username | password |
      | jaiswal  | Hariom   |
      | Rahul    | JaiHo    |



