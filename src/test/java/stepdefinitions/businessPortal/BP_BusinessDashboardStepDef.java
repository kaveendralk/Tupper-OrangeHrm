package stepdefinitions.businessPortal;

import cucumber.api.PendingException;
import groovy.util.logging.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import pages.businessPortal.BP_BusinessDashboardPage;
import pages.businessPortal.BP_HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class BP_BusinessDashboardStepDef {
    Logger logger= LogManager.getLogger(BP_BusinessDashboardStepDef.class);

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



    @And("User verify that year end report summary are loading correctly")
    public void navigateToYearEndReportAndVerify() throws Exception {
        HashMap<String, Boolean> map= bp_businessDashboardPage.yearEndReportLoaded();
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
