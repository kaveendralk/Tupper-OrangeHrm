package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_HomeAction;

public class BP_HomePage {

    BP_HomeAction bp_homeAction;

    @Step
    public boolean navigateToPage()  {
        return bp_homeAction.PageOpened();
    }

    @Step
    public void clicktoElement(String elementName) {
        bp_homeAction.clickToElement(elementName);
    }

    @Step
    public boolean verifyVariousElements(String elementsName){
        return bp_homeAction.verifyVariousElements(elementsName);
    }
}
