package pagesActions.older;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.UiBase;

public class SalesPage extends PageObject {

	WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public SalesPage(WebDriver driver) {
		super(driver);
	}
	public UiBase uiBase = new UiBase();

	@FindBy(how = How.XPATH, using = "//button[. = 'Browse Products']")
	public WebElementFacade btnBrowse;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Kitchen Tools']")
	public WebElementFacade btnKitchenTools;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Cookware & Bakeware']")
	public WebElementFacade btnCookware;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Food Storage']")
	public WebElementFacade btnFoodStorage;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Serveware']")
	public WebElementFacade btnServeware;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Collections']")
	public WebElementFacade btnCollections;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Business Supplies']")
	public WebElementFacade btnBusinessSupplies;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Kitchen Tools']//following::div[@class ='product-details'][1]")
	public WebElementFacade lnkFirstProduct;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Kitchen Tools']//following::div[@class ='product-details'][2]")
	public WebElementFacade lnkSecondProduct;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Kitchen Tools']//following::span[. = 'Add to Order'][1]")
	public WebElementFacade btnAddToOrder;
	
	@FindBy(how = How.XPATH, using = "//li[. = 'Kitchen Tools']//following::span[. = 'Add to Order'][2]")
	public WebElementFacade btnAddToOrder2;
	
	@FindBy(how = How.XPATH, using = "//Button[. = 'Add to Order']")
	public WebElementFacade btnAddToOrderPop;	
	
	@FindBy(how = How.XPATH, using = "//input[@class= 'ac_input']")
	public WebElementFacade inpAddNewItem;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), '02-3617')]")
	public WebElementFacade lblItemCode;
	
	@FindBy(how = How.XPATH, using = "(//*[contains( text(), 'Thatsa¨ Medium Bowl')])[1]")
	public WebElementFacade lblItem;
		
	@FindBy(how = How.XPATH, using = "//button[. = 'Checkout']")
	public WebElementFacade btnCheckout;
	
	@FindBy(how = How.XPATH, using = "//*[@class= 'summary-amount subtotal']")
	public WebElementFacade lblSubtotal;
	
	@FindBy(how = How.XPATH, using = "//*[@class= 'summary-amount subtotal']//following::span[@data-bind= 'text: AmountString'][1]")
	public WebElementFacade lblQVolume;
	
	@FindBy(how = How.XPATH, using = "//*[@class= 'summary-amount subtotal']//following::span[@data-bind= 'text: AmountString'][3]")
	public WebElementFacade lblComVolume;
	
	@FindBy(how = How.XPATH, using = "//*[@class= 'summary-amount subtotal']//following::span[@data-bind= 'text: AmountString'][3]")
	public WebElementFacade lblRetaindedProf;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Add Payment']")
	public WebElementFacade btnAddPayment;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Submit']")
	public WebElementFacade btnSubmit;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Submit Party']")
	public WebElementFacade btnSubmitParty;
	
	@FindBy(how = How.XPATH, using = "//*[@name = 'commit']")
	public WebElementFacade btnNext;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), 'Order Number:')]//following::span[@data-bind= 'text: Total'][1]")
	public WebElementFacade lblSubTotal;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), 'Order Number:')]//following::*[contains( text(), 'Accepted')][1]")
	public WebElementFacade lblStatusAccepted;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), 'Order Number:')]//following::span[@data-bind= 'text: Total()'][1]")
	public WebElementFacade lblCV;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), 'Order Number:')]//following::span[@data-bind= 'text: Total()'][2]")
	public WebElementFacade lblQV;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), 'Order Number:')]//following::span[@data-bind= 'text: Total()'][3]")
	public WebElementFacade lblRP;
	
	@FindBy(how = How.XPATH, using = "//button[.='Add New Card']")
	public WebElementFacade btnAddNewCard;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Finish']")
	public WebElementFacade btnFinish;
	
	@FindBy(how = How.XPATH, using = "//input[@name='bill_to_forename']")
	public WebElementFacade inpFName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='bill_to_surname']")
	public WebElementFacade inpSName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='bill_to_address_line1']")
	public WebElementFacade inpAddress1;
	
	@FindBy(how = How.XPATH, using = "//input[@name='bill_to_address_city']")
	public WebElementFacade inpCity;
	
	@FindBy(how = How.XPATH, using = "//select[@name='bill_to_address_state_us_ca']")
	public WebElementFacade selState;
	
	@FindBy(how = How.XPATH, using = "//input[@name='bill_to_address_postal_code']")
	public WebElementFacade inpPostalCode;
	
	@FindBy(how = How.XPATH, using = "//input[@id='card_type_001']")
	public WebElementFacade rdoCardType;
	
	@FindBy(how = How.XPATH, using = "//input[@id='card_number']")
	public WebElementFacade inpCardNo;
	
	@FindBy(how = How.XPATH, using = "//select[@id='card_expiry_month']")
	public WebElementFacade selMonth;
	
	@FindBy(how = How.XPATH, using = "//select[@id='card_expiry_year']")
	public WebElementFacade selYear;
	
	@FindBy(how = How.XPATH, using = "//input[@id='card_cvn']")
	public WebElementFacade inpCVN;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Select Party Host']")
	public WebElementFacade btnSelectPartyHost;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Create New Host']")
	public WebElementFacade btnCreateNewHost;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Create New Guest']")
	public WebElementFacade btnCreateNewGuest;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'GivenName']")
	public WebElementFacade inpHostFName;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'FamilyName']")
	public WebElementFacade inpHostSName;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'Email']")
	public WebElementFacade inpHostEmail;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'Phone1']")
	public WebElementFacade inpHostPhone;
		
	@FindBy(how = How.XPATH, using = "//input[@name = 'Line1']")
	public WebElementFacade inpHostAddLine1;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'City']")
	public WebElementFacade inpHostCity;
	
	@FindBy(how = How.XPATH, using = "//select[@name = 'StateProvince']")
	public WebElementFacade selHostProvince;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'PostalCode']")
	public WebElementFacade inpHostPostalCode;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Proceed']")
	public WebElementFacade btnProceed;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Cancel']")
	public WebElementFacade btnCancel;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder= 'Search by name or email']")
	public WebElementFacade inpSearchHost;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), 'James 20')]")
	public WebElementFacade lnkSelectSearchedHost;
	
	@FindBy(how = How.XPATH, using = "//*[contains( text(), 'James 20')]")
	public WebElementFacade lnkSelectSearchedGuest;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'EventName']")
	public WebElementFacade inpEventName;
	
	@FindBy(how = How.XPATH, using = "//select[@name = 'TimeZone']")
	public WebElementFacade selTimeZone;
	
	@FindBy(how = How.XPATH, using = "//button[.='Save']")
	public WebElementFacade btnSave;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Add Guest']")
	public WebElementFacade btnAddGuest;
	
	@FindBy(how = How.XPATH, using = "//*[.= 'Not Invited']//parent::div[1]//following::div[1]")
	public WebElementFacade lblNotInvitedCount;
	
	@FindBy(how = How.XPATH, using = "//button[.= 'Send Invite']")
	public WebElementFacade btnSendInvite;
	
	@FindBy(how = How.XPATH, using = "//input[@name= 'template']//parent::span")
	public WebElementFacade lnkMailTemplate;
	
	@FindBy(how = How.XPATH, using = "//button[.= 'Send']")
	public WebElementFacade btnSend;
		
	@FindBy(how = How.XPATH, using = "//*[.= 'Not Invited']//parent::div[1]//following::div[3]")
	public WebElementFacade lblInvitedCount;
	
	@FindBy(how = How.XPATH, using = "//*[text()= 'Invited']")
	public WebElementFacade lblInvited;
	
	@FindBy(how = How.XPATH, using = "//span[.= 'Manage Invitations']")
	public WebElementFacade lnkManageInvitations;
	
	@FindBy(how = How.XPATH, using = "//span[.= 'Party Orders']")
	public WebElementFacade lnkPartyOrders;
	
	@FindBy(how = How.XPATH, using = "//span[.= 'Review & Submit']")
	public WebElementFacade lnkReviewSubmit;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Add Guest']//following::span[.= 'View Cart'][3]")
	public WebElementFacade btnViewCart3;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Add Guest']//following::span[.= 'View Cart'][2]")
	public WebElementFacade btnViewCart2;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Add Guest']//following::span[.= 'View Cart'][1]")
	public WebElementFacade btnViewCart1;
	
	@FindBy(how = How.XPATH, using = "//*[.= 'Back To Manage Parties']")
	public WebElementFacade lnkBackToManageParties;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'Name']")
	public WebElementFacade inpGuestName;
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'Phone']")
	public WebElementFacade inpGuestPhone;
	
	@FindBy(how = How.XPATH, using = "//button[.= 'Create Account']")
	public WebElementFacade btnCreateAccount;
	
	@FindBy(how = How.XPATH, using = "//input[@name='FamilyName']")
	public WebElementFacade btnFamilyName;
	
	@FindBy(how = How.XPATH, using = "//button[. = 'Cancel']//following::button[. = 'Add Guest']")
	public WebElementFacade btnAddGuestPop;
	
	@FindBy(how = How.XPATH, using = "//input[@type = 'search']")
	public WebElementFacade inpSearchItem;
	
	@FindBy(how = How.XPATH, using = "//button[@aria-label= 'Chef Series II Gourmet Set Select for details']")
	public WebElementFacade lblSearchedItem;
	
	@FindBy(how = How.XPATH, using = "//button[.= 'Add to Cart']")
	public WebElementFacade btnAddtoCart;
		
	public static String timeStamp;
	public static String timeStp;
	
	/* Create personal order */
	public boolean createPersonalOrder(String itemCode, String fName, String sName, String address1, String city, String postalCode, String cardNo, String cvn, String month, String year, String state) throws InterruptedException{ 
		try {
			Thread.sleep(8000);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			elementUtils.fluentWaitForElement(getDriver(),btnBrowse).click();
			Thread.sleep(8000);
//			elementUtils.fluentWaitForElement(getDriver(),btnKitchenTools).isVisible();
//			elementUtils.fluentWaitForElement(getDriver(),btnKitchenTools).click();
//			elementUtils.fluentWaitForElement(getDriver(),lnkFirstProduct).isVisible();
//			elementUtils.fluentWaitForElement(getDriver(),lnkFirstProduct).click();
//			elementUtils.fluentWaitForElement(getDriver(),btnAddToOrderPop).isVisible();
//			elementUtils.fluentWaitForElement(getDriver(),btnAddToOrderPop).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),btnBrowse).click();
//			Thread.sleep(6000);
//			elementUtils.fluentWaitForElement(getDriver(),btnKitchenTools).isVisible();
//			elementUtils.fluentWaitForElement(getDriver(),btnKitchenTools).click();	
//			Actions action = new Actions(getDriver());
//			action.moveToElement(lnkFirstProduct).click().build().perform();
//			Actions actionSelect = new Actions(getDriver());
//			actionSelect.moveToElement(btnAddToOrder).click().build().perform();			
//			withAction().moveToElement(element(lnkFirstProduct)).moveToElement(element(btnAddToOrder)).click().build().perform();		
			Thread.sleep(1000);
//			String SubTot = elementUtils.fluentWaitForElement(getDriver(),lblSubtotal).getTextValue();
//			String QVol = elementUtils.fluentWaitForElement(getDriver(),lblQVolume).getTextValue();
//			String CVol =elementUtils.fluentWaitForElement(getDriver(),lblComVolume).getTextValue();
//			String RetProf =elementUtils.fluentWaitForElement(getDriver(),lblRetaindedProf).getTextValue();
//			elementUtils.fluentWaitForElement(getDriver(),btnCheckout).click();
			Thread.sleep(2000);
			this.paymentGateway(fName, sName, address1, city, postalCode, cardNo, cvn, month, year, state);
			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),btnSubmit).click();
