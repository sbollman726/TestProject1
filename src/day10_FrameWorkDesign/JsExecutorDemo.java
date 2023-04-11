package day10_FrameWorkDesign;

import org.openqa.selenium.JavascriptExecutor;

import pages.IndeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class JsExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		IndeedPage indeedpage = new IndeedPage();
		BrowserUtils utils = new BrowserUtils();
		
		Driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		indeedpage.whatField.sendKeys("SDET");
		utils.highlightElement(indeedpage.whatField);
		Thread.sleep(500);
		indeedpage.searchButton.click();
		Thread.sleep(3000);
		
		utils.scrollDownByPixel(1500);
		
		
		
		
		
	}

}
