package net.tupperware.showcase.cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.tupperware.showcase.cucumber.utils.ElementUtils;
import net.tupperware.showcase.cucumber.utils.LearningPlatformConstants;
import net.tupperware.showcase.cucumber.utils.ProjectUtils;
import net.serenitybdd.core.pages.PageObject;

public class TupperLoginPage extends PageObject {

	WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public TupperLoginPage(WebDriver driver) {
		super(driver);
	}

	public ElementUtils elementUtils = new ElementUtils(getDriver());
	
	String testDataJson = null;

	private String getTestDataJson(String fileName) {
		return System.getProperty("user.dir") + "/src/test/resources/testData/" + fileName;
	}
	
	/***
	 * This method is used to login into tupperware as a consultant
	 * 
	 * @param userName
	 * @param passWord
	 */
	public BusinessPage tupper_user_login(String userName, String passWord) {
		
//		String envProp = System.getProperty("testDataEnv");
		String envProp = "staging";
		ProjectUtils projectUtils = new ProjectUtils();

		if (envProp.equalsIgnoreCase("staging")) {
			testDataJson = getTestDataJson("tupperStaging.json");
		}
		
		userName = projectUtils.jsonReader(testDataJson, userName).toString();
		passWord = projectUtils.jsonReader(testDataJson, passWord).toString();
		
		try {
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			elementUtils.enterText(getDriver(),"Tupperware.json","TupperLoginPage:txtUsername",userName);
			elementUtils.enterText(getDriver(),"Tupperware.json","TupperLoginPage:txtPassword",passWord);	
			Actions action = new Actions(getDriver());
			action.moveToElement(elementUtils.getElementFromJson(getDriver(),"Tupperware.json","TupperLoginPage:btnSubmit")).click().perform();
			String envURL = getDriver().getCurrentUrl();
			LearningPlatformConstants.environmentURL.set(envURL);
			BusinessPage dashboardspage = this.switchToPage(BusinessPage.class);
			return dashboardspage;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null  ;
	}
	
	
}
