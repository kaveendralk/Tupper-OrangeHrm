package stepdefinitions.businessPortal;



import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.cucumber.java.en.And;

import net.thucydides.core.annotations.Steps;

import pages.businessPortal.BP_NonPartyPage;

public class BP_NonPartyStepDef {

	Logger logger= LoggerFactory.getLogger(BP_HomeStepDef.class);

	@Steps
	BP_NonPartyPage bp_NonPartyPage;

	@And("User select type of order and navigate to Create Order page")
	public void user_select_type_of_order_to_create_order() throws InterruptedException {
		logger.info("User is navigating to Create Order page");
		assertTrue(bp_NonPartyPage.navigateToCreatePersonalOrder());
	}
	
	

}
