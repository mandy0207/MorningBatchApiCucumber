package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import pojo.Book;
import specBuilders.CreateSpecs;
import utils.UniqueGenerator;

	
public class AddBookStepDefintion {

	public static Response addBookResponse;
	
	@Given("library baseUrl is available")
	public void library_base_url_is_available() {
		RestAssured.baseURI = "http://216.10.245.166";
	}

	@When("user sends request to add book with unique creds")
	public void user_sends_request_to_add_book_with_unique_creds() {
		String bookName= UniqueGenerator.getFaker().book().title();
		String isbn = UniqueGenerator.getUniqueString();
		String aisle = Integer.toString(UniqueGenerator.getRandomNumber());
		String author=UniqueGenerator.getFaker().book().author();
		Book book = new Book(bookName, isbn, aisle, author);
		
	    addBookResponse = given().log().all().spec(CreateSpecs.makeRequestSpec(ApiResources.LibraryManagementBaseUrl.getResource(), ContentType.JSON))
		.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();
	}

	@Then("the status code should be {string}")
	public void the_status_code_should_be(String expectedStatusCode) {
		addBookResponse.then().log().all().assertThat().statusCode(Integer.parseInt(expectedStatusCode));
	}

	@Then("response should contain message {string}")
	public void response_should_contain_message(String expecetedMsg) {
		   addBookResponse.then().log().all().assertThat().body("Msg", equalTo(expecetedMsg));
	}
	
	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		Book book = new Book(bookName, isbn, aisle+ Integer.toString(UniqueGenerator.getRandomNumber()), author);
		addBookResponse = given().log().all().spec(CreateSpecs.makeRequestSpec(ApiResources.LibraryManagementBaseUrl.getResource(), ContentType.JSON))
				.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();
	}


}
