package pagesActions.businessPortal;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.core.pages.PageObject;
import utils.UiBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BP_NonPartyAction extends PageObject{

	Logger logger= LogManager.getLogger(BP_NonPartyAction.class);

	public UiBase uiBase = new UiBase();
    
	public boolean PageOpened() {
		
		//uiBase.clickElement("SalesPage:lnkNonPartyOrder");
		if(uiBase.waitUntilElementDisplayed("SalesPage:lblCreateOrder", 50)) {
			return true;
		}
		return false;
	}

	public void clickToElement(String elementName) {
		 switch (elementName) {
		 case "Sales":
			 uiBase.clickElement("BusinessDashboardPage:lnkSales");
			 uiBase.clickElement("SalesPage:lnkNonPartyOrder");
			 break;
		case "Delete Icon":
			uiBase.scrollToTop();
			uiBase.clickElement("SalesPage:SecondProductDeleteIcon");
			break;
		case "No":
			uiBase.clickElement("SalesPage:btndeleteNo");
			break;
		case "Yes":
			uiBase.clickElement("SalesPage:btndeleteYes");
			break;
		case "Select this card":
			uiBase.clickElement("SalesPage:btnSelectThisCard");
			break;

		}

	}
	
	public boolean navigateToCreatePersonalOrder() throws InterruptedException {
		try {
			logger.info("User is on Create Order Page");
			if(uiBase.waitUntilElementDisplayed("SalesPage:lblCreateOrder", 30)) {
				uiBase.getWaitForload();
				//				uiBase.scrollToElementLocation("SalesPage:btnBrowse");
				Thread.sleep(500);
				uiBase.clickElement("SalesPage:btnBrowse");
			}
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	

	
}
