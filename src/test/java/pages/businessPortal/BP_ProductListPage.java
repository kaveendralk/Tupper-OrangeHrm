package pages.businessPortal;


import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_ProductListAction;

public class BP_ProductListPage {
	
	BP_ProductListAction bp_ProductListAction;

	@Step
	public boolean verifytheProductOverlayPage() throws InterruptedException {
		return bp_ProductListAction.verifytheProductOverlayPage();
		
	}

	@Step
	public boolean verifytheAddedProduct() throws InterruptedException {
		return bp_ProductListAction.verifytheAddedProduct();
		
	}

	

}
