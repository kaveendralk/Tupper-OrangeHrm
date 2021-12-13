package pagesActions.businessPortal;

import io.vavr.collection.List;
import javafx.collections.MapChangeListener;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UiBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BP_BusinessDashboardAction extends PageObject {

    Logger logger = LoggerFactory.getLogger(BP_BusinessDashboardAction.class);

    ArrayList<String> list = new ArrayList<>();

    UiBase uiBase = new UiBase();

    public boolean PageOpened() {

        if (uiBase.waitUntilElementDisplayed("BusinessDashboardPage:txtBusinessDashboard", 10)) {
//                uiBase.isElementDisplayed("BusinessDashboardPage:lnkMyBusiness")) {
            return true;
        }
        return false;
    }

    public boolean checkDashboardReportsLoading() throws InterruptedException {
        try {
            Thread.sleep(1000);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            if (uiBase.isElementDisplayed("BusinessDashboardPage:thisMonthTabActive")) {
/*Applicable for Director role
                list.add("BusinessDashboardPage:teamSection"); */
               list.add("BusinessDashboardPage:potentialEarningsSection");
//                list.add("BusinessDashboardPage:tabWYD");
                for (int i = 0; i < list.size(); i++) {
                    if (uiBase.isElementDisplayed(list.get(i))) {
                        logger.info("Element" + list.get(i) + " is present");
                        /* Added for consultant login */
                        return true;
                    } else {
                        logger.info("Element" + list.get(i) + " is not present");
                        return false;
                    }
                }
                /*Not applicable for Consultant
                if (uiBase.isElementDisplayed("BusinessDashboardPage:tabWYD")) {
                    uiBase.clickElement("BusinessDashboardPage:tabWYD");
                    if (uiBase.waitUntilElementDisplayed("BusinessDashboardPage:headerWhatYourDrive", 30)) {
                        return true;
                    } else {
                        logger.info("'What's Your Drive' page is not loaded");
                        return false;
                    }
                } */

            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public boolean paymentSummaryPersonalReportOpened() throws InterruptedException {
        uiBase.getWaitForload();
        if(uiBase.waitUntilElementDisplayed("BusinessPage:paymentSummaryHeading", 60))   {
            return true;
        }
        return false;
    }

    public HashMap<String, Boolean> paymentSummaryReportLoading() throws InterruptedException {
        HashMap<String,Boolean> map = new HashMap<String, Boolean>();
        uiBase.getWaitForload();
        uiBase.getWaitForload();
            if(uiBase.isElementDisplayed("BusinessPage:paymentDateText")){
                map.put("Payment Date dropdown is visible", true);
            }else{
                map.put("Payment Date dropdown is not visible", false);
            }
            if(uiBase.isElementDisplayed("BusinessPage:viewReportButtonInPaymentSummary")){
                map.put("View Report button is visible", true);
            }else{
                map.put("View Report button is not visible", false);
            }
        if(uiBase.waitUntilElementDisplayed("BusinessPage:paymentSummaryText", 30)){
            map.put("Payment Summary text is visible", true);
        }else{
            map.put("Payment Summary text is not visible", false);
        }
            if(uiBase.waitUntilElementDisplayed("BusinessPage:dateColumnInPaymentSummary", 30) &&
            uiBase.waitUntilElementDisplayed("BusinessPage:descriptionColumnInPaymentSummary", 30) && uiBase.waitUntilElementDisplayed("BusinessPage:amountInPaymentSummary", 30)
            && uiBase.waitUntilElementDisplayed("BusinessPage:adjustmentInPaymentSummary", 30) && uiBase.waitUntilElementDisplayed("BusinessPage:paidAmountInPaymentSummary", 30)){
                map.put("Date or Description or Amount or Adjustment or Paid Amount are visible", true);
            }else{
                map.put("Date or Description or Amount or Adjustment or Paid Amount or all of them are not visible", false);
            }
        return map;

    }

public boolean navigateToPersonalReportsAndVerify()throws InterruptedException{
        try{
        Thread.sleep(1000);
        getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        uiBase.clickElement("BusinessPage:hambergerMenu");
        uiBase.clickElement("BusinessPage:lnkMyBusiness2");
        uiBase.clickElement("BusinessPage:lnkPersonalReports");
        uiBase.clickElement("BusinessPage:lnkPaymentSummary");
        Thread.sleep(2000);
        uiBase.getElementFromJson("BusinessPage:lblWelcome").isDisplayed();
        uiBase.clickElement("BusinessPage:hambergerMenu");
        uiBase.clickElement("BusinessPage:lnkMyBusiness");
        uiBase.clickElement("BusinessPage:lnkPersonalReports");
        uiBase.clickElement("BusinessPage:lnkPersonalHistory");
        Thread.sleep(2000);
        uiBase.getElementFromJson("BusinessPage:lblWelcome").isDisplayed();
        uiBase.clickElement("BusinessPage:hambergerMenu");
        uiBase.clickElement("BusinessPage:lnkMyBusiness");
        uiBase.clickElement("BusinessPage:lnkPersonalReports");
        uiBase.clickElement("BusinessPage:lnkYearEndSummary");
        Thread.sleep(2000);
        uiBase.getElementFromJson("BusinessPage:lblWelcome").isDisplayed();
        uiBase.clickElement("BusinessPage:lnkHome");
        return true;
        }catch(NoSuchElementException e){
        e.printStackTrace();
        }
        return false;
        }

public boolean navigateToCreatePersonalOrderPage()throws InterruptedException{
        try{
        getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkSales");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkPersonalOrder");
        return true;
        }catch(NoSuchElementException e){
        e.printStackTrace();
        }
        return false;
        }


/* Navigate to create party */
public boolean navigateToCreateParty()throws InterruptedException{
        try{
        getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkSales");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkPartyOrder");
        return true;
        }catch(NoSuchElementException e){
        e.printStackTrace();
        }
        return false;
        }
        }
