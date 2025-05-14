Feature: Test case regarding Delete Book
  
  @Smoke
  Scenario: verify user is able to delete book using ID
    Given library baseUrl is available
    When user sends request to add book with unique creds
    Then user sends delete request to delete book using ID
    Then the status code should be "200"
    And response should contain message "book deleted successfully"
    
