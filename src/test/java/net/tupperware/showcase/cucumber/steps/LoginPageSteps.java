package net.tupperware.showcase.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.tupperware.showcase.cucumber.steps.serenity.SerenityLoginSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")

public class LoginPageSteps {

	@Steps
	SerenityLoginSteps serenityLoginSteps;
	
	@Given("Consultant login to the application with valid (.*) and (.*)")
	public void deldot_inspector_login(String userName, String password) throws Exception {
		serenityLoginSteps.tupper_consultant_user_login(userName, password);
	}
	
}