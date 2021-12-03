package pagesActions.older;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;
import utils.UiBase;

public class BusinessPage extends PageObject {

	WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public BusinessPage(WebDriver driver) {
		super(driver);
	}

	public UiBase uiBase = new UiBase();
	
	/* Navigate to dash board reports */
	public boolean navigateToBusinessDashboardPage() throws InterruptedException{ 
		try {
			Thread.sleep(1000);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkMyBusiness");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkDashboardReports");
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Navigate to personal reports */
	public boolean navigateToPersonalReportsAndVerify() throws InterruptedException{ 
		try {
			Thread.sleep(1000);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkMyBusiness2");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalReports");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPaymentSummary");
//			Thread.sleep(2000);
//			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessPage:lblWelcome").isDisplayed();
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkMyBusiness");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalReports");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalHistory");
//			Thread.sleep(2000);
//			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessPage:lblWelcome").isDisplayed();
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:hambergerMenu");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkMyBusiness");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalReports");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkYearEndSummary");
//			Thread.sleep(2000);
//			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessPage:lblWelcome").isDisplayed();
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkHome");
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Navigate to personal web site */
	public boolean navigateToPersonalWebSite() throws InterruptedException{ 
		try {
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lblWelcome");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:btnProfile");
//			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessPage:lnkPersonalWeb");
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
}

