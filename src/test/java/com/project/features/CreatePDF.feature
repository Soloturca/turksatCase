Feature: Creating Bill

  @Test
  Scenario: Convert XLog to PDF
    Given Check xlog file exist
    When Remove data folder
    And Remove dataC folder
    And Remove pdf folder
    And Run bat file
    Then Check pdf file