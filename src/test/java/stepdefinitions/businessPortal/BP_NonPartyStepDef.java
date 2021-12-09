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

	@And("User clicks on {string} on {string}")
	public void user_clicks_on_on(String string, String string2) throws InterruptedException {
		assertTrue(bp_NonPartyPage.navigateToCreatePersonalOrder());
		logger.info("User has clicked on "+string+" on "+string2+" ");
	}
	
	

}
