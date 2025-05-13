package stepDefinitions;

import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ScenarioContext;

public class CommonStepDefinition {
	private ScenarioContext  scenarioContext;
	
	public CommonStepDefinition(ScenarioContext scenarioContext) {
		this. scenarioContext= scenarioContext;
	}
	
	
	@Given("library baseUrl is available")
	public void library_base_url_is_available() {
		String baseUrl=ApiResources.LibraryManagementBaseUrl.getResource();
		scenarioContext.setBaseUrl(baseUrl);
	}
	
	@Then("the status code should be {string}")
	public void the_status_code_should_be(String expectedStatusCode) {
		scenarioContext.getResponse().then().log().all().assertThat().statusCode(Integer.parseInt(expectedStatusCode));
	}
}
