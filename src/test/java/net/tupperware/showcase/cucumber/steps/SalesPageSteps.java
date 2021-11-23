package net.tupperware.showcase.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.tupperware.showcase.cucumber.steps.serenity.SerenitySalesSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")

public class SalesPageSteps {

	@Steps
	SerenitySalesSteps serenitysalessteps;
	
	@Then("I create personal order (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
	public void createPersonalOrder(String itemCode, String fName, String sName, String address1, String city, String postalCode, String cardNo, String cvn, String month, String year, String state) throws Exception {
		assertTrue(serenitysalessteps.createPersonalOrder(itemCode, fName, sName, address1, city, postalCode, cardNo, cvn, month, year, state));
	}
	
	@Then("I create a party order by adding a host (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
	public void createParty(String fName, String email, String phone, String address1, String city, String postalCode, String eventName, String cardNo, String cvn, String month, String year, String state) throws Exception {
		assertTrue(serenitysalessteps.createParty(fName, email, phone, address1, city, postalCode, eventName, cardNo, cvn, month, year, state));
	}
	
}