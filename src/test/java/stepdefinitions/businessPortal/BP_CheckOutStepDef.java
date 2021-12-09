package stepdefinitions.businessPortal;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.businessPortal.BP_CheckOutPage;


public class BP_CheckOutStepDef {
	
	Logger logger= LoggerFactory.getLogger(BP_CheckOutStepDef.class);

	@Steps
	BP_CheckOutPage bp_CheckOutPage;
	
	@And("User clicks on Checkout button")
	public void user_clicks_on_Checkout_button() throws InterruptedException {
		assertTrue(bp_CheckOutPage.clickOnCheckOutbuttonAndVerify());
	}

	@And("User verify that Add Payment button is displayed and Click")
	public void user_verify_that_Add_Payment_button_is_displayed_and_Click() throws InterruptedException {
		assertTrue(bp_CheckOutPage.clickOnPaymentButtonAndVerify());
	}

	@Then("verify Payment Options overlay is opened")
	public void verify_Payment_Options_overlay_is_opened() throws InterruptedException {
		assertTrue(bp_CheckOutPage.clickOnPaymentOptionsAndVerify());
	}

}
