package stepdefinitions.businessPortal;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.businessPortal.BP_HomePage;

import java.util.HashMap;

public class BP_HomeStepDef {

    Logger logger= LoggerFactory.getLogger(BP_HomeStepDef.class);

    @Steps
    BP_HomePage bp_homePage;

    @And("User verify that home page is appearing correctly")
    public void user_verify_home_page( ) throws PendingException {
        for(String key: bp_homePage.verifyHomePage().keySet()){
            if(!bp_homePage.verifyHomePage().get(key)){
            }
            Assert.assertTrue(key, bp_homePage.verifyHomePage().get(key));
        }
    }

    @And("User verify What's new tiles")
    public void user_verify_whats_new_tile( ) throws PendingException {
        Assert.assertTrue("What's New tile is not visible", bp_homePage.verifyWhatsNewTile());
    }
    @And("User verify Knowledge Center tiles")
    public void user_verify_knowledge_center_tile( ) throws PendingException {
        Assert.assertTrue("Knowledge center tile is not visible", bp_homePage.verifyKnowledgeCenterTile());
    }

    @And("User verify that all the menu links are coming correctly")
    public void user_verify_side_menu_links( ) throws PendingException, InterruptedException {
        HashMap<String, Boolean> map= bp_homePage.verifySideMenuLinks();
        for(String key: map.keySet()){
            if(!map.get(key)){
            }
            Assert.assertTrue(key, map.get(key));
        }
    }




}
