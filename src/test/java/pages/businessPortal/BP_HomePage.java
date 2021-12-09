package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_HomeAction;

import java.util.HashMap;

public class BP_HomePage {

    BP_HomeAction bp_homeAction;

    @Step
    public boolean navigateToPage() {
        return bp_homeAction.PageOpened();
    }

    @Step
    public void clicktoElement(String elementName) {
        bp_homeAction.clickToElement(elementName);
    }

    @Step
    public HashMap<String, Boolean> verifyHomePage(){
        return bp_homeAction.verifyHomePage();
    }

    @Step
    public boolean verifyWhatsNewTile(){
        return bp_homeAction.verifyWhatsNewTile();
    }
    @Step
    public boolean verifyKnowledgeCenterTile(){
        return bp_homeAction.verifyKnowledgeCenterTile();
    }

    @Step
    public HashMap<String, Boolean> verifySideMenuLinks() throws InterruptedException {
        return bp_homeAction.verifySideMenuLinks();
    }
}
