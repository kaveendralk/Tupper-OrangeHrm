package pagesActions.older;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.UiBase;

public class PersonalWebsitePage extends PageObject {

	WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public PersonalWebsitePage(WebDriver driver) {
		super(driver);
	}

	public UiBase uiBase = new UiBase();

	@FindBy(how = How.XPATH, using = "//div[@class='box-shadow-menu']")
	public WebElementFacade hambergerMenu;
	
}