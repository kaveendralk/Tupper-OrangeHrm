package net.tupperware.showcase.cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.tupperware.showcase.cucumber.pages.SalesPage;

@SuppressWarnings("serial")

public class SerenitySalesSteps extends ScenarioSteps {

	SalesPage salespage;
	 	
	@Step
   	public boolean createPersonalOrder(String itemCode, String fName, String sName, String address1, String city, String postalCode, String cardNo, String cvn, String month, String year, String state) throws Exception {
   		return salespage.createPersonalOrder(itemCode, fName, sName, address1, city, postalCode, cardNo, cvn, month, year, state);
	}
	
	@Step
   	public boolean createParty(String fName, String email, String phone, String address1, String city, String postalCode, String eventName, String cardNo, String cvn, String month, String year, String state) throws Exception {
   		return salespage.createParty(fName, email, phone, address1, city, postalCode, eventName, cardNo, cvn, month, year, state);
	}
	
	 
}