package stepdefinitions.older;

import cucumber.api.java.en.And;
import pages.older.SerenityBusinessSteps;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;

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
