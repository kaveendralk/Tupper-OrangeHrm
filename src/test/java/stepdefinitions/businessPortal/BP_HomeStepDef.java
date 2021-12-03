package stepdefinitions.businessPortal;

import cucumber.api.PendingException;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.businessPortal.BP_HomePage;

public class BP_HomeStepDef {

    Logger logger= LoggerFactory.getLogger(BP_HomeStepDef.class);
    @Steps
    BP_HomePage bp_homePage;

    @Then("User navigates to {string} page")
    public void user_navigates_to_page(String string) throws PendingException {
        bp_homePage.navigateToPage();
        logger.info("User is navigated to "+string+" page");
    }
}
