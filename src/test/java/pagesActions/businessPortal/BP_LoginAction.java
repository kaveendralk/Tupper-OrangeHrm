package pagesActions.businessPortal;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.*;

public class BP_LoginAction extends PageObject {

    public UiBase uiBase = new UiBase();
    String userName = null;
    String password = null;

    public void enterLoginDetails(String country_User) throws InterruptedException {
        if (country_User.equalsIgnoreCase("CA_User")) {
            userName = uiBase.getTestDataFromJson("validLoginDetails_CA:UserName");
            password = uiBase.getTestDataFromJson("validLoginDetails_CA:Password");
        } else if (country_User.equalsIgnoreCase("US_User")) {
            userName = uiBase.getTestDataFromJson("validLoginDetails_US:UserName");
            password = uiBase.getTestDataFromJson("validLoginDetails_US:Password");
        }
        uiBase.getWaitForload();
        uiBase.enterText("TupperLoginPage:txtUsername", userName);
        uiBase.enterText("TupperLoginPage:txtPassword", password);
        uiBase.clickElement("TupperLoginPage:btnSubmit");


    }
}
