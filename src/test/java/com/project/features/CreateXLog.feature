Feature: Creating Bill

  @Test
  Scenario: Create Bill Test
    Given Check xml file exist
    And Set commands
    When Move old file to backup
    And Remove old xlog files
    And Copying xml file to server
    And Run commands
    Then Check xlog file