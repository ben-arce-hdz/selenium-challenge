package com.selenium.uiautomation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "classpath:features", 
glue = "com.selenium.uiautomation",
plugin = {"pretty", "json:target/cucumber.json" }, 
monochrome = true, snippets = SnippetType.CAMELCASE)
public class CucumberRunner extends AbstractTestNGCucumberTests {

	/**
	 * This method is used for enabling/disabling Parallel Execution.
	 */
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
