package pages.businessPortal;

import net.thucydides.core.annotations.Step;
import pagesActions.businessPortal.BP_PaymentAction;

public class BP_PaymentPage {

	BP_PaymentAction bp_PaymentAction;

	@Step
	public boolean navigateToPage() {
		return bp_PaymentAction.PageOpened();
	}
	
	@Step
	public boolean clickOnAddPaymentButtonAndVerify() throws InterruptedException {
		return bp_PaymentAction.clickOnAddPaymentButtonAndVerify();
	}

	@Step
	public boolean verifyShippingAndPaymentDetails() throws InterruptedException {
		return bp_PaymentAction.verifyShippingAndPaymentDetails();
	}

	@Step
	public boolean enterVisaCardDetails() {
		return bp_PaymentAction.enterVisaCardDetails();
	}
	@Step
	public boolean clickOnSubmitAndVerify() throws InterruptedException {
		return bp_PaymentAction.clickOnSubmitAndVerify();
		
	}
	@Step
	public boolean verifyOrderInformationOfProducts() throws InterruptedException {
		return bp_PaymentAction.verifyOrderInformationOfProducts();
		
	}
    
	@Step
	public boolean clickReturnToOrderListAndVerify() {
		return bp_PaymentAction.clickReturnToOrderListAndVerify();
	}

	@Step
	public boolean clickOnExistingPaymentCard() {
		return bp_PaymentAction.clickOnExistingPaymentCard();

	}

	@Step
	public boolean verifyPaymentCardDetails() {
		return bp_PaymentAction.verifyPaymentCardDetails();
	}

	
}
