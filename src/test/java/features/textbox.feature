Feature:

  Background: Test the TextBox Functionality

  @textBox
  Scenario Outline: Test the TextBox Functionality
    Given I open the Browser and navigate to the URL
    When I click on TextBox Link
    And I enter "<Field>" and "<values>" in the TextBox from the below
    Then click on Submit Button
    Examples:
      | Field           | values          |
      | First Name      | John            |
      | Last Name       | Doe             |
      | Email           | hghbj@gmail.com |
      | Current Address | 1234567890      |
      | New Password    | 1234567890      |

