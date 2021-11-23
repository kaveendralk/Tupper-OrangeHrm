package net.tupperware.showcase.cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.tupperware.showcase.cucumber.pages.BusinessDashboardPage;

@SuppressWarnings("serial")

public class SerenityBusinessDashboardSteps extends ScenarioSteps {

	BusinessDashboardPage businessdashboardpage;
	 	
	@Step
   	public boolean checkReportsLoading() throws Exception {
   		return businessdashboardpage.checkReportsLoading();
	}
	
	@Step
   	public boolean navigateToCreatePersonalOrderPage() throws Exception {
   		return businessdashboardpage.navigateToCreatePersonalOrderPage();
	}
	
	@Step
   	public boolean navigateToCreateParty() throws Exception {
   		return businessdashboardpage.navigateToCreateParty();
	}
}