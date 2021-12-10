package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pagesActions.businessPortal.BP_LoginAction;

public class BP_LoginPage {

    BP_LoginAction bp_loginAction;

    @Step
    public void openApplication(){
        bp_loginAction.open();

    }

    @Step
    public void loginToPortal(String country_User) throws InterruptedException {
        bp_loginAction.enterLoginDetails(country_User);
    }
}
