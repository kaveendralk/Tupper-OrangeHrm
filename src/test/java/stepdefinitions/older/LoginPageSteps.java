package stepdefinitions.older;

import cucumber.api.java.en.Given;
import pages.older.SerenityLoginSteps;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings("unused")

public class LoginPageSteps {

	@Steps
	SerenityLoginSteps serenityLoginSteps;
	
	@Given("Consultant login to the application with valid (.*) and (.*)")
	public void deldot_inspector_login(String userName, String password) throws Exception {
		serenityLoginSteps.tupper_consultant_user_login(userName, password);
	}
	
}