package utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class UiBase extends PageObject {

    public String BP_Locator_File = "src/test/resources/locators/businessPortalLocators.json";
    public String BP_TestData_File = "src/test/resources/testData/businessPortalTestData.json";

    private static String mainWindowHandle;

    public void clickElement(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
        element.click();
    }

    public void enterText(String locatorPath, String textToEnter) {
        WebElement element = getElementFromJson(locatorPath);
        element.sendKeys(textToEnter);
    }

    public void clearAndFillText(String locatorPath, String textToEnter) {
        WebElement element = getElementFromJson(locatorPath);
        element.clear();
        element.sendKeys(textToEnter);
    }

    public String getText(String locatorPath) {
        String text = "";
        WebElement element = getElementFromJson(locatorPath);
        try {
            return element.getText();
        } catch (Throwable t) {
            t.printStackTrace();
            return text;
        }
    }

    public void clear(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
        element.clear();
    }

    public boolean isElementEnabled(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
        try {
            return element.isEnabled();
        } catch (Throwable t) {
            return false;
        }
    }

    public boolean isElementDisplayed(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
        try {
            return element.isDisplayed();
        } catch (Throwable t) {
            return false;
        }
    }

    public String getAttributeValue(String locatorPath, String attributeName) {
        WebElement element = getElementFromJson(locatorPath);
        return element.getAttribute(attributeName);

    }

    public Object jsonReader(String jsonFilePath, String key) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(jsonFilePath));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getLocatorFromJson(String locatorPath) {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(BP_Locator_File)));
        } catch (IOException e1) {
        }
        JSONObject obj = new JSONObject(json);
        String[] elements = locatorPath.split(":");
        for (int i = 0; i < elements.length - 1; i++) {
            obj = obj.getJSONObject(elements[i]);
        }
        String elementXpath = obj.getString(elements[elements.length - 1]);
        return elementXpath;
    }

    public WebElement getElementFromJson(String locatorPath) {
        String elementXpath = getLocatorFromJson(locatorPath);
        WebElement foundElement = null;
        try {
            if (elementXpath.startsWith("//")) {
                foundElement = $(By.xpath(elementXpath));
            } else {
                foundElement = $(By.cssSelector(elementXpath));
            }
        } catch (Exception e) {
        }
        return foundElement;
    }


    public String getTestDataFromJson(String locatorPath) {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(BP_TestData_File)));
        } catch (IOException e1) {
        }
        JSONObject obj = new JSONObject(json);
        String[] elements = locatorPath.split(":");
        for (int i = 0; i < elements.length - 1; i++) {
            obj = obj.getJSONObject(elements[i]);
        }
        String elementXpath = obj.getString(elements[elements.length - 1]);
        return elementXpath;
    }

    public boolean selectCheckBox(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
        if (element.isSelected()) {
            return true;
        } else {
            element.click();
            return true;
        }
    }

    public boolean unSelectCheckBox(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
        if (element.isSelected()) {
            element.click();
            return true;
        } else {
            return true;
        }
    }

    public String TodaysDate() throws Exception {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }

    public void highlightElement(String locatorPath, int duration) throws InterruptedException {
        WebElement element = getElementFromJson(locatorPath);
        String original_style = element.getAttribute("style");
        JavascriptExecutor js;
        js = (JavascriptExecutor) getDriver();
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

    public void safeJavaScriptClick(String locatorPath) throws Exception {
        WebElement element = getElementFromJson(locatorPath);
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }
    }

    public boolean selectDropdownValue(String locatorPath, String value) {
        WebElement element = getElementFromJson(locatorPath);
        try {
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private ExpectedCondition<WebElement> visibilityOfElementLocated(
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<WebElement> getAllDropdownValues(WebElement element) {
        try {
            Select dropdown = new Select(element);
            return dropdown.getOptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollToBottom(WebDriver driver) {
        try {
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollBy(0, 250)", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollToTop(WebDriver driver) {
        try {
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollBy(0, -250)", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAlertPresent(Alert alert, String button) {
        try {
            if (button.equals("OK")) {
                System.out.println(alert.getText());
                alert.accept();
                getDriver().switchTo().defaultContent();
            } else if (button.equals("Cancel")) {
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
            String browserName = remoteDriver.getCapabilities().getBrowserName();
            return browserName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOSName() {
        try {
            String OSName = System.getProperty("os.name").toLowerCase();
            return OSName;
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Wait for element is visible
     *
     * @param driver
     * @param element
     * @return
     */
    public boolean explicitWaitForElement(WebDriver driver, WebElement element) {
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
     *
     * @param driver
     * @param element
     * @param time
     * @return
     */
    public WebElementFacade explicitWaitForElement(WebDriver driver, WebElementFacade element, int time) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(visibilityOfElementLocated(element));
        return element;
    }

    public WebElementFacade explicitWaitForElementInvisibility(WebDriver driver, By element, int time) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        return (WebElementFacade) driver.findElement(element);
    }

    public List<WebElement> explicitWaitForListOfElements(WebDriver driver, List<WebElement> element, int waitInSeconds) {
        new WebDriverWait(driver, waitInSeconds).until(ExpectedConditions.visibilityOfAllElements(element));
        return element;
    }

    /*
	    This method will Returns Tomorrow's date in MM/DD/YYYY Format
	 */
    public String TomorrowDate() {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String tomorrowDate = formatter.format(dt);
        return tomorrowDate;
    }

    /*
        select value from dropdown
     */
    public boolean selectValueFromDropDown(WebElementFacade element, String text) {

        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            Thread.sleep(500);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean isElementPresent(List<WebElementFacade> elements) {
        // TODO Auto-generated method stub
        return (elements.size() > 0);
    }

    public WebElementFacade fluentWaitForElement(WebDriver driver, WebElementFacade element) {
        WebElementFacade foundElement = null;
        try {
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(10, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
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
    public WebElementFacade fluentLongWaitForElement(WebDriver driver, WebElementFacade element) {
        WebElementFacade foundElement = null;
        try {
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(120, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
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
    public WebElement fluentWaitForElement(WebDriver driver, WebElement element) {
        WebElement foundElement = null;
        try {
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(90, TimeUnit.SECONDS)
                    .pollingEvery(5, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            foundElement = fluentWait.until(visibilityOfElementLocated(element));
            return foundElement;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return foundElement;
    }

    public boolean fluentWaitForElementDissapear(WebDriver driver, By by) {
        //WebElement foundElement = null;
        boolean isElementDisappeared = false;
        try {
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(120, TimeUnit.SECONDS)
                    .pollingEvery(2, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            isElementDisappeared = fluentWait.until(ExpectedConditions.invisibilityOfElementLocated((By) by));
            System.out.println("The value of found element is  " + isElementDisappeared);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getRandomNumber() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        return Integer.toString(randomInt);

    }


    /**
     * This method generates a Random String value with 9 digits
     *
     * @return
     */
    public static String getRandomNumberwith9digits() {
        Random r = new Random(System.currentTimeMillis());
        int randomInt9digitnumber = 100000000 + r.nextInt(2000000000);
        return Integer.toString(randomInt9digitnumber);
    }


    /**
     * This method generates a Random String value with 10  digits
     *
     * @return
     */
    public static String getRandomNumberwith10digits() {

        Random r = new Random(System.currentTimeMillis());
        int randomInt10digitnumber = 1000000000 + r.nextInt(2000000000);
        return Integer.toString(randomInt10digitnumber);
    }


    /***
     * This method will upload file for the POI list feature
     * @param filePath
     */
    public void uploadFile(String filePath) {
        try {

            //Copy to clipboard
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            //Create a new robot Object
            Robot robot = new Robot();

            //Pressing CTRL+V button
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.setAutoDelay(1000);

            //Releasing CTRL+V button
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.setAutoDelay(1000);

            //Pressing Enter key
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.setAutoDelay(1000);

            //Releasing Enter key
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.setAutoDelay(1000);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            System.out.println(" Save File");
            //Create a new robot Object
            Robot robot = new Robot();

            //Pressing CTRL+V button

            robot.mouseMove(630, 420); // move mouse point to specific location
            robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click
            robot.delay(1500);
            robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void OpenFile() {
        try {
            //Create a new robot Object
            Robot robot = new Robot();

            //	robot.mouseMove(630, 420); // move mouse point to specific location
            robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step

            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * Mouse Hover in Web element
     *
     * @param element
     */
    public static void mouseOver(WebDriver driver, WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }


    public static void switchToChildWindow(WebDriver driver) {
        mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!mainWindowHandle.equalsIgnoreCase(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public static void switchToMainWindow(WebDriver driver) {
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

    public static void SwitchtoTab(WebDriver driver, int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public static String readPdfContent(String url) throws IOException {
        URL pdfUrl = new URL(url);
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        int numberOfPages = doc.getNumberOfPages();
        System.out.println("The total number of pages " + numberOfPages);
        String content = new PDFTextStripper().getText(doc);
        doc.close();
        return content;
    }


    public boolean mouseLeftClick(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
//        WebElementFacade element = getElementFromJson(locatorPath);
        try {
            Actions action = new Actions(getDriver());
            action.moveToElement(element).click(element).build().perform();
            return true;
        } catch (Throwable t) {
        }

        return false;
    }

    public boolean moveToElement(String locatorPath) {

        WebElement element = getElementFromJson(locatorPath);
//        WebElementFacade element = getElementFromJson(locatorPath);

        try {
            Actions action = new Actions(getDriver());
            action.moveToElement(element).build().perform();
            return true;
        } catch (Throwable t) {
        }

        return false;
    }

    public void clickUsingAction(String locatorPath) {
        WebElement element = getElementFromJson(locatorPath);
//        WebElementFacade element = getElementFromJson(locatorPath);
        try {
            Actions customersCheckboxForExternal = new Actions(getDriver());
            customersCheckboxForExternal.click(element).build().perform();
        } catch (Throwable t) {
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
            ((JavascriptExecutor) getDriver()).executeScript(java_script, from, to);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Pagination Utils
    public boolean verifyRecordDisplayed(WebDriver driver, WebElement pagescountText, WebElement nextButton, String searchText) {
        try {
            String[] strArr = pagescountText.getText().split(" of ");
            int totalRecords = Integer.parseInt(strArr[1].replaceAll(",", ""));
            do {
                try {
                    if (driver.getPageSource().contains(searchText)) {
                        System.out.println("Created record is found");
                        break;
                    } else {
                        ((WebElementFacade) fluentWaitForElement(getDriver(), nextButton)).waitUntilVisible();
                        ((WebElementFacade) fluentWaitForElement(getDriver(), nextButton)).waitUntilClickable();
                        ((WebElementFacade) fluentWaitForElement(getDriver(), nextButton)).click();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (totalRecords != 0);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
