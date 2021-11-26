package net.tupperware.showcase.cucumber.steps.serenity;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import net.tupperware.showcase.cucumber.utils.LearningPlatformConstants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.tupperware.showcase.cucumber.pages.BusinessPage;
import net.tupperware.showcase.cucumber.pages.TupperLoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class SerenityLoginSteps extends ScenarioSteps {

public TupperLoginPage tupperloginpage;

	Logger logger = LoggerFactory.getLogger(SerenityLoginSteps.class);

		  /*This method is use to log in Tupperware consultant*/
		  @Step("Login to the Tupperware Application")
			public BusinessPage tupper_consultant_user_login(String userName, String password) {
			    WebDriver driver =  tupperloginpage.getDriver();
			    getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    tupperloginpage.open();
			    String envURL = getDriver().getCurrentUrl();
//			    System.out.println("The  get driver url is " + envURL);
			  logger.info("Driver URL is: "+envURL);
			    String newurl =envURL.concat("");
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      getDriver().navigate().to(newurl);
//			      System.out.println("The new url of the envURL" + newurl);
			  logger.info("New URL is: "+newurl);
				LearningPlatformConstants.environmentURL.set(envURL);
				return tupperloginpage.tupper_user_login(userName, password);	
			} 
		  
		 
	 
}