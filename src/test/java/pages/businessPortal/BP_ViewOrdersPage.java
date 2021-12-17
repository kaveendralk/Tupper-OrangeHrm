package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_ViewOrdersAction;

public class BP_ViewOrdersPage {

	BP_ViewOrdersAction  bp_ViewOrdersAction;
	
	@Step
	public boolean navigateToPage() throws InterruptedException {
		return bp_ViewOrdersAction.PageOpened();
	}
	
	
	@Step
	public boolean verifytheTotalRecoundCount() {
		return bp_ViewOrdersAction.verifytheTotalRecoundCount();
	}

    

	@Step
	public void clicktoElement(String elementName) throws InterruptedException  {
		bp_ViewOrdersAction.clickToElement(elementName);
		
	}

	@Step
	public boolean searchbyOrderNumber() {
		return bp_ViewOrdersAction.searchbyOrderNumber();
	}

	@Step
	public boolean verifyproductdetailsByOrderNumber() {
		return bp_ViewOrdersAction.verifyproductdetailsByOrderNumber();
	}

	@Step
	public boolean searchbyProductID() throws InterruptedException {
		return bp_ViewOrdersAction.searchbyProductID();
	}

	@Step
	public boolean verifyproductdetailsByProductID() {
		return bp_ViewOrdersAction.verifyproductdetailsByProductID();
	}
	
	@Step
	public boolean searchOrderByPendingStatus() {
		return bp_ViewOrdersAction.searchOrderByPendingStatus();
	}

	@Step
	public boolean deletePendingOrderfromList() {
		return bp_ViewOrdersAction.deletePendingOrderfromList();
	}

	@Step
	public boolean verifyOrderDeletionOverlay() throws InterruptedException {
		return bp_ViewOrdersAction.verifyOrderDeletionOverlay();
	}

	@Step
	public boolean verifyOrderDeletionAlertBox() {
		return bp_ViewOrdersAction.verifyOrderDeletionAlertBox();
	}

//	@Step
//	public boolean verifyDeletedOrderFromList() {
//		return bp_ViewOrdersAction.verifyDeletedOrderFromList();
//	}


	

	
	
}
