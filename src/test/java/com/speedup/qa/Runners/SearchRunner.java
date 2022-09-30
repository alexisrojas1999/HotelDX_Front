package com.speedup.qa.Runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/search.feature"
        , glue = "com.speedup.qa.Stepdefinitions"
        , snippets = SnippetType.CAMELCASE)

public class SearchRunner {
}
