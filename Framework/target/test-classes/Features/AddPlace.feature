Feature: validating place Apis

Scenario Outline: verify if new place is added successfully using AddPlace api

  Given Add place payload "<name>" "<language>" "<address>"
  When user calls Add Api with post http request
  Then the API call got success with status code 200
  And "status" in response body is "OK"
  And "scope" in response body is "APP"
 
 
  Examples:
      |name   | language   | address   |
      |Demo   |English     | India 29  |