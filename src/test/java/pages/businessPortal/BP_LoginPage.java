package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_LoginAction;

public class BP_LoginPage {

    BP_LoginAction bp_loginAction;

    @Step
    public void openApplication(){
        bp_loginAction.open();
    }

    @Step
    public void loginToPortal() throws InterruptedException {
        bp_loginAction.enterLoginDetails();
    }
}
