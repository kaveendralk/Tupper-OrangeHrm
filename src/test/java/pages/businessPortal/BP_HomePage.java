package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_HomeAction;

public class BP_HomePage {

    BP_HomeAction bp_homeAction;

    @Step
    public void navigateToPage(){
        bp_homeAction.PageOpened();
    }
}
