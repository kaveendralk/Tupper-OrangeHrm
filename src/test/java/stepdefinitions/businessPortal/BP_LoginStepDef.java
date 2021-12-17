package stepdefinitions.businessPortal;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.businessPortal.BP_LoginPage;

public class BP_LoginStepDef {

    Logger logger= LogManager.getLogger(BP_LoginStepDef.class);

    @Steps
    BP_LoginPage bp_loginPage;

    public EnvironmentVariables env;
    @Given("User is on {string} Portal")
    public void user_is_on_Portal(String string) throws PendingException {
//If-else implement
//        String baseurl= EnvironmentSpecificConfiguration.from(env).getProperty("webdriver.base.url");
        bp_loginPage.openApplication();
        logger.info("User is on "+string+" portal");
    }

    @And("User login to the application with {string} on {string} Portal")
    public void user_login_to_the_application_with_County_User_on_Portal(String countyUser, String portal) throws InterruptedException {
        bp_loginPage.loginToPortal(countyUser);
        logger.info("User has logged in to the "+portal+" portal");
    }

}
