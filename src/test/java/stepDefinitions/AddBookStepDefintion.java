package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Book;
import specBuilders.CreateSpecs;
import utils.ParseJson;
import utils.ScenarioContext;
import utils.UniqueGenerator;

	
public class AddBookStepDefintion {
	
	 private ScenarioContext  scenarioContext;
 
	public AddBookStepDefintion(ScenarioContext  scenarioContext) {
		this.scenarioContext= scenarioContext;
	}

	@When("user sends request to add book with unique creds")
	public void user_sends_request_to_add_book_with_unique_creds() {
		String bookName= UniqueGenerator.getFaker().book().title();
		String isbn = UniqueGenerator.getUniqueString();
		String aisle = Integer.toString(UniqueGenerator.getRandomNumber());
		String author=UniqueGenerator.getFaker().book().author();
		Book book = new Book(bookName, isbn, aisle, author);
		
	   Response addBookResponse = given().log().all().spec(CreateSpecs.makeRequestSpec(scenarioContext.getBaseUrl(), ContentType.JSON))
		.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();
	    
	    String bookId=ParseJson.parseJsonString(addBookResponse.asString()).get("ID");
	    scenarioContext.setResponse(addBookResponse);
	    scenarioContext.setBookID(bookId);
	    
	}

	@Then("response should contain message {string}")
	public void response_should_contain_message(String expecetedMsg) {
		 scenarioContext.getResponse().then().log().all().assertThat().body("Msg", equalTo(expecetedMsg));
	}
	
	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		Book book = new Book(bookName, isbn, aisle+ Integer.toString(UniqueGenerator.getRandomNumber()), author);
		Response addBookResponse = given().log().all().spec(CreateSpecs.makeRequestSpec(scenarioContext.getBaseUrl(), ContentType.JSON))
				.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();
		scenarioContext.setResponse(addBookResponse);
	}


}
