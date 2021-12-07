package pagesActions.businessPortal;

import java.util.NoSuchElementException;

import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;
import utils.UiBase;

public class BP_ProductListAction extends PageObject{

	Logger logger= LoggerFactory.getLogger(BP_ProductListAction.class);

	public UiBase uiBase = new UiBase();

	public boolean verifytheProductOverlayPage() throws InterruptedException {
		try {
			logger.info("User is on product Overlay Page to select listed products");
			
			uiBase.waitUntilElementDisplayed("SalesPage:btnKitchenTools", 50);
			
			uiBase.clickElement("SalesPage:btnKitchenTools");
			uiBase.getElementFromJson("SalesPage:lnkFirstProduct").isDisplayed();
			
			Actions action = new Actions(getDriver());
			action.moveToElement(uiBase.getElementFromJson("SalesPage:lnkFirstProduct")).click().build().perform();
			uiBase.getElementFromJson("SalesPage:btnAddOrder").isDisplayed();
			action.moveToElement(uiBase.getElementFromJson("SalesPage:btnAddOrder")).click().build().perform();
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






}
