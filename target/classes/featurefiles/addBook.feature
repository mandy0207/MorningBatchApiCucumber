Feature: Test case regarding add Book
  
  @Smoke
  Scenario: verify user is able to add a single book
    Given library baseUrl is available
    When user sends request to add book with unique creds
    Then the status code should be "200"
    And response should contain message "successfully added"
    
  @Smoke @Reg  
 Scenario Outline: Verify Book Addition using Data Parametrisation
     Given library baseUrl is available
     When user sends post request to add book with "<bookName>" "<isbn>" "<aisle>" "<author>"
     Then the status code should be "200"
     And response should contain message "successfully added"
  Examples:
  |  bookName              |    isbn   | aisle  |  author  |
  | Rest Assured Solutions | surumi    | 12340  |  Sam     |
  | Appium Solutions       | shabana   | 00980  |  Ingrid  |
  | Tosca Challenges       | tosca     |000000  |  Pooja   |