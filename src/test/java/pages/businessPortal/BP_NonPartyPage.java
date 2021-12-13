package pages.businessPortal;


import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_NonPartyAction;

public class BP_NonPartyPage {

	BP_NonPartyAction bp_NonPartyAction;

	@Step
	public boolean navigateToPage() {
		return bp_NonPartyAction.PageOpened();
	} 
	
	@Step
	public boolean navigateToCreatePersonalOrder() throws InterruptedException {
		return bp_NonPartyAction.navigateToCreatePersonalOrder();
		
	}

	@Step
	public void clicktoElement(String elementName) {
		bp_NonPartyAction.clickToElement(elementName);
		
	}

	

	

	
	

}
