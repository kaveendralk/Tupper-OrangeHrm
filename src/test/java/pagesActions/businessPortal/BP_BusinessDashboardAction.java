package pagesActions.businessPortal;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UiBase;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BP_BusinessDashboardAction extends PageObject {

    Logger logger= LoggerFactory.getLogger(BP_BusinessDashboardAction.class);

    UiBase uiBase= new UiBase();

    public boolean PageOpened() {
        if (uiBase.isElementDisplayed("BusinessDashboardPage:lnkMyBusiness")) {
            return true;
        }
        return false;
    }

    public boolean checkReportsLoading() throws InterruptedException{
        try {
            Thread.sleep(1000);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            uiBase.clickElement("BusinessDashboardPage:tabOrgGrowth");
            Thread.sleep(1000);
            uiBase.getElementFromJson("BusinessDashboardPage:lblMyOrganization").isDisplayed();
            uiBase.clickElement("BusinessDashboardPage:tabDirectorGrowth");
            Thread.sleep(1000);
            if(uiBase.isElementDisplayed("BusinessDashboardPage:btnRefresh")){
                uiBase.clickElement("BusinessDashboardPage:tabWYD");
            }
            if(uiBase.isElementDisplayed("BusinessDashboardPage:lblCurrent")){
                uiBase.clickElement("BusinessDashboardPage:tabThisMonth");
            }
			Thread.sleep(1000);
            uiBase.getElementFromJson("BusinessDashboardPage:lblMaintain").isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean navigateToPersonalReportsAndVerify() throws InterruptedException{
        try {
            Thread.sleep(1000);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkMyBusiness2");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalReports");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPaymentSummary");
//			Thread.sleep(2000);
//			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessPage:lblWelcome").isDisplayed();
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkMyBusiness");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalReports");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalHistory");
//			Thread.sleep(2000);
//			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessPage:lblWelcome").isDisplayed();
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkMyBusiness");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalReports");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkYearEndSummary");
//			Thread.sleep(2000);
//			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessPage:lblWelcome").isDisplayed();
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkHome");
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }


//    public boolean navigateToPersonalWebSite() throws InterruptedException{
//        try {
//            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lblWelcome");
////			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:btnProfile");
////			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalWeb");
//            return true;
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }


    /* Navigate to create personal order */
    public boolean navigateToCreatePersonalOrderPage() throws InterruptedException{
        try {
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkSales");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkPersonalOrder");
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }


    /* Navigate to create party */
    public boolean navigateToCreateParty() throws InterruptedException{
        try {
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkSales");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkPartyOrder");
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }
}
