package net.tupperware.showcase.cucumber.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ProjectUtils {

	private static String mainWindowHandle;


	/**
	 * This method generates a Random String value
	 * @return
	 */
	public static String getRandomNumber(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		return Integer.toString(randomInt);
		
	}
	
	
	/**
	 * This method generates a Random String value with 9 digits
	 * @return
	 */
	public static String getRandomNumberwith9digits(){
		 Random r = new Random(System.currentTimeMillis());
 	     int randomInt9digitnumber = 100000000 + r.nextInt(2000000000);
 	     return Integer.toString(randomInt9digitnumber);
	}
	
	
	/**
	 * This method generates a Random String value with 10  digits
	 * @return
	 */
	public static String getRandomNumberwith10digits(){
		
		 Random r = new Random(System.currentTimeMillis());
 	    int randomInt10digitnumber = 1000000000 + r.nextInt(2000000000);
 	   return Integer.toString(randomInt10digitnumber);
	}

	
	/***
	 * This method will upload file for the POI list feature
	 * @param filePath
	 */
	public  void uploadFile(String filePath) {
		try{
			
			//Copy to clipboard
			StringSelection stringSelection= new StringSelection(filePath);
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
			
			} catch(Throwable t) {
				t.printStackTrace();
		}
	}
		
		public  void saveFile(){
			try{
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

			}catch(Throwable t){
				t.printStackTrace();
			}
	}
		
		public  void OpenFile(){
			try{
				//Create a new robot Object
				Robot robot = new Robot();

			//	robot.mouseMove(630, 420); // move mouse point to specific location	
		        robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step	
		        	             
		        robot.keyPress(KeyEvent.VK_ENTER);	

			}catch(Throwable t){
				t.printStackTrace();
			}
		}
		
		/**
		 * Mouse Hover in Web element
		 * 
		 * @param element
		 */
		public static void mouseOver(WebDriver driver, WebElement element) 
		{
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
		
		public static void SwitchtoTab(WebDriver driver,int tabNumber) {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabNumber));
		}
		
		public static  String readPdfContent(String url) throws IOException {
			URL pdfUrl = new URL(url);
			InputStream in = pdfUrl.openStream();
			BufferedInputStream bf = new BufferedInputStream(in);
			PDDocument doc = PDDocument.load(bf);
			int numberOfPages = doc.getNumberOfPages();
			System.out.println("The total number of pages "+numberOfPages);
			String content = new PDFTextStripper().getText(doc);
			doc.close();
			return content;
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
}
