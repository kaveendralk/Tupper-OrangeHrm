package pagesActions.businessPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;

import utils.UiBase;

public class BP_ProductListAction extends PageObject{

	Logger logger= LoggerFactory.getLogger(BP_ProductListAction.class);

	public UiBase uiBase = new UiBase();

	public boolean verifyTheProductOverlayPage() throws InterruptedException {
		try {
			logger.info("User is on product Overlay Page to select listed products");
			uiBase.waitUntilElementDisplayed("SalesPage:btnKitchenTools", 50);
			uiBase.clickElement("SalesPage:btnKitchenTools");
			Actions action = new Actions(getDriver());
			action.moveToElement(uiBase.getElementFromJson("SalesPage:firstProduct")).click().build().perform();
			uiBase.getWaitForload();
			uiBase.clickElement("SalesPage:addToOrderButtonOnOverlay");
			logger.info("User added the product on cart");
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;

	}



	public boolean verifytheAddedProduct() throws InterruptedException {
		try {
			logger.info("User verifying the added product on cart");
			uiBase.waitUntilElementDisplayed("SalesPage:txtpoductID", 50);
			//uiBase.getElementFromJson("SalesPage:txtpoductID").isDisplayed();
			String ActualproductId=uiBase.getElementFromJson("SalesPage:txtpoductID").getText();
			System.out.println("ActualproductId : "+ActualproductId);
			String ExpectedProductId=uiBase.getTestDataFromJson("AddedProductList:productID");
			System.out.println("ExpectedProductId : "+ExpectedProductId);

			String SubTot = uiBase.getElementFromJson("SalesPage:lblSubtotal").getText();
			System.out.println("SubTotal :" +SubTot);
			String QVol = uiBase.getElementFromJson("SalesPage:lblQVolume").getText();
			System.out.println("QVol :" +QVol);
			String CVol =uiBase.getElementFromJson("SalesPage:lblComVolume").getText();
			System.out.println("CVol :" +CVol);
			String RetProf =uiBase.getElementFromJson("SalesPage:lblRetaindedProf").getText();
			System.out.println("RetProf :" +RetProf);
			if(ActualproductId.equals(ExpectedProductId))
			{
				System.out.println("Added Product exist in Cart");
			}
			logger.info("User verified the added product on cart");
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addProductByIdOnCart() throws InterruptedException, AWTException {
		try {
			uiBase.getWaitForload();
			logger.info("User added product by SearchID on cart");
			uiBase.waitUntilElementDisplayed("SalesPage:inpAddNewItem", 15);
			uiBase.enterText("SalesPage:inpAddNewItem", uiBase.getTestDataFromJson("AddedProductList:ProductByID"));
			uiBase.getWaitForload();
			WebElement element=uiBase.getElementFromJson("SalesPage:inpAddNewItem");
			element.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
			logger.info("Search By ID product added");
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean addProductByNameOnCart() throws InterruptedException {
		try {
			logger.info("User added product by SearchID on cart");
			uiBase.getWaitForload();
			uiBase.waitUntilElementDisplayed("SalesPage:inpAddNewItem", 15);
			uiBase.enterText("SalesPage:inpAddNewItem", uiBase.getTestDataFromJson("AddedProductList:ProductName"));

			uiBase.getWaitForload();
			WebElement element=uiBase.getElementFromJson("SalesPage:inpAddNewItem");
			element.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;

	}


	public boolean verifyTheTotalOrderOfProductPrice() {
		try {
			String SubtotalPrice= uiBase.getText("SalesPage:lblSubtotal");
			double totalprice=Double.parseDouble(SubtotalPrice.replace("$", ""));

			System.out.println("SubTotal Price of Product :" +SubtotalPrice);

			List<WebElement> productList=getDriver().findElements(By.xpath("//div[@data-bind='text: subtotal']"));
			double sum=0;
			for(int i=0;i<productList.size();i++)
			{
				double price=Double.parseDouble(productList.get(i).getText().replace("$", ""));
				sum=sum+price;
				System.out.println("Total Unit Price :" +sum);
				System.out.println("Product Count "+productList.size());
				System.out.println("Unit Price of products unit price:" +price);
			}
			if(sum==totalprice)
			{
				System.out.println("Product price equals to Sum of added products");
			}
			return true;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}



	public boolean addProductWithMultipleCatagoryOnCart() {
		try {
			uiBase.getWaitForload();
			uiBase.isElementDisplayed("SalesPage:btnBrowse");
			uiBase.clickElement("SalesPage:btnBrowse");
			uiBase.isElementDisplayed("SalesPage:btnKidsToys");
			Actions action = new Actions(getDriver());
			action.moveToElement(uiBase.getElementFromJson("SalesPage:lnkSecondProductToys")).click().build().perform();

			uiBase.isElementDisplayed("SalesPage:btnAddToOrderPop");
			uiBase.clickElement("SalesPage:btnAddToOrderPop");
			uiBase.getWaitForload();
			uiBase.waitUntilElementDisplayed("SalesPage:btnBrowse", 30);
			uiBase.clickElement("SalesPage:btnBrowse");
			uiBase.isElementDisplayed("SalesPage:btnServeWare");
			uiBase.clickElement("SalesPage:btnServeWare");
			//uiBase.isElementDisplayed("SalesPage:lnkSecondProductBlackFri");
			action.moveToElement(uiBase.getElementFromJson("SalesPage:lnkSecondProductWare")).click().build().perform();
			uiBase.isElementDisplayed("SalesPage:btnAddToOrderPop");
			uiBase.clickElement("SalesPage:btnAddToOrderPop");
			return true;

		}catch(NoSuchElementException | InterruptedException e) {
			e.printStackTrace();
		}
		return false;

	}


	public boolean verifyProductWithMultipleCatagoryOnCart() throws InterruptedException {
		try {
			uiBase.isElementDisplayed("SalesPage:txtHandyProductID");
			String ActualProductID1=uiBase.getElementFromJson("SalesPage:txtHandyProductID").getText();
			System.out.println("ActualproductId : "+ActualProductID1);
			String ExpectedProductID1=uiBase.getTestDataFromJson("AddedProductList:ProductID1");
			System.out.println("ExpectedProductId : "+ExpectedProductID1);

			if(ActualProductID1.equals(ExpectedProductID1))
			{
				System.out.println("Added first Product exist in Cart");
			}

			uiBase.isElementDisplayed("SalesPage:txEcoProductID");
			Thread.sleep(5000);
			String ActualProductID2=uiBase.getElementFromJson("SalesPage:txEcoProductID").getText();
			System.out.println("ActualproductId : "+ActualProductID2);
			String ExpectedProductID2=uiBase.getTestDataFromJson("AddedProductList:productID2");
			System.out.println("ExpectedProductId : "+ExpectedProductID2);
			if(ActualProductID2.equals(ExpectedProductID2))
			{
				System.out.println("Added Second Product exist in Cart");
			}
			return true;

		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}


















}
