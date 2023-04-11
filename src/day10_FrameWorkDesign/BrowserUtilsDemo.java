package day10_FrameWorkDesign;

import org.openqa.selenium.Keys;

import pages.IndeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class BrowserUtilsDemo {

	public static void main(String args[]) throws InterruptedException {
		
		indeedTest();
		
	}
	static IndeedPage indeedpage;
	static BrowserUtils utils = new BrowserUtils();
	
	public static void indeedTest() throws InterruptedException {
		
		indeedpage = new IndeedPage();
		
		//go to indeed
		Driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		Thread.sleep(2000);
		
		//find the where field and clear the text
		
	//	indeedpage.whereField.sendKeys(Keys.CONTROL + "a");
	//	indeedpage.whereField.sendKeys(Keys.DELETE);
		utils.waitForElementVisible(indeedpage.whereField);
		utils.clearText(indeedpage.whereField);
		
		
	}
	
	
	
}
