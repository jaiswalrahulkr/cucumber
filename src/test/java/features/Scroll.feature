Feature: Scroll Feature

  Background:
    Given the user is on the login page

  @scroll
  Scenario: Test the scroll fuctionality
    When click on Home Button
    And Navigate to Home page
    Then Scroll to the bottom of the page

  @dropdown
  Scenario: Test the Dropdown functionality
    When select the option2 from dropdown
    And check Option2 in checkbox
    Then select Radio2 from Radio list

  @window
  Scenario: Test the Tab Handling functionality
    When click on open Tab button
    And Switch to new Tab or Window
    Then Verify the Page "QAClick Academy - A Testing Academy to Learn, Earn and Shine"


  Scenario: Test the Window Handling Functionality
    When click on open Window button
    And  Switch to new Tab or Window
    Then Verify the Page "QAClick Academy - A Testing Academy to Learn, Earn and Shine"


  Scenario: Handle the Alert Popup
    When click on "Alert" button
    And verify the alert message "Hello , share this practice page and share your knowledge"
    Then Click on  alert "OK" button

  Scenario: Handle the Alert Popup and click on cancel button
    When click on "Confirm" button
    And verify the alert message "Hello , Are you sure you want to confirm?"
    Then Click on  alert "CANCEL" button





