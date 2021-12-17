package stepdefinitions.businessPortal;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.businessPortal.BP_BusinessDashboardPage;
import pages.businessPortal.BP_HomePage;
import pages.businessPortal.BP_NonPartyPage;

public class BP_CommonStepDef {

    Logger logger= LogManager.getLogger(BP_CommonStepDef.class);

    @Steps
    BP_HomePage bp_homePage;

    @Steps
    BP_BusinessDashboardPage bp_businessDashboardPage;

    @Steps
    BP_NonPartyPage bp_NonPartyPage;

    @Then("User navigate to {string} page")
    public void user_navigates_to_page(String pageName) throws Exception {
        logger.info("User is navigating to "+pageName+" page");
        switch(pageName){
            case "Home":
                Assert.assertTrue("User is not navigated to "+pageName+" page", bp_homePage.navigateToPage());
                break;
            case "Business Dashboard":
                Assert.assertTrue("User is not navigated to "+pageName+" page", bp_businessDashboardPage.navigateToPage());
                break;
            case "Create Order":
            	Assert.assertTrue("User is not navigated to "+pageName+" page", bp_NonPartyPage.navigateToPage());
                break;
            case "Personal Report: Payment Summary":
                Assert.assertTrue("User is not navigated to "+pageName+" page", bp_businessDashboardPage.paymentSummaryReportOpened());
                break;
            case "Personal Report: Personal History":
                Assert.assertTrue("User is not navigated to "+pageName+" page", bp_businessDashboardPage.personalHistoryReportOpened());
                break;
            case "Personal Report: Year End Report Summary":
                Assert.assertTrue("User is not navigated to "+pageName+" page", bp_businessDashboardPage.yearEndReportOpened());
                break;
            case "Custom Report: Contact Listing":
            case "Custom Report: Weekly Custom Report":
                Assert.assertTrue("User is not navigated to "+pageName+" page", bp_businessDashboardPage.customReportOpened());
                break;
        }
    }

    @And("User click on {string} on {string} page")
    public void user_clicks_on_on_page(String elementName, String pageName) throws PendingException, InterruptedException {
        switch (pageName) {
            case "Home":
                bp_homePage.clicktoElement(elementName);
                logger.info("User has clicked +" + elementName + " on " + pageName + " page");
                break;
            case "Business Dashboard":
//                bp_businessDashboardPage.clicktoElement();
                logger.info("User has clicked +" + elementName + " on " + pageName + " page");
                break;
            case "Sales- Create Non Party Order":
            	bp_NonPartyPage.clicktoElement(elementName);
                logger.info("User has clicked +" + elementName + " on " + pageName + " page");
                break;
           

        }
    }

    @And("User verify {string} on {string} page")
    public void user_verify_on_page(String elements, String pageName) throws PendingException {
        switch (pageName) {
//            case "Home":
//               Assert.assertTrue("Various elements "+elements+" are available in the"+pageName+ " page",bp_homePage.verifyVariousElements(elements));
//                logger.info("User has verified various "+elements+" on"+pageName+" page");
//                break;
//            case "Business Dashboard":
//                 Assert.assertTrue("Various elements "+elements+" are available in the"+pageName+ " page",bp_businessDashboardPage.verifyVariousElements(elements));
//                logger.info("User has verified various "+elements+" on"+pageName+" page");
//                break;
        }
    }

    @And("User click on {string} from side menu")
    public void user_click_on_side_menu(String elementName) throws PendingException, InterruptedException {
        bp_homePage.clicktoElement(elementName);
        logger.info("User has clicked +" + elementName + " from side menu");
    }

}
