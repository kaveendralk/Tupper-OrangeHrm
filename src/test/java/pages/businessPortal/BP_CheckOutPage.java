package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_CheckOutAction;

public class BP_CheckOutPage {
	
	BP_CheckOutAction bp_checkOutAction;
	
    @Step
	public boolean clickOnCheckOutbuttonAndVerify() throws InterruptedException {
		return bp_checkOutAction.clickOnCheckOutbuttonAndVerify();
		
	}
    @Step
	public boolean clickOnPaymentButtonAndVerify() throws InterruptedException {
		return bp_checkOutAction.clickOnPaymentButtonAndVerify();
		
	}
   @Step
	public boolean clickOnPaymentOptionsAndVerify() throws InterruptedException {
		return bp_checkOutAction.clickOnPaymentOptionsAndVerify();
		
	}

}
