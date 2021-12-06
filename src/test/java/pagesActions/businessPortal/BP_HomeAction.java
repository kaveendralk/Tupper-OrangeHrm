package pagesActions.businessPortal;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefinitions.businessPortal.BP_HomeStepDef;
import utils.UiBase;

public class BP_HomeAction extends PageObject {

    Logger logger = LoggerFactory.getLogger(BP_HomeAction.class);
    UiBase uiBase = new UiBase();

    public boolean PageOpened() {
        if (uiBase.isElementDisplayed("HomePage:logo")) {
            return true;
        }
        return false;
    }

    public void clickToElement(String elementName) {
        switch (elementName) {
            case "Hamburger Icon":
                uiBase.clickElement("BusinessPage:hambergerMenu");
                break;
            case "Business Dashboard Icon":
                uiBase.clickElement("HomePage:businessDashboardIcon");
                break;
            case "My Business":
                uiBase.clickElement("BusinessPage:lnkMyBusiness");
                break;
            case "Dashboard Report":
                uiBase.clickElement("BusinessPage:lnkDashboardReports");
                break;
            case "Manage Parties":
                break;
        }
    }

    public boolean verifyVariousElements(String elementsName) {

        //Will add few assertions after discussion with Vishwas
        return true;
    }
}
