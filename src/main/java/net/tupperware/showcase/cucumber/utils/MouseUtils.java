package net.tupperware.showcase.cucumber.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MouseUtils extends PageObject {

	public MouseUtils(WebDriver driver){
		super(driver);
	}
	
	public  boolean mouseLeftClick(WebElementFacade element){
		try{
			Actions action = new Actions(getDriver());
			action.moveToElement(element).click(element).build().perform();
			return true;
		}catch(Throwable t){
		}
		
		return false;
	}
	
	public  boolean moveToElement(WebElementFacade element){
		try{
			Actions action = new Actions(getDriver());
			action.moveToElement(element).build().perform();
			return true;
		}catch(Throwable t){
		}
		
		return false;
	}

	public void clickUsingAction(WebElementFacade element){
		try{
			Actions customersCheckboxForExternal = new Actions(getDriver());
			customersCheckboxForExternal.click(element).build().perform();
		}catch(Throwable t){
		}
	}
	
	public void dragAndDropUsingJavaScript(WebElement from, WebElement to) {	
		try {		
		final String java_script =
				"var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
				                "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
				                "ction(format,data){this.items[format]=data;this.types.append(for" +
				                "mat);},getData:function(format){return this.items[format];},clea" +
				                "rData:function(format){}};var emit=function(event,target){var ev" +
				                "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
				                "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
				                "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
				                "'drop',tgt);emit('dragend',src);";
		((JavascriptExecutor)getDriver()).executeScript(java_script, from, to);
        Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
