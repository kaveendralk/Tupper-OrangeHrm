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


			uiBase.waitUntilElementDisplayed("BusinessDashboardPage:hambergerMenu", 30);

			uiBase.clickElement("BusinessDashboardPage:hambergerMenu");
			uiBase.clickElement("BusinessDashboardPage:lnkSales");
			uiBase.clickElement("SalesPage:lnkNonPartyOrder");
			uiBase.waitUntilElementDisplayed("BusinessDashboardPage:selectDirOption", 30);

			uiBase.getElementFromJson("BusinessDashboardPage:selectDirOption").isDisplayed();

			Actions action = new Actions(getDriver());
			action.moveToElement(uiBase.getElementFromJson("BusinessDashboardPage:selectDirOption")).click().build().perform();

			uiBase.waitUntilElementDisplayed("SalesPage:lblCreateOrder", 50);

			uiBase.getElementFromJson("SalesPage:lblCreateOrder").isDisplayed();

			uiBase.getElementFromJson("SalesPage:btnBrowse").isDisplayed();
			uiBase.waitUntilElementDisplayed("SalesPage:btnBrowse", 50);
			uiBase.clickElement("SalesPage:btnBrowse");

			logger.info("user has clicked on browse button");
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

}
