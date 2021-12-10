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
    public HashMap<String, Boolean> paymentSummaryReportLoaded() throws InterruptedException {
     return bp_businessDashboardAction.paymentSummaryReportLoading();
    }

}
