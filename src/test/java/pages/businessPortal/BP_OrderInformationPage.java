package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_OrderInformationAction;


public class BP_OrderInformationPage {

	BP_OrderInformationAction bp_OrderInformationAction;

	@Step
	public boolean navigateToPage() {
		return bp_OrderInformationAction.PageOpened();
	}

	@Step
	public void clicktoElement(String elementName) throws InterruptedException {
		 bp_OrderInformationAction.clicktoElement(elementName);
		
	}
}
