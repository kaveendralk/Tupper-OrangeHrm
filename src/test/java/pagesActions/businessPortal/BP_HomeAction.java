package pagesActions.businessPortal;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefinitions.businessPortal.BP_HomeStepDef;

public class BP_HomeAction extends PageObject {

    Logger logger= LoggerFactory.getLogger(BP_HomeAction.class);

    public void PageOpened(){
        System.out.println("Title is: "+getDriver().getTitle());

        logger.info("Title captured:---------------------");
    }
}
