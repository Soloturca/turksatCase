Feature: Creating Bill

  @Test
  Scenario: Create Bill Test
    Given Check file exist
    When Connect to server
    And Move old file to backup
    And Connect to run server
    And Run sh files
    Then Move xlog file