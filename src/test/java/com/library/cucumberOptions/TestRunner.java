package com.library.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/featurefiles",
glue="stepDefinitions", tags="@Sanity")
public class TestRunner extends AbstractTestNGCucumberTests {

	
	
}
