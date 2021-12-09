package pagesActions.businessPortal;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefinitions.businessPortal.BP_HomeStepDef;
import utils.UiBase;

import java.util.HashMap;

public class BP_HomeAction extends PageObject {

    Logger logger = LoggerFactory.getLogger(BP_HomeAction.class);
    UiBase uiBase = new UiBase();

    public boolean PageOpened() {
        if (uiBase.waitUntilElementDisplayed("HomePage:logo", 15)) {
            return true;
        }
        return false;
    }

    public void clickToElement(String elementName) {
        switch (elementName) {
            case "Hamburger Icon":
                uiBase.clickElement("BusinessDashboardPage:hambergerMenu");
                break;
            case "Business Dashboard Icon":
                uiBase.waitUntilElementDisplayed("HomePage:businessDashboardIcon", 10);
                uiBase.clickElement("HomePage:businessDashboardIcon");
                break;
            case "My Business":
                uiBase.clickElement("BusinessDashboardPage:lnkMyBusiness");
                break;
            case "Dashboard Report":
                uiBase.clickElement("BusinessDashboardPage:lnkDashboardReports");
                break;
            case "Personal Report":
                uiBase.clickElement("BusinessDashboardPage:lnkPersonalReports");
                break;
            case "Payment Summary":
                uiBase.clickElement("BusinessDashboardPage:lnkPaymentSummary");
            case "Sales":
            	 uiBase.clickElement("BusinessDashboardPage:lnkSales");
                 break;
            case "Browse Products":
           	 uiBase.clickElement("BusinessDashboardPage:lnkSales");
                break;
            case "Manage Parties":
                break;

        }
    }

    public HashMap<String, Boolean> verifyHomePage() {
        HashMap<String, Boolean> map = new HashMap<>();
        if (uiBase.waitUntilElementDisplayed("HomePage:businessDashboardIcon", 30)) {
            if (uiBase.isElementDisplayed("HomePage:businessDashboardIcon")) {
                map.put("Business Dashboard icon is visible", true);
            } else {
                map.put("Business Dashboard icon is not visible", false);
            }
            if (uiBase.isElementDisplayed("HomePage:createAPartyIcon")) {
                map.put("Create A Party icon is visible", true);
            } else {
                map.put("Create A Party icon is not visible", false);
            }
            if (uiBase.isElementDisplayed("HomePage:managePartiesIcon")) {
                map.put("Manage Parties icon is visible", true);
            } else {
                map.put("Manage Parties icon is not visible", false);
            }
            if (uiBase.isElementDisplayed("HomePage:placeOderIcon")) {
                map.put("Place Order icon is visible", true);
            } else {
                map.put("Place Order icon is not visible", false);
            }
            if (uiBase.isElementDisplayed("HomePage:whatsNewIcon")) {
                map.put("What's New icon is visible", true);
            } else {
                map.put("What's New icon is not visible", false);
            }
            if (uiBase.isElementDisplayed("HomePage:heading") && uiBase.isElementDisplayed("HomePage:sliderHero")) {
                map.put("Paragraph and Slider is visible", true);
            } else {
                map.put("Paragraph or Slider is not visible", false);
            }

        } else {
            map.put("Home page is not loaded", false);
        }
        return map;
    }

    public boolean verifyWhatsNewTile(){
        if (uiBase.isElementDisplayed("HomePage:whatsNewSectionHeading") && uiBase.isElementDisplayed("HomePage:WhatsNewTile")) {
         return true;
        } else {
          return false;
        }
    }


    public boolean verifyKnowledgeCenterTile(){
        if (uiBase.isElementDisplayed("HomePage:knowledgeCenterSectionHeading") && uiBase.isElementDisplayed("HomePage:knowledgeCenterTile")) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String, Boolean> verifySideMenuLinks() throws InterruptedException {
        HashMap<String, Boolean> map = new HashMap<>();
            if (uiBase.isElementDisplayed("BusinessDashboardPage:lnkHome")) {
                map.put("Home link is visible", true);
            } else {
                map.put("Home link is not visible", false);
            }
            if (uiBase.isElementDisplayed("BusinessDashboardPage:lnkMyBusiness")) {
                uiBase.clickElement("BusinessDashboardPage:lnkMyBusiness");
                if(uiBase.isElementDisplayed("BusinessDashboardPage:lnkDashboardReports") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:lnkPersonalReports") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:lnkCustomReports")){
                    map.put("Dashboard report, Personal report and Custom Report link are visible", true);
                } else{
                    map.put("Dashboard report or Personal report or Custom Report link or all of them are not visible", false);
                }
            } else {
                map.put("My Business link is not visible", false);
            }
            if (uiBase.isElementDisplayed("BusinessDashboardPage:linkTuppSocial") &&
                    uiBase.isElementDisplayed("BusinessDashboardPage:linkTuppNow") &&
                    uiBase.isElementDisplayed("BusinessDashboardPage:linkTuppCardMyPayQuicker")) {
                map.put("TuppSocial, TuppNow and Tupp by Payquicker link are visible", true);
            } else {
                map.put("TuppSocial, TuppNow and Tupp by Payquicker link are not visible", false);
            }
            uiBase.clickElement("BusinessDashboardPage:lnkMyBusiness");
            Thread.sleep(10000);
            if (uiBase.isElementDisplayed("BusinessDashboardPage:linkSales")) {
                uiBase.clickElement("BusinessDashboardPage:linkSales");
                uiBase.waitUntilElementDisplayed("BusinessDashboardPage:linkCreateNonPartyOrder", 30);
                uiBase.scrollToElementLocation("BusinessDashboardPage:linkOrderPartiallyShipped");
                if(uiBase.isElementDisplayed("BusinessDashboardPage:linkCreateNonPartyOrder") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkCreateNonPartyCustomerOrder") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkViewOrders") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkCreateAParty") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkManageParties") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkPartyOrderDetail") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkOrderPartiallyShipped") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkAwardsOrderingReport")){
                    map.put("All the menu links under Sales are visible", true);
                } else{
                    map.put("All the menu links under Sales are not visible", false);
                }
            } else {
                map.put("Sales link is not visible", false);
            }
            if(uiBase.isElementDisplayed("BusinessDashboardPage:linkManageSubscription") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkLinkWebsiteOrdersToParty") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkWarrantyRequestForm") &&
                        uiBase.isElementDisplayed("BusinessDashboardPage:linkWarrantyClaimList")){
                map.put("Manage Subscription, warranty request and Claim etc. links are visible", true);
            } else {
                map.put("Manage Subscription, warranty request and Claim etc. links are not visible", false);
            }
        return map;
    }

}
