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

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class BP_BusinessDashboardStepDef {

    Logger logger= LoggerFactory.getLogger(BP_BusinessDashboardStepDef.class);

    @Steps
    BP_BusinessDashboardPage bp_businessDashboardPage;

    @Then("User click each report tab and validate reports are loading correctly")
    public void checkReportsLoading() throws Exception {
        Assert.assertTrue("Reports are not loading correctly.", bp_businessDashboardPage.verifyReportAreLoading());
    }

    @And("User verify that Payment Summary are loading correctly")
    public void navigateToPaymentSummaryAndVerify() throws Exception {
        HashMap<String, Boolean> map= bp_businessDashboardPage.paymentSummaryReportLoaded();
        for(String key: map.keySet()){
            if(!map.get(key)){
            }
            Assert.assertTrue(key, map.get(key));
        }
    }

    @And("User verify that personal history are loading correctly")
    public void navigateToPersonalHistoryAndVerify() throws Exception {
        HashMap<String, Boolean> map= bp_businessDashboardPage.personalHistoryReportLoaded();
        for(String key: map.keySet()){
            if(!map.get(key)){
            }
            Assert.assertTrue(key, map.get(key));
        }
    }






//    @And("I navigate to Business dashboard page")
//    public void deldot_inspector_login() throws Exception {
//        assertTrue(serenitybusinesssteps.navigateToBusinessDashboardPage());
//    }
//
//
//    @And("I navigate to Personal web site page")
//    public void navigateToPersonalWebSite() throws Exception {
//        assertTrue(serenitybusinesssteps.navigateToPersonalWebSite());
//    }

//    @cucumber.api.java.en.Then("I navigate to Create personal order page")
//    public void navigateToCreatePersonalOrderPage() throws Exception {
//        assertTrue(serenitybusinessdashboardsteps.navigateToCreatePersonalOrderPage());
//    }
//
//    @cucumber.api.java.en.Then("I navigate to party order page")
//    public void navigateToCreateParty() throws Exception {
//        assertTrue(serenitybusinessdashboardsteps.navigateToCreateParty());
//    }
}
