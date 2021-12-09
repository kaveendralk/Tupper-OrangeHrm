package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_BusinessDashboardAction;
import pagesActions.businessPortal.BP_HomeAction;

import java.util.HashMap;

public class BP_BusinessDashboardPage {

    BP_BusinessDashboardAction bp_businessDashboardAction;

 @Step
 public boolean navigateToPage() {
     return bp_businessDashboardAction.PageOpened();
 }

 @Step
    public boolean verifyReportAreLoading() throws InterruptedException {
     return bp_businessDashboardAction.checkDashboardReportsLoading();
 }

    @Step
    public boolean paymentSummaryReportOpened() throws InterruptedException {
        return bp_businessDashboardAction.paymentSummaryPersonalReportOpened();
    }

    @Step
    public HashMap<String, Boolean> paymentSummaryReportLoaded(){
     return bp_businessDashboardAction.paymentSummaryReportLoading();
    }

//    @Step
//    public boolean navigateToBusinessDashboardPage() throws Exception {
//        return businesspage.navigateToBusinessDashboardPage();
//    }
//
//
//    @Step
//    public boolean navigateToPersonalWebSite() throws Exception {
//        return businesspage.navigateToPersonalWebSite();
//    }

//    @Step
//    public boolean navigateToCreatePersonalOrderPage() throws Exception {
//        return businessdashboardpage.navigateToCreatePersonalOrderPage();
//    }
//
//    @Step
//    public boolean navigateToCreateParty() throws Exception {
//        return businessdashboardpage.navigateToCreateParty();
//    }
}
