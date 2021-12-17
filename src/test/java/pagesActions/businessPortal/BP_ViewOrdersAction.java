package pagesActions.businessPortal;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;

import utils.UiBase;

import static org.junit.Assert.assertEquals;

public class BP_ViewOrdersAction extends PageObject{

	Logger logger= LoggerFactory.getLogger(BP_ViewOrdersAction.class);

	public UiBase uiBase = new UiBase();

	public static String orderNumber;
	public static String searchedOrderNumber;
	public static String productStatus;
	public static String Orderstatus;
	public static String orderPendingStatus;

	public boolean PageOpened() throws InterruptedException {
		if(uiBase.isElementDisplayed("OrderConfirmationPage:lblViewOrder")){
			return true;
		}
		return false;
	}

	public void clickToElement(String elementName) {
		switch (elementName) {
		case "Create Order button":
			uiBase.clickElement("ViewOrder:btnCreateOrder");
			break;
		case "View Info Icon":
			uiBase.clickElement("ViewOrder:ViewInfoIcon");
			break;
		case "Ok Button":
			uiBase.clickElement("ViewOrder:btnOk");
			break;
		}
	}

	public boolean verifytheTotalRecoundCount() {
		try {
			logger.info("User is verifying page record count is exist");
			if(uiBase.isElementDisplayed("ViewOrder:lblPagination")) {
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean searchbyOrderNumber() {
		try {
			logger.info("User is searching order number");
			if(uiBase.isElementDisplayed("ViewOrder:SearchByOrderNumber")) {
				uiBase.enterText("ViewOrder:SearchByOrderNumber", uiBase.getTestDataFromJson("ViewOrders:ProductNumber"));
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyproductdetailsByOrderNumber() {
		try {
			logger.info("User is verifying order details");
			searchedOrderNumber=uiBase.getTestDataFromJson("ViewOrders:ProductNumber");
			Orderstatus=uiBase.getTestDataFromJson("ViewOrders:status");
			//No of Columns
			List<WebElement>  columns = uiBase.getElementsFromJson("ViewOrder:NoOfTableColumns");

			System.out.println("No of columns : " +columns.size());

			//No of Rows

			List<WebElement>  rows=uiBase.getElementsFromJson("ViewOrder:NoOfTableRows");
			System.out.println("No of rows : " +rows.size());

			for (int i =0;i<rows.size();i++)
			{    
				orderNumber= uiBase.getText("ViewOrder:txtOrderNumber");
				productStatus=uiBase.getText("ViewOrder:txtOrderStatus");
				assertEquals(searchedOrderNumber,orderNumber);
				assertEquals(Orderstatus,productStatus);
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean searchbyProductID() throws InterruptedException {
		try {
			logger.info("User is search the product by product ID");
			if(uiBase.isElementDisplayed("ViewOrder:SearchByProductID")) {
				uiBase.enterText("ViewOrder:SearchByProductID", uiBase.getTestDataFromJson("ViewOrders:ProductID"));
				uiBase.getWaitForload();
				WebElement element=uiBase.getElementFromJson("ViewOrder:SearchByProductID");
				element.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyproductdetailsByProductID() {
		try {
			logger.info("User is search the product by product ID");
			List<WebElement>  rows =uiBase.getElementsFromJson("ViewOrder:NoOfTableRows");
			System.out.println("No of rows : " +rows.size());

			for (int i =0;i<rows.size();i++)
			{    
				orderNumber= uiBase.getText("ViewOrder:txtOrderNumber");
				System.out.println("Number of order displayed :" +orderNumber);

			}
			return true;

		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean searchOrderByPendingStatus() {
		logger.info("User is search order by pending status");
		if(uiBase.isElementDisplayed("ViewOrder:SearchByOrderNumber")) {
			uiBase.enterText("ViewOrder:SearchByOrderNumber", uiBase.getTestDataFromJson("ViewOrders:SrchPendingOrd"));
			return true;
		}
		return false;
	}

	public boolean deletePendingOrderfromList() {
		logger.info("User is deleting the pending Order");
		List<WebElement>  rows =uiBase.getElementsFromJson("ViewOrder:NoOfTableRows");
		System.out.println("No of rows : " +rows.size());
		for (int i =0;i<rows.size();i++)
		{    
			orderPendingStatus= uiBase.getText("ViewOrder:txtOrderStatus");
			productStatus=uiBase.getTestDataFromJson("ViewOrders:SrchPendingOrd");
			if(productStatus.equals(orderPendingStatus)) {
				uiBase.clickElement("ViewOrder:btnOrderDelete");
			}
			return true;
		}
		return false;
	}

	public boolean verifyOrderDeletionOverlay() throws InterruptedException {
		try {
			logger.info("User is verifying Order Deletion overlay");
			if(uiBase.isElementDisplayed("ViewOrder:btnOk")){
				uiBase.getWaitForload();
				uiBase.clickElement("ViewOrder:btnOk");
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyOrderDeletionAlertBox() {
		try {
			logger.info("User is verifying Order Deletion alert message");
			if(uiBase.isElementDisplayed("ViewOrder:lblAlertText")){
				String actualAlertMessage=uiBase.getText("ViewOrder:lblAlertText");
				String expectedAlertMessage=uiBase.getTestDataFromJson("ViewOrders:Message");
				assertEquals(actualAlertMessage,expectedAlertMessage);
				return true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	//	public boolean verifyDeletedOrderFromList() {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}




}


