package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import enums.ApiResources;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import specBuilders.CreateSpecs;
import utils.ParseJson;
import utils.ScenarioContext;

public class GetBookStepDefinition {
	

	
	private ScenarioContext  scenarioContext;
	 
	public GetBookStepDefinition(ScenarioContext  scenarioContext) {
		this.scenarioContext=scenarioContext;
	}
	

	@Then("user sends get request to grab book using ID")
	public void user_sends_get_request_to_grab_book_using_id() {
		String bookID=scenarioContext.getBookID();
		Response bookDetail = given().spec(CreateSpecs.makeRequestSpec(ApiResources.LibraryManagementBaseUrl.getResource(), ContentType.JSON)).queryParam("ID", bookID).when().get(ApiResources.getBook.getResource()).then().log().all().extract().response();
		scenarioContext.setResponse(bookDetail);
	}
	@Then("verify user is able to retrive same data sent while creating book")
	public void verify_user_is_able_to_retrive_same_data_sent_while_creating_book() {
		String addedBook=scenarioContext.getResponse().asString();
		String actualIsbn=ParseJson.parseJsonString(addedBook).getList("isbn").get(0).toString();
		String actualAisle=ParseJson.parseJsonString(addedBook).getList("aisle").get(0).toString();
		String actualBookId= actualIsbn+actualAisle;
		Assert.assertEquals(actualBookId, scenarioContext.getBookID());
		
	}
	
	
	
	

	
	
	
}
