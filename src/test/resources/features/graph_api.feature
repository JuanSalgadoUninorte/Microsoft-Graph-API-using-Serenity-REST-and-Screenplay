#language: en
  #author: Juan Salgado
Feature: Microsoft Graph Api
  As a user of Microsoft Outlook and Microsoft Graph API,
  I want to get the last email received,
  So that I can get more experience working withMicrosoft Graph PAI

  @getEmail
  Scenario Outline: Get last email received
    Given The access to the API
    When The request to the API
      | waitedStatus   |
      | <waitedStatus> |
    Then Get a response with an status code 200
    Examples:
      | waitedStatus |
      | 200          |