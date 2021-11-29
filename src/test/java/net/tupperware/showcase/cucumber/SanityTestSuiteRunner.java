package net.tupperware.showcase.cucumber;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/StagingSmokeSuite/SanityTestSuite.feature"}, tags = {"@SANITYTESTSUIT"}, monochrome = true)

public class SanityTestSuiteRunner {

}
