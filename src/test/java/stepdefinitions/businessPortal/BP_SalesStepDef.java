package stepdefinitions.businessPortal;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.businessPortal.BP_SalesPage;

import static org.junit.Assert.assertTrue;

public class BP_SalesStepDef {

    @Steps
    BP_SalesPage bp_salesPage;

//    @io.cucumber.java.en.Then("I create personal order (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
//    public void createPersonalOrder(String itemCode, String fName, String sName, String address1, String city, String postalCode, String cardNo, String cvn, String month, String year, String state) throws Exception {
//        assertTrue(serenitysalessteps.createPersonalOrder(itemCode, fName, sName, address1, city, postalCode, cardNo, cvn, month, year, state));
//    }
//
//    @Then("I create a party order by adding a host (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
//    public void createParty(String fName, String email, String phone, String address1, String city, String postalCode, String eventName, String cardNo, String cvn, String month, String year, String state) throws Exception {
//        assertTrue(serenitysalessteps.createParty(fName, email, phone, address1, city, postalCode, eventName, cardNo, cvn, month, year, state));
//    }

}