//			Thread.sleep(4000);
//			String SubTototal = elementUtils.fluentWaitForElement(getDriver(),lblSubTotal).getTextValue();
//			String CV = elementUtils.fluentWaitForElement(getDriver(),lblCV).getTextValue();
//			String QV = elementUtils.fluentWaitForElement(getDriver(),lblQV).getTextValue();
//			String RP = elementUtils.fluentWaitForElement(getDriver(),lblRP).getTextValue();
//			elementUtils.fluentWaitForElement(getDriver(),lblStatusAccepted).isDisplayed();
//			if (SubTot.equals(SubTototal) && QVol.equals(QV) /*&& CVol.equals(CV)*/ && RetProf.equals(RP)){
			return true;
//			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Add item to list */
	public boolean addItemToList() throws InterruptedException{ 
		try {	
//			elementUtils.fluentWaitForElement(getDriver(),btnBrowse).click();
//			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),inpSearchItem).sendKeys("Chef Series II Gourmet Set");
//			elementUtils.fluentWaitForElement(getDriver(),lblSearchedItem).click();
//			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),btnAddtoCart).click();
			Thread.sleep(1000);
			return true;		 
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Create party */
	public boolean createParty(String fName, String email, String phone, String address1, String city, String postalCode, String eventName, String cardNo, String cvn, String month, String year, String state) throws InterruptedException{ 
		try {	
			this.createNewPartyAndHost(fName, email, phone, address1, city, postalCode, eventName);
			this.manageInvitation(fName, email, phone, address1, city, postalCode);
			this.partyOrders(fName, email, phone, address1, city, postalCode, eventName);
			this.paymentGateway(fName, eventName, address1, city, postalCode, cardNo, cvn, month, year, state);
//			elementUtils.fluentWaitForElement(getDriver(),btnSubmitParty).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),lnkBackToManageParties).click();
			return true;		 
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Create new party and host */
	public boolean createNewPartyAndHost(String fName, String email, String phone, String address1, String city, String postalCode, String eventName) throws InterruptedException{ 
		try {	
//			elementUtils.fluentWaitForElement(getDriver(),btnSelectPartyHost).click();
//			Thread.sleep(8000);
////			this.createHost(fName, email, phone, address1, city, postalCode);
//			elementUtils.fluentWaitForElement(getDriver(),inpSearchHost).typeAndEnter(email);
//			Thread.sleep(500);
//			elementUtils.fluentWaitForElement(getDriver(),lnkSelectSearchedHost).click();
//			Thread.sleep(10000);
//			elementUtils.fluentWaitForElement(getDriver(),inpEventName).sendKeys(eventName);
//			elementUtils.fluentWaitForElement(getDriver(),selTimeZone).click();
//			Actions action = new Actions(getDriver());
//			action.sendKeys("(UTC-8:00) Atlantic Time)", Keys.chord(Keys.ENTER)).perform();
//			elementUtils.fluentWaitForElement(getDriver(),btnSave).click();
			Thread.sleep(5000);
			return true;		 
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Manage Invitations*/
	public boolean manageInvitation(String fName, String email, String phone, String address1, String city, String postalCode) throws InterruptedException{ 
		try {	
			Thread.sleep(5000);
//			elementUtils.fluentWaitForElement(getDriver(),lnkManageInvitations).click();
//			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),btnAddGuest).click();
//			Thread.sleep(1000);
//			this.createNewGuest(fName, email, phone);
//			elementUtils.fluentWaitForElement(getDriver(),lblNotInvitedCount).getTextValue().equals("1");
//			elementUtils.fluentWaitForElement(getDriver(),btnSendInvite).click();
//			elementUtils.fluentWaitForElement(getDriver(),lnkMailTemplate).click();
//			elementUtils.fluentWaitForElement(getDriver(),btnSend).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),lblInvitedCount).getTextValue().equals("1");
//			elementUtils.fluentWaitForElement(getDriver(),lblInvited).isDisplayed();
			return true; 
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Party orders*/
	public boolean partyOrders(String fName, String email, String phone, String address1, String city, String postalCode, String eventName) throws InterruptedException{ 
		try {	
//			elementUtils.fluentWaitForElement(getDriver(),lnkPartyOrders).click();
//			elementUtils.fluentWaitForElement(getDriver(),btnCreateAccount).click();
//			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),btnFamilyName).sendKeys("Family");
//			elementUtils.fluentWaitForElement(getDriver(),btnAddGuestPop).click();
//			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),btnViewCart3).click();
//			Thread.sleep(5000);
//			this.addItemToList();
//			elementUtils.fluentWaitForElement(getDriver(),btnCheckout).click();
//			elementUtils.fluentWaitForElement(getDriver(),lnkManageInvitations).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),lnkPartyOrders).click();
//			elementUtils.fluentWaitForElement(getDriver(),btnViewCart2).click();
//			Thread.sleep(5000);
//			this.addItemToList();
//			elementUtils.fluentWaitForElement(getDriver(),btnCheckout).click();
//			elementUtils.fluentWaitForElement(getDriver(),lnkManageInvitations).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),lnkPartyOrders).click();
//			elementUtils.fluentWaitForElement(getDriver(),btnViewCart1).click();
//			Thread.sleep(5000);
//			this.addItemToList();
//			elementUtils.fluentWaitForElement(getDriver(),btnCheckout).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),lnkReviewSubmit).click();
			Thread.sleep(2000);
			return true; 
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Create a host */
	public boolean createHost(String fName, String email, String phone, String address1, String city, String postalCode) throws InterruptedException{ 
		try {			 
//			elementUtils.fluentWaitForElement(getDriver(),btnCreateNewHost).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),inpHostFName).sendKeys(fName);
//			timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//			elementUtils.fluentWaitForElement(getDriver(),inpHostSName).sendKeys(timeStamp);
//			elementUtils.fluentWaitForElement(getDriver(),inpHostEmail).sendKeys(email);
//			elementUtils.fluentWaitForElement(getDriver(),inpHostPhone).sendKeys(phone);
//			elementUtils.fluentWaitForElement(getDriver(),inpHostAddLine1).sendKeys(address1);
//			elementUtils.fluentWaitForElement(getDriver(),inpHostCity).sendKeys(city);
//			elementUtils.fluentWaitForElement(getDriver(),selHostProvince).click();
//			Actions action = new Actions(getDriver());
//			action.sendKeys("Alberta", Keys.chord(Keys.ENTER)).perform();
//			elementUtils.fluentWaitForElement(getDriver(),inpHostPostalCode).sendKeys(postalCode);
//			elementUtils.fluentWaitForElement(getDriver(),btnCreateNewHost).click();
//			Thread.sleep(2000);
//			elementUtils.fluentWaitForElement(getDriver(),btnProceed).click();
			Thread.sleep(1000); 	
			return true;		 
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Create a new guest */
	public boolean createNewGuest(String fName, String email, String phone) throws InterruptedException{ 
		try {	
			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),btnCreateNewGuest).click();
//			Thread.sleep(2000);
//			timeStp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//			elementUtils.fluentWaitForElement(getDriver(),inpGuestName).sendKeys(fName + timeStp);
//			elementUtils.fluentWaitForElement(getDriver(),inpHostEmail).sendKeys(timeStp+email);
//			elementUtils.fluentWaitForElement(getDriver(),inpGuestPhone).sendKeys(phone);
//			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),btnSave).click();
//			Thread.sleep(1000);
//			elementUtils.fluentWaitForElement(getDriver(),btnSave).click();
			Thread.sleep(1000); 
			return true;		 
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
		
	/* payment gateway */
	public boolean paymentGateway(String fName, String sName, String address1, String city, String postalCode, String cardNo, String cvn, String month, String year, String state) throws InterruptedException{ 
		try {
//			elementUtils.fluentWaitForElement(getDriver(),btnAddPayment).click();
//			elementUtils.fluentWaitForElement(getDriver(),btnAddNewCard).click();
//			elementUtils.fluentWaitForElement(getDriver(),inpFName).clear();
//			elementUtils.fluentWaitForElement(getDriver(),inpFName).sendKeys(fName);
//			elementUtils.fluentWaitForElement(getDriver(),inpSName).clear();
//			elementUtils.fluentWaitForElement(getDriver(),inpSName).sendKeys(sName);
//			elementUtils.fluentWaitForElement(getDriver(),inpAddress1).clear();
//			elementUtils.fluentWaitForElement(getDriver(),inpAddress1).sendKeys(address1);
//	 		elementUtils.fluentWaitForElement(getDriver(),inpCity).clear();
//			elementUtils.fluentWaitForElement(getDriver(),inpCity).sendKeys(city);
//			elementUtils.fluentWaitForElement(getDriver(),selState).click();
//			Actions action = new Actions(getDriver());
//			action.sendKeys(state, Keys.chord(Keys.ENTER)).perform();
//			elementUtils.fluentWaitForElement(getDriver(),inpPostalCode).clear();
//			elementUtils.fluentWaitForElement(getDriver(),inpPostalCode).sendKeys(postalCode);
//			elementUtils.fluentWaitForElement(getDriver(),rdoCardType).click();
//			elementUtils.fluentWaitForElement(getDriver(),inpCardNo).clear();
//			elementUtils.fluentWaitForElement(getDriver(),inpCardNo).sendKeys(cardNo);
//			elementUtils.fluentWaitForElement(getDriver(),selMonth).click();
//			action.sendKeys(month, Keys.chord(Keys.ENTER)).perform();
//			elementUtils.fluentWaitForElement(getDriver(),selYear).click();
//			action.sendKeys(year, Keys.chord(Keys.ENTER)).perform();
//			elementUtils.fluentWaitForElement(getDriver(),inpCVN).clear();
//			elementUtils.fluentWaitForElement(getDriver(),inpCVN).sendKeys(cvn);
//			elementUtils.fluentWaitForElement(getDriver(),btnNext).click();
			Thread.sleep(2000);		
			return true;
	} catch (NoSuchElementException e) {
		e.printStackTrace();
	} 
	return false;
}
	
	

}
