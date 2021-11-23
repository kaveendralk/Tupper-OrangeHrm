package net.tupperware.showcase.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.tupperware.showcase.cucumber.steps.serenity.SerenityPersonalWebsiteSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")

public class PersonalWebsitePageSteps {

	@Steps
	SerenityPersonalWebsiteSteps serenitypersonalwebsitesteps;
	
//	@And("I navigate to Business dashboard page")
//	public void deldot_inspector_login() throws Exception {
//		serenitypersonalwebsitesteps.navigateToBusinessDashboardPage();
//	}
	
	 
}
