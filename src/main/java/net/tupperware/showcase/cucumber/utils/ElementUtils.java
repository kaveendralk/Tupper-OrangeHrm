package net.tupperware.showcase.cucumber.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementUtils extends PageObject {
	
	public ElementUtils(WebDriver driver){
		super(driver);
	}
	
	/***
	 * This method will select the CheckBox
	 * @param element
	 * @return
	 */
	public boolean selectCheckBox(WebElement element){
		
		if(element.isSelected()){
			return true;
		}else
		{
			element.click();
			return true;
		}
		
	}
	
	/***
	 * This method will un-select the CheckBox
	 * @param element
	 * @return
	 */
	public boolean unSelectCheckBox(WebElement element){
		
		if(element.isSelected()){
			element.click();
			return true;
		}else
		{
			return true;
		}
		
	}
	
	
	/***
	 * This method will Returns today's date in MM/DD/YYYY Format
	 * @param element
	 * @return
	 */
	public String TodaysDate() throws Exception {
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(date);
	    return strDate;
	}

	
	/***
	 * This method is used to highlight a WebElement
	 * @param element
	 * @param duration
	 * @throws InterruptedException
	 */
	public void highlightElement(WebElement element, int duration) throws InterruptedException {
        String original_style = element.getAttribute("style");
        JavascriptExecutor js;
        js = (JavascriptExecutor)getDriver();
        js.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 2px solid red; border-style: dashed;");

        if (duration > 0) {
            Thread.sleep(duration * 1000);
            js.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    element,
                    "style",
                    original_style);
        }
    }
	
	/**
	 * JavaScript click Method 
	 * @param element
	 * @throws Exception
	 */
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	
	 /**
     * <h1>Wait for an element</h1>
     * <p>
     * Wait until the element is visible. If the element is visible within the
     * specified time, then it returns the element else null.
     * </p>
     *
     * @param driver
     * @param element
     * @return boolean
     */
    public  WebElementFacade fluentWaitForElement(WebDriver driver, WebElementFacade element) {
    	WebElementFacade foundElement = null;
        try {       
                Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                        .withTimeout(10, TimeUnit.SECONDS)
                        .pollingEvery(1 , TimeUnit.SECONDS)
                        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);      		
                foundElement = (WebElementFacade) fluentWait.until(visibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundElement;
    }
    
    /**
     * <h1>Wait for an element</h1>
     * <p>
     * Wait until the element is visible. If the element is visible within the
     * specified time, then it returns the element else null.Krishna
     * </p>
     *
     * @param driver
     * @param element
     * @return boolean
     */
    public  WebElementFacade fluentLongWaitForElement(WebDriver driver, WebElementFacade element) {
    	WebElementFacade foundElement = null;
        try {       
                Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                        .withTimeout(120, TimeUnit.SECONDS)
                        .pollingEvery(1, TimeUnit.SECONDS)
                        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);      		
                foundElement = (WebElementFacade) fluentWait.until(visibilityOfElementLocated(element));
                 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foundElement;
    }
    
    /**
     * <h1>Wait for an element</h1>
     * <p>
     * Wait until the element is visible. If the element is visible within the
     * specified time, then it returns the element else null.
     * </p>
     *
     * @param driver
     * @param element
     * @return boolean
     */
    public  WebElement fluentWaitForElement(WebDriver driver, WebElement element) {
    	WebElement foundElement = null;
        try {       
                Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                        .withTimeout(90, TimeUnit.SECONDS)
                        .pollingEvery(5 , TimeUnit.SECONDS)
                        .ignoring(NoSuchElementException.class);
                foundElement = fluentWait.until(visibilityOfElementLocated(element));
                return foundElement;
                 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foundElement;
    }
   
    public  boolean fluentWaitForElementDissapear(WebDriver driver, By by ) {
    	//WebElement foundElement = null;
    	boolean isElementDisappeared = false;
        try {       
                Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                        .withTimeout(120, TimeUnit.SECONDS)
                        .pollingEvery(2 , TimeUnit.SECONDS)
                        .ignoring(NoSuchElementException.class);
                isElementDisappeared = fluentWait.until(ExpectedConditions.invisibilityOfElementLocated((By) by));
                System.out.println("The value of found element is  " + isElementDisappeared);
                return true;
                 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean selectDropdownValue(WebElement element,String value) {
        try{
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
 
    /**
     * 
     * @param element
     * @return
     */
    private  ExpectedCondition<WebElement> visibilityOfElementLocated(
            final WebElement element) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element.isDisplayed() ? element : null;
            }
        };
    }
    
    public String getFirstSelectedValue(WebElement element) {
        try {
            Select dropdown = new Select(element);
            return dropdown.getFirstSelectedOption().getText();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
   public List<WebElement> getAllDropdownValues(WebElement element) {
        try {
            Select dropdown = new Select(element);
            return dropdown.getOptions();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
   public void scrollToElement(WebDriver driver, WebElement element) {
       try {
       ((JavascriptExecutor) driver).executeScript(
               "arguments[0].scrollIntoView();", element);
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
  public void scrollToBottom(WebDriver driver) {
       try {
       ((JavascriptExecutor) driver)
               .executeScript("window.scrollBy(0, 250)","");
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
  public void scrollToTop(WebDriver driver) {
       try {
       ((JavascriptExecutor) driver)
               .executeScript("window.scrollBy(0, -250)","");
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
  
  public boolean isAlertPresent(Alert alert,String button) {
      try {
    	  if(button.equals("OK")) {
    		  System.out.println(alert.getText());
    		  alert.accept();
    		  getDriver().switchTo().defaultContent();
    	  } else if(button.equals("Cancel")) {
    		  System.out.println(alert.getText());
    		  alert.dismiss();
    	  }
          return true;
      } catch (NoAlertPresentException e) {
          e.printStackTrace();
      }
      return false;
  }
  
  public String getBrowserName(WebDriver driver) {
	  try {
		  RemoteWebDriver remoteDriver = (RemoteWebDriver) ((WebDriverFacade) driver).getProxiedDriver();
		  String browserName=remoteDriver.getCapabilities().getBrowserName();
		  return browserName;
	  } catch(Exception e) {
	     e.printStackTrace();
	  }
	  return null;
  }
  
  public String getOSName() {
	  try {
		  String OSName =System.getProperty("os.name").toLowerCase();
		  return OSName;
	  } catch(Exception e) {
	     e.printStackTrace();
	  }
	  return null;
  }
  
  public void waitForPageLoaded() {
      ExpectedCondition<Boolean> expectation = new
              ExpectedCondition<Boolean>() {
                  public Boolean apply(WebDriver driver) {
                      return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                  }
              };
      try {
          Thread.sleep(2000);
          WebDriverWait wait = new WebDriverWait(getDriver(), 30);
          wait.until(expectation);
      } catch (Throwable error) {
    	  error.printStackTrace();
      }
  }
  
  public List<WebElement> getAllWebElements(By by) {
      try {
         
          return getDriver().findElements(by);
      } catch(Exception e) {
          e.printStackTrace();
      }
      return null;
  }

    /**
     * Wait for element is visible
     * @param driver
     * @param element
     * @return
     */
    public boolean explicitWaitForElement(WebDriver driver, WebElement element){
        try {
            WebDriverWait explicitWait = new WebDriverWait(driver, 60);
            explicitWait.until(visibilityOfElementLocated(element));
            Thread.sleep(1000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    /**
     * Wait for element is visible
     * @param driver
     * @param element
     * @param time
     * @return
     */
    public WebElementFacade explicitWaitForElement(WebDriver driver, WebElementFacade element, int time){
            WebDriverWait explicitWait = new WebDriverWait(driver, time);
            explicitWait.until(visibilityOfElementLocated(element));
            return element;
     }
    
    
    /**
     * Wait for element to become visible
     * @param driver
     * @param By element
     * @param time
     * @return
     */
    public WebElementFacade explicitWaitForElementInvisibility(WebDriver driver, By element, int time){
        WebDriverWait explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        return (WebElementFacade) driver.findElement(element);
 }
    
    /**
     * Wait for element to become visible
     * @param driver
     * @param By element
     * @param time
     * @return
     */
    
    public List<WebElement> explicitWaitForListOfElements(WebDriver driver, List<WebElement> element, int waitInSeconds) {
		new WebDriverWait(driver, waitInSeconds).until(ExpectedConditions.visibilityOfAllElements(element));
		return element;
	}

    /*
	    This method will Returns Tomorrow's date in MM/DD/YYYY Format
	 */
    public String TomorrowDate(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String tomorrowDate = formatter.format(dt);
        return  tomorrowDate;
    }

    /*
        select value from dropdown
     */
    public boolean selectValueFromDropDown(WebElementFacade element, String text){

        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            Thread.sleep(500);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    
    public boolean isElementPresent(List<WebElementFacade> elements) {
		// TODO Auto-generated method stub
		return (elements.size()>0);
	}
    
    
    public void enterText(WebDriver driver, String jsonPath, String locatorPath, String text) {
		WebElement actualElement = getElementFromJson(driver,jsonPath,locatorPath);
		actualElement.clear();
		actualElement.sendKeys(text);
	}

	public void clickElement(WebDriver driver, String jsonPath, String locatorPath) {
		WebElement actualElement = getElementFromJson(driver,jsonPath, locatorPath);
		actualElement.click();
	}

	public String getLocatorFromJson(WebDriver driver, String jsonPath, String locatorPath) {

		String file = "src/test/resources/locators/"+jsonPath;
		String json = null;
		try {
			json = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e1) {
		}
		//		System.out.println(json);

		JSONObject obj = new JSONObject(json);
		String[] elements=locatorPath.split(":");
		for(int i=0;i<elements.length-1;i++) {
			obj = obj.getJSONObject(elements[i]);
		}
		String elementXpath = obj.getString(elements[elements.length-1]);
		return elementXpath;
	}


	public WebElement getElementFromJson(WebDriver driver, String jsonPath, String locatorPath) {
		String elementXpath = getLocatorFromJson(driver,jsonPath, locatorPath);
		WebElement foundElement = null;
		try {
			if(elementXpath.startsWith("//")) {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(10, TimeUnit.SECONDS)
						.pollingEvery(1 , TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class,StaleElementReferenceException.class);      		
				foundElement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
			}
			else {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(10, TimeUnit.SECONDS)
						.pollingEvery(1 , TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class,StaleElementReferenceException.class);      		
				foundElement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementXpath)));
			}
		} catch (Exception e) {
		}
		return foundElement;
	}

	public List<WebElement> getElementsFromJson(WebDriver driver, String jsonPath, String locatorPath) {

		String elementXpath = getLocatorFromJson(driver,jsonPath,locatorPath);
		try {
			if(elementXpath.startsWith("//")) {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(10, TimeUnit.SECONDS)
						.pollingEvery(1 , TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class,StaleElementReferenceException.class);      		
				fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
			}
			else {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(10, TimeUnit.SECONDS)
						.pollingEvery(1 , TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class,StaleElementReferenceException.class);      		
				fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementXpath)));
			}
		} catch (Exception e) {
		}
		return driver.findElements(By.xpath(elementXpath));
	}

}
