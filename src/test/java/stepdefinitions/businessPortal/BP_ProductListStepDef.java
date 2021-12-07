package stepdefinitions.businessPortal;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import pages.businessPortal.BP_ProductListPage;

public class BP_ProductListStepDef {
	
	Logger logger= LoggerFactory.getLogger(BP_ProductListStepDef.class);

	@Steps
	BP_ProductListPage bp_ProductListPage;
	
	@Then("{string} overlay is opened")
	public void overlay_is_opened(String string) throws InterruptedException {
		assertTrue(bp_ProductListPage.verifytheProductOverlayPage());
	    logger.info("User has clicked on  ");
	}

	
	@And("User verify that correct product is added")
	public void user_verify_that_correct_product_is_added() throws InterruptedException {
		assertTrue(bp_ProductListPage.verifytheAddedProduct());
	    logger.info("User has clicked on  ");
	}

	

	

}
