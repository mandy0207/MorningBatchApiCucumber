package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBookStepDefintion {

	@Given("library baseUrl is available")
	public void library_base_url_is_available() {
		System.out.println("I am in step1");
	}

	@When("user sends request to add book with unique creds")
	public void user_sends_request_to_add_book_with_unique_creds() {
		System.out.println("I am in step2");
	}

	@Then("the status code should be {string}")
	public void the_status_code_should_be(String string) {
		System.out.println("I am in step 3");
	}

	@Then("response should contain message {string}")
	public void response_should_contain_message(String string) {
		System.out.println("I am in step4");
	}

	@Then("validate surumi is in USA")
	public void validate_surumi_is_in_usa() {
		System.out.println("Hey guys I'm in US");
	}

}
