Feature: Test case regarding add Book
  
  @Smoke
  Scenario: verify user is able to add a single book
    Given library baseUrl is available
    When user sends request to add book with unique creds
    Then the status code should be "200"
    And response should contain message "successfully added"
    
    
    
    

  