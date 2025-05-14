package com.library.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/featurefiles",
glue="stepDefinitions", tags="@Smoke",
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: ",
		"html:target/HTMLReports/cucumber.html",
		"json:target/jsonReports/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {

	
	
}
