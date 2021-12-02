package pages.older;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pagesActions.older.BusinessPage;

@SuppressWarnings("serial")

public class SerenityBusinessSteps extends ScenarioSteps {

	BusinessPage businesspage;
	 	
	@Step
   	public boolean navigateToBusinessDashboardPage() throws Exception {
   		return businesspage.navigateToBusinessDashboardPage();
	}
	
	@Step
   	public boolean navigateToPersonalReportsAndVerify() throws Exception {
   		return businesspage.navigateToPersonalReportsAndVerify();
	}
	
	@Step
   	public boolean navigateToPersonalWebSite() throws Exception {
   		return businesspage.navigateToPersonalWebSite();
	}
}