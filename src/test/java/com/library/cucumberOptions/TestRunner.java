package com.library.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/featurefiles",
glue="stepDefinitions", tags="@Reg")
public class TestRunner extends AbstractTestNGCucumberTests {

	
	
}
