package pages.businessPortal;


import java.awt.AWTException;

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

	@Step
	public boolean addProductByIdOnCart() throws InterruptedException, AWTException {
		return bp_ProductListAction.addProductByIdOnCart();
	}

	@Step
	public boolean addProductWithMultipleCatagoryOnCart() {
		return bp_ProductListAction.addProductWithMultipleCatagoryOnCart();
	}

	@Step
	public boolean verifyProductWithMultipleCatagoryOnCart() throws InterruptedException {
		return bp_ProductListAction.verifyProductWithMultipleCatagoryOnCart();
	}

	@Step
	public boolean verifyTheTotalOrderOfProductPrice() {
		return bp_ProductListAction.verifyTheTotalOrderOfProductPrice();
	}
	@Step
	public boolean addProductByNameOnCart() throws InterruptedException {
		return bp_ProductListAction.addProductByNameOnCart();
	}




}
