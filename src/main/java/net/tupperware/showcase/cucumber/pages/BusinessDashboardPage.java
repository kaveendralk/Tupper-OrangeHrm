package net.tupperware.showcase.cucumber.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.tupperware.showcase.cucumber.utils.ElementUtils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BusinessDashboardPage extends PageObject {

	WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public BusinessDashboardPage(WebDriver driver) {
		super(driver);
	}

	public ElementUtils elementUtils = new ElementUtils(getDriver());

	/* Check report loading */
	public boolean checkReportsLoading() throws InterruptedException{ 
		try {
			Thread.sleep(1000);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:tabOrgGrowth");
			Thread.sleep(1000);
			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessDashboardPage:lblMyOrganization").isDisplayed();
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:tabDirectorGrowth");
			Thread.sleep(1000);
			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessDashboardPage:btnRefresh").isDisplayed();
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:tabWYD");
			Thread.sleep(1000);
			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessDashboardPage:lblCurrent").isDisplayed();
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:tabThisMonth");
			Thread.sleep(1000);
			elementUtils.getElementFromJson(getDriver(),"Tupperware.json","BusinessDashboardPage:lblMaintain").isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/* Navigate to create personal order */
	public boolean navigateToCreatePersonalOrderPage() throws InterruptedException{ 
		try {
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:hambergerMenu");
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkSales");
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkPersonalOrder");
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	/* Navigate to create party */
	public boolean navigateToCreateParty() throws InterruptedException{ 
		try {
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:hambergerMenu");
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkSales");
			elementUtils.clickElement(getDriver(),"Tupperware.json","BusinessDashboardPage:lnkPartyOrder");
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return false;
	}
}

