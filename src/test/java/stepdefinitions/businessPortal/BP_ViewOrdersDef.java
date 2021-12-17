package stepdefinitions.businessPortal;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.businessPortal.BP_ViewOrdersPage;

public class BP_ViewOrdersDef {

	Logger logger= LoggerFactory.getLogger(BP_ViewOrdersDef.class);

	@Steps
	BP_ViewOrdersPage bp_ViewOrdersPage;

	@And("User verify results count and pagination for total orders")
	public void user_verify_results_count_and_pagination_for_total_orders() {
		assertTrue(bp_ViewOrdersPage.verifytheTotalRecoundCount());
		logger.info("User is on view orders Page ");
	}
	@And("User choose to search orders using Order Number")
	public void user_choose_to_search_orders_using_Order_Number() {
		assertTrue(bp_ViewOrdersPage.searchbyOrderNumber());
	}

	@And("User verify that only relevant orders matching to order number search displayed")
	public void user_verify_that_only_relevant_orders_matching_to_order_number_search_displayed() {
		assertTrue(bp_ViewOrdersPage.verifyproductdetailsByOrderNumber());
	}

	@And("User choose to search orders using Product ID")
	public void user_choose_to_search_orders_using_Product_ID() throws InterruptedException {
		assertTrue(bp_ViewOrdersPage.searchbyProductID());
	}

	@And("User verify that only relevant orders matching to product ID search  displayed")
	public void user_verify_that_only_relevant_orders_matching_to_product_ID_search_displayed() {
		assertTrue(bp_ViewOrdersPage.verifyproductdetailsByProductID());
	}
	
	@And("User choose to search orders using pending status")
	public void user_choose_to_search_orders_using_pending_status() {
		assertTrue(bp_ViewOrdersPage.searchOrderByPendingStatus());
	}

	@And("User verify that delete icon is coming against the order having status as Pending")
	public void user_verify_that_delete_icon_is_coming_against_the_order_having_status_as_Pending() {
		assertTrue(bp_ViewOrdersPage.deletePendingOrderfromList());
	}

	@Then("Order Deletion Confirmation overlay is opened")
	public void order_Deletion_Confirmation_overlay_is_opened() throws InterruptedException {
		assertTrue(bp_ViewOrdersPage.verifyOrderDeletionOverlay());
	}

	
	@Then("User verify that an alert for deletion is displayed")
	public void user_verify_that_an_alert_for_deletion_is_displayed() {
		assertTrue(bp_ViewOrdersPage.verifyOrderDeletionAlertBox());
	}

//	@Then("User verify that order has been deleted")
//	public void user_verify_that_order_has_been_deleted() {
//		assertTrue(bp_ViewOrdersPage.verifyDeletedOrderFromList());
//	}

}

