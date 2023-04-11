package day9_ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
	//	actioncalasdaemo();
		dragAndDropDemo();
		
	}
	
	public static void dragAndDropDemo() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		Actions doSomething = new Actions(driver);
		
		
		// go to http://practice.primetech-apps.com/practice/drag-and-drop
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		Thread.sleep(1000);
		// drag the text element to next window
		WebElement sourceElement = driver.findElement(By.id("text"));
		WebElement targetElement = driver.findElement(By.id("dropzone"));
		
		doSomething.dragAndDrop(sourceElement, targetElement).build().perform();
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	public static void actioncalasdaemo() throws InterruptedException {
		/*
		 1.go to Etsy.com
		 2.Hover Over on Jewelry & Accessories
		 3.Mouseover on Bags & Purses
		 4.Mouseover to Shoulder Bags
		 5.Click on the shoulder bags
		 6.Verify you are on the Shoulder bags page
 
		 
		 */
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		Actions doSomething = new Actions(driver);
		
		//		 1.go to Etsy.com
		driver.get("https://etsy.com");
		Thread.sleep(2000);
		//		 2.Hover Over on Jewelry & Accessories
		WebElement jewlaryTab = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		doSomething.moveToElement(jewlaryTab).build().perform();
		Thread.sleep(1000);
		
		//		 3.Mouseover on Bags & Purses
		WebElement bagsTab = driver.findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));
		doSomething.moveToElement(bagsTab).build().perform();
		Thread.sleep(1000);
		
		//		 4.Mouseover to Shoulder Bags
		WebElement shoulderBagsTab = driver.findElement(By.xpath("//a[contains(text(), 'Shoulder Bags')]"));
		doSomething.moveToElement(bagsTab).build().perform();
		Thread.sleep(1000);
		
		//		 5.Click on the shoulder bags
		shoulderBagsTab.click();
		Thread.sleep(1000);
		
		//		 6.Verify you are on the Shoulder bags page
		if(driver.getTitle().contains("Shoulder Bags")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
