package net.tupperware.showcase.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.tupperware.showcase.cucumber.steps.serenity.SerenityBusinessDashboardSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")

public class BusinessDashboardPageSteps {

	@Steps
	SerenityBusinessDashboardSteps serenitybusinessdashboardsteps;
	
	@Then("I click each report tab and validate reports are loading correctly")
	public void checkReportsLoadinga() throws Exception {
		assertTrue(serenitybusinessdashboardsteps.checkReportsLoading());
	}
	
	@Then("I navigate to Create personal order page")
	public void navigateToCreatePersonalOrderPage() throws Exception {
		assertTrue(serenitybusinessdashboardsteps.navigateToCreatePersonalOrderPage());
	}
	
	@Then("I navigate to party order page")
	public void navigateToCreateParty() throws Exception {
		assertTrue(serenitybusinessdashboardsteps.navigateToCreateParty());
	}
	
	 
	
}