package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.net.HttpURLConnection;

import enums.ApiResources;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import specBuilders.CreateSpecs;
import utils.PayLoad;
import utils.ScenarioContext;

public class DeleteBookStepDefintion {

	private ScenarioContext  scenarioContext;
	public DeleteBookStepDefintion (ScenarioContext	scenarioContext) {
		this. scenarioContext= scenarioContext;
	}
	
	@Then("user sends delete request to delete book using ID")
	public void user_sends_delete_request_to_delete_book_using_id() {
		String bookID = scenarioContext.getBookID();
		
		Response deleteBookResponse=given().log().all().spec(CreateSpecs.makeRequestSpec(scenarioContext.getBaseUrl(), ContentType.JSON))
		.body(PayLoad.deleteBookPayLoad(bookID)).
		when().delete(ApiResources.deleteBook.getResource())
		.then().log().all().spec(CreateSpecs.makeResponseSpec(HttpURLConnection.HTTP_OK)).extract().response();
		
		scenarioContext.setResponse(deleteBookResponse);
		
		
//		.body("msg",equalTo("book is successfully deleted"));
	}
	
	 
}
