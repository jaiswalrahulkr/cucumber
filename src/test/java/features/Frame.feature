Feature: Test the Frame features

  Background:
    Given the user is on the login page

  @frame
  Scenario: Test the Switching of frame
    When Switch to new frame
    And Scroll to the bottom of the page and verify the Text "JOIN OUR ACADEMY"
    And Switch back to main content
    Then click on open Window button

  @mouse
  Scenario: Test the MouseHover Functionality
    When MouseHover on MouseHover bottom
    And click on "Reload"

  @DragAndDrop
  Scenario: Test the Drag and drop feature
    When pick one element and drag and drop in another box


  @FileUpload
  Scenario: File Upload Scenario
    When click on broswer and upload the file
    And click on Upload button
    Then verify the success message "File Uploaded!"

    @JQueryUIMenu
    Scenario: Move from one element to another Element
      When Hover On "Enabled" then "Downloads" and then click on "PDF"


@ShadowDOm
Scenario: Handle Shadow DoM
  When get the texts of shadow Dom


