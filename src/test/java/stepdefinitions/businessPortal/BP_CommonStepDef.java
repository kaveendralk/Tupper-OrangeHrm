package stepdefinitions.businessPortal;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.businessPortal.BP_BusinessDashboardPage;
import pages.businessPortal.BP_HomePage;

public class BP_CommonStepDef {

    Logger logger= LoggerFactory.getLogger(BP_CommonStepDef.class);
    @Steps
    BP_HomePage bp_homePage;

    @Steps
    BP_BusinessDashboardPage bp_businessDashboardPage;

    @Then("User navigates to {string} page")
    public void user_navigates_to_page(String pageName) throws PendingException {
        switch(pageName){
            case "Home":
                Assert.assertTrue("User is not navigated to "+pageName+" page", bp_homePage.navigateToPage());
                break;
            case "Business Dashboard":
//                bp_businessDashboardPage.navigateToPage();
            default:

        }
    }

    @And("User clicks on {string} on {string} page")
    public void user_clicks_on_on_page(String elementName, String pageName) throws PendingException {
        switch (pageName) {
            case "Home":
                bp_homePage.clicktoElement(elementName);
                logger.info("User has clicked +" + elementName + " on " + pageName + " page");
                break;
            case "Business Dashboard":
//                bp_businessDashboardPage.clicktoElement();
                logger.info("User has clicked +" + elementName + " on " + pageName + " page");
                break;
        }
    }

    @And("User verify {string} on {string} page")
    public void user_verify_on_page(String elements, String pageName) throws PendingException {
        switch (pageName) {
            case "Home":
               Assert.assertTrue("Various elements "+elements+" are available in the"+pageName+ " page",bp_homePage.verifyVariousElements(elements));
                logger.info("User has verified various "+elements+" on"+pageName+" page");
                break;
            case "Business Dashboard":
//                 Assert.assertTrue("Various elements "+elements+" are available in the"+pageName+ " page",bp_businessDashboardPage.verifyVariousElements(elements));
//                logger.info("User has verified various "+elements+" on"+pageName+" page");
//                break;
        }

    }


}