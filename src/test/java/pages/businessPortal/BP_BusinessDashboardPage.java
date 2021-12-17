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

    @Step
    public boolean personalHistoryReportOpened() throws InterruptedException {
        return bp_businessDashboardAction.personalHistoryReportOpened();
    }

    @Step
    public boolean yearEndReportOpened() throws InterruptedException {
        return bp_businessDashboardAction.yearEndReportOpened();
    }

    @Step
    public boolean customReportOpened() throws InterruptedException {
        return bp_businessDashboardAction.customReportOpened();
    }





    @Step
    public HashMap<String, Boolean> personalHistoryReportLoaded() throws InterruptedException {
        return bp_businessDashboardAction.personalHistoryReportLoading();
    }

    @Step
    public HashMap<String, Boolean> yearEndReportLoaded() throws InterruptedException {
        return bp_businessDashboardAction.yearEndReportLoaded();
    }

}
