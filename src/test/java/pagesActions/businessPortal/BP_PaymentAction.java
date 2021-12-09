package pagesActions.businessPortal;


import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;
import utils.UiBase;

public class BP_PaymentAction extends PageObject{

	Logger logger= LoggerFactory.getLogger(BP_PaymentAction.class);

	public UiBase uiBase = new UiBase();

	public boolean clickOnAddPaymentButtonAndVerify() throws InterruptedException {
		try {
			logger.info("User click in Add Payment button on create Order Page");
			
			uiBase.getWaitForload();
			uiBase.getElementFromJson("SalesPage:lblPaymentOptions").isDisplayed();
			uiBase.getElementFromJson("SalesPage:btnAddNewCard").isDisplayed();
			uiBase.clickElement("SalesPage:btnAddNewCard");
			logger.info("User clicked in Payment button on create Order Page");
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean verifyShippingAndPaymentDetails() throws InterruptedException {
		try {
			logger.info("User is entering shipping address on Shipping details Page");

			if(uiBase.waitUntilElementDisplayed("SalesPage:inpFName", 50))
			{
				uiBase.getElementFromJson("SalesPage:inpFName").clear();
				uiBase.enterText("SalesPage:inpFName", uiBase.getTestDataFromJson("ShippingDetails:firstName"));
				uiBase.getElementFromJson("SalesPage:inpSName").clear();
				uiBase.enterText("SalesPage:inpSName", uiBase.getTestDataFromJson("ShippingDetails:LastName"));
				uiBase.getElementFromJson("SalesPage:inpAddress1").clear();
				uiBase.enterText("SalesPage:inpAddress1", uiBase.getTestDataFromJson("ShippingDetails:address1"));
				uiBase.getElementFromJson("SalesPage:inpCity").clear();
				uiBase.enterText("SalesPage:inpCity", uiBase.getTestDataFromJson("ShippingDetails:city"));

				Select select=new Select(uiBase.getElementFromJson("SalesPage:selState"));
				select.selectByVisibleText(uiBase.getTestDataFromJson("ShippingDetails:state"));
				uiBase.getElementFromJson("SalesPage:inpPostalCode").clear();
				uiBase.enterText("SalesPage:inpPostalCode", uiBase.getTestDataFromJson("ShippingDetails:postalCode"));
				logger.info("User verified shipping address on Shipping details Page");
				return true;
			}else
			{
				return false;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean enterVisaCardDetails() {
		try {

			logger.info("User is entering visa card details on payment details Page");

			uiBase.clickElement("SalesPage:rdoCardType");
			uiBase.getElementFromJson("SalesPage:inpCardNo").clear();
			uiBase.enterText("SalesPage:inpCardNo", uiBase.getTestDataFromJson("paymentDetails:cardNo"));
			uiBase.clickElement("SalesPage:selMonth");
			Select select=new Select(uiBase.getElementFromJson("SalesPage:selMonth"));
			select.selectByValue(uiBase.getTestDataFromJson("paymentDetails:month"));

			uiBase.clickElement("SalesPage:selYear");
			Select selectYear=new Select(uiBase.getElementFromJson("SalesPage:selYear"));
			selectYear.selectByValue(uiBase.getTestDataFromJson("paymentDetails:year"));


			uiBase.getElementFromJson("SalesPage:inpCVN").clear();
			uiBase.enterText("SalesPage:inpCVN", uiBase.getTestDataFromJson("paymentDetails:cvn"));
			uiBase.clickElement("SalesPage:btnNext");
			logger.info("User entered visa card details on payment details Page");
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean clickOnSubmitAndVerify() throws InterruptedException {
		try {
			logger.info("User is verifying visa card details on payment details Page");
			if(uiBase.waitUntilElementDisplayed("SalesPage:btnNextReviewPage", 20)){
				uiBase.isElementDisplayed("SalesPage:btnNextReviewPage");
				uiBase.clickElement("SalesPage:btnNextReviewPage");
			}
			
			if(uiBase.waitUntilElementDisplayed("SalesPage:btnSubmit", 50))
			{
			
			uiBase.getWaitForload();
			uiBase.scrollToElementLocation("SalesPage:OrderTotal");
			uiBase.clickElement("SalesPage:btnSubmit");
			logger.info("User entered visa card details on payment details Page");
			}
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyOrderInformationOfProducts() throws InterruptedException {
		try {

			logger.info("User is verifying Order details on OrderConfirmation Page");
			if(uiBase.waitUntilElementDisplayed("OrderConfirmationPage:OrderNumber", 50)) {
				uiBase.getElementFromJson("OrderConfirmationPage:OrderNumber").isDisplayed();
			}
			uiBase.getElementFromJson("OrderConfirmationPage:CustomerName").isDisplayed();
			uiBase.getElementFromJson("OrderConfirmationPage:CustomerID").isDisplayed();
			uiBase.getElementFromJson("OrderConfirmationPage:ProductID").isDisplayed();
			uiBase.getElementFromJson("OrderConfirmationPage:lblSalesOrder").isDisplayed();
			uiBase.getElementFromJson("OrderConfirmationPage:lblStatus").isDisplayed();
			

			uiBase.getElementFromJson("OrderConfirmationPage:ProductName").isDisplayed();
			uiBase.getElementFromJson("OrderConfirmationPage:PriceValue").isDisplayed();
			String price=uiBase.getElementFromJson("OrderConfirmationPage:PriceValue").getText();
			System.out.println("product Price :" +price);
			uiBase.getElementFromJson("OrderConfirmationPage:OrderTotal").isDisplayed();
			String Productprice=uiBase.getElementFromJson("OrderConfirmationPage:OrderTotal").getText();
			Double IntProductprice = Double.parseDouble(Productprice.replace("$", ""));
			uiBase.getElementFromJson("OrderConfirmationPage:shipping").isDisplayed();
			String ShippingPrice=uiBase.getElementFromJson("OrderConfirmationPage:shipping").getText();
			Double IntShippingPrice =Double.parseDouble(ShippingPrice.replace("$", ""));
			uiBase.getElementFromJson("OrderConfirmationPage:Tax").isDisplayed();
			String ProductTax=uiBase.getElementFromJson("OrderConfirmationPage:Tax").getText();
			Double IntProductTax =Double.parseDouble(ProductTax.replace("$", ""));
			uiBase.getElementFromJson("OrderConfirmationPage:Total").isDisplayed();
			String Totalprice=uiBase.getElementFromJson("OrderConfirmationPage:Total").getText();

			Double IntTotalprice =Double.parseDouble(Totalprice.replace("$", ""));
			Double TotalExpectedPrice=IntProductprice+IntShippingPrice+IntProductTax;

			if(TotalExpectedPrice.equals(IntTotalprice))
			{
				System.out.println("Product price matched with total Amount");
			}
			logger.info("User verified Order details on OrderConfirmation Page");
			return true;

		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean clickReturnToOrderListAndVerify() {
		try {
			logger.info("User is click on retur to order list link ");
			uiBase.getElementFromJson("OrderConfirmationPage:lnkReturnOrder").isDisplayed();
			uiBase.clickElement("OrderConfirmationPage:lnkReturnOrder");
			uiBase.waitUntilElementDisplayed("OrderConfirmationPage:lblViewOrder", 20);
			uiBase.clickElement("OrderConfirmationPage:lblViewOrder");
			logger.info("User is able to view ordered list.");
			return true;

		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}



}
