package pagesActions.businessPortal;

import java.util.NoSuchElementException;

import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;
import utils.UiBase;



public class BP_NonPartyAction extends PageObject{

	Logger logger= LoggerFactory.getLogger(BP_NonPartyAction.class);

	public UiBase uiBase = new UiBase();

	public boolean navigateToCreatePersonalOrder() throws InterruptedException {
		try {
			logger.info("User is on Create Order Page");
			Actions action = new Actions(getDriver());

			if(uiBase.waitUntilElementDisplayed("BusinessDashboardPage:hambergerMenu", 30))
			{
				uiBase.clickElement("BusinessDashboardPage:hambergerMenu");
				uiBase.clickElement("BusinessDashboardPage:lnkSales");
				uiBase.clickElement("SalesPage:lnkNonPartyOrder");

			}
			if(uiBase.waitUntilElementDisplayed("BusinessDashboardPage:selectDirOption", 30))
			{
				action.moveToElement(uiBase.getElementFromJson("BusinessDashboardPage:selectDirOption")).click().build().perform();
			}

			if(uiBase.waitUntilElementDisplayed("SalesPage:lblCreateOrder", 30)) {
				Thread.sleep(5000);
				uiBase.clickElement("SalesPage:btnBrowse");
			}
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

}
