package stepdefinitions.older;

import cucumber.api.java.en.Then;
import pages.older.SerenityBusinessDashboardSteps;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;

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