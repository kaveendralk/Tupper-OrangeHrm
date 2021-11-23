package net.tupperware.showcase.cucumber.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginationUtils extends PageObject{
	
	public PaginationUtils(WebDriver driver){
		super(driver);
	}
	
	public ElementUtils elementUtils = new ElementUtils(getDriver());
	
	public boolean verifyRecordDisplayed(WebDriver driver,WebElement pagescountText, WebElement nextButton,String searchText) {
		try {
			String[] strArr = pagescountText.getText().split(" of ");
			int totalRecords = Integer.parseInt(strArr[1].replaceAll(",",""));
			do {
				try {
					if (driver.getPageSource().contains(searchText)) {
						System.out.println("Created record is found");
						break;
					} else {
						((WebElementFacade) elementUtils.fluentWaitForElement(getDriver(), nextButton)).waitUntilVisible();
						((WebElementFacade) elementUtils.fluentWaitForElement(getDriver(), nextButton)).waitUntilClickable();
						((WebElementFacade) elementUtils.fluentWaitForElement(getDriver(), nextButton)).click();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while(totalRecords != 0);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}