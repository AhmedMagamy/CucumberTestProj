#Authoer : Ahmed Agamy
Feature: Count Questions in Worksheet

  @login
  Scenario: Search for lesson and count the questions in the worksheet of that lesson
    Given User opened Nagwa website
    When user choose the language
    And user search for lesson
    And user select the second lesson
    And user click the preview of the worksheet of that lesson
    Then print the number of question that the user found