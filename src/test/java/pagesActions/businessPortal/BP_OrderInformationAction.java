package pagesActions.businessPortal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;
import utils.UiBase;

public class BP_OrderInformationAction extends PageObject{

	Logger logger = LoggerFactory.getLogger(BP_OrderInformationAction.class);
	UiBase uiBase = new UiBase();


	public boolean PageOpened() {
		if (uiBase.isElementDisplayed("OrderConfirmationPage:lnkReturnOrder")) {
			return true;
		}
		return false;
	}


	public void clicktoElement(String elementName) throws InterruptedException {
		switch (elementName) {
		case "Return to Order":
			uiBase.getWaitForload();
			uiBase.clickElement("OrderConfirmationPage:lnkReturnOrder");
			break;
		}
	}




}
