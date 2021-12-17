package pagesActions.businessPortal;

import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.serenitybdd.core.pages.PageObject;
import utils.UiBase;

public class BP_CheckOutAction extends PageObject {

    Logger logger= LogManager.getLogger(BP_CheckOutAction.class);

    public UiBase uiBase = new UiBase();

    public boolean clickOnCheckOutbuttonAndVerify() throws InterruptedException {
        try {
            logger.info("User click in checkout button on create Order Page");

            if (uiBase.waitUntilElementDisplayed("SalesPage:btnCheckout", 30)) {
                uiBase.getWaitForload();
                uiBase.getElementFromJson("SalesPage:btnCheckout").isDisplayed();
                uiBase.clickElement("SalesPage:btnCheckout");
                logger.info("User verified checkout button on create Order Page");
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean clickOnPaymentButtonAndVerify() throws InterruptedException {
        try {
            logger.info("User is verifying Payment button on create Order Page");

            if (uiBase.waitUntilElementDisplayed("SalesPage:btnAddPayment", 30)) {

                uiBase.getWaitForload();
                uiBase.getElementFromJson("SalesPage:btnAddPayment").isDisplayed();
                logger.info("User verified Payment button on create Order Page");
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean clickOnPaymentOptionsAndVerify() throws InterruptedException {
        try {
            logger.info("User click in Payment button on create Order Page");

            if (uiBase.waitUntilElementDisplayed("SalesPage:btnAddPayment", 30)) {
                uiBase.clickElement("SalesPage:btnAddPayment");
                logger.info("User clicked in Payment button on create Order Page");
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;

    }


}


