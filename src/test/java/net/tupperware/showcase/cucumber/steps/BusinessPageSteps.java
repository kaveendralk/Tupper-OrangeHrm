package net.tupperware.showcase.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.tupperware.showcase.cucumber.steps.serenity.SerenityBusinessDashboardSteps;
import net.tupperware.showcase.cucumber.steps.serenity.SerenityBusinessSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")

public class BusinessPageSteps {

	@Steps
	SerenityBusinessSteps serenitybusinesssteps;
	
	@And("I navigate to Business dashboard page")
	public void deldot_inspector_login() throws Exception {
		assertTrue(serenitybusinesssteps.navigateToBusinessDashboardPage());
	}
	
	@And("I navigate to each personal report and verify pages are loading correctly")
	public void navigateToPersonalReportsAndVerify() throws Exception {
		assertTrue(serenitybusinesssteps.navigateToPersonalReportsAndVerify());
	}
	
	@And("I navigate to Personal web site page")
	public void navigateToPersonalWebSite() throws Exception {
		assertTrue(serenitybusinesssteps.navigateToPersonalWebSite());
	}
	
}
