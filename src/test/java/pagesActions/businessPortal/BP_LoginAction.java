package pagesActions.businessPortal;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.*;

public class BP_LoginAction extends PageObject {

    Logger logger= LoggerFactory.getLogger(BP_LoginAction.class);

    public UiBase uiBase = new UiBase();

    public void enterLoginDetails() throws InterruptedException {
        logger.info("User is on login page");
        uiBase.waitUntilElementDisplayed("TupperLoginPage:txtUsername", 50);
        Thread.sleep(10000);
        uiBase.enterText("TupperLoginPage:txtUsername", uiBase.getTestDataFromJson("validLoginDetails:UserName"));
        uiBase.enterText("TupperLoginPage:txtPassword", uiBase.getTestDataFromJson("validLoginDetails:Password"));
        uiBase.clickElement("TupperLoginPage:btnSubmit");

        logger.info("user has clicked submit button");

    }
}
