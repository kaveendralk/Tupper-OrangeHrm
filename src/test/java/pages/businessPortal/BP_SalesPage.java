package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_BusinessDashboardAction;
import pagesActions.businessPortal.BP_SalesPageAction;

public class BP_SalesPage {

    BP_SalesPageAction bp_salesPageAction;

    @Step
    public boolean createPersonalOrder(String itemCode, String fName, String sName, String address1, String city, String postalCode, String cardNo, String cvn, String month, String year, String state) throws Exception {
        return bp_salesPageAction.createPersonalOrder(itemCode, fName, sName, address1, city, postalCode, cardNo, cvn, month, year, state);
    }

    @Step
    public boolean createParty(String fName, String email, String phone, String address1, String city, String postalCode, String eventName, String cardNo, String cvn, String month, String year, String state) throws Exception {
        return bp_salesPageAction.createParty(fName, email, phone, address1, city, postalCode, eventName, cardNo, cvn, month, year, state);
    }

}
