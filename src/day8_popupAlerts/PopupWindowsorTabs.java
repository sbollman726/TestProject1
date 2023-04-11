package day8_popupAlerts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupWindowsorTabs {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		
	//	newTabDemo();
		testcase2();
		/*
		while(ids.hasNext()) {
			System.out.println("Winow ID is: "+ids.next());
		}
		*/

	}
	
	public static void newTabDemo() throws InterruptedException {
		// in order to switch to new window:
		// 1.) we gathered the available window Ids and store them into Set
		// 2.) we iterated over the Set and get the individual id and store into strings
		// 3.) we have used driver.switchTo().window(windowID)
		// 4.) once we are done with the second window, 
		//     we close the window and switch back to main window
		
		
		
		/*
		Test case 1
		go to http://practice.primetech-apps.com/practice/browser-windows
		Click on ‘New Tab’ button.
		Then get the window handles and print what are they.
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		//		go to http://practice.primetech-apps.com/practice/browser-windows
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		String mainWindowId = driver.getWindowHandle();
		System.out.println("Main Window Id: " + mainWindowId);
		
		//		Click on ‘New Tab’ button.
		driver.findElement(By.id("newTab")).click();
		Thread.sleep(1000);
		
		//		Then get the window handles and print what are they.
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			System.out.println("Window Id is: " + windowId);
		}
		
		Iterator<String> ids = windowIds.iterator();
		String FirstTab = ids.next();
		String SecondTab = ids.next();
		System.out.println(FirstTab);
		System.out.println(SecondTab);
		
		
		driver.switchTo().window(SecondTab);
		String newTabTextOnSecondWindow = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(newTabTextOnSecondWindow);
		Thread.sleep(1000);
		driver.close();
		
		driver.switchTo().window(FirstTab);
		String mainWindowText = driver.findElement(By.xpath("//h3[text()='Browser Windows']")).getText();
		System.out.println("Main Window Browser Text is: "+mainWindowText);
		
		
		if(driver.getWindowHandle().equals(mainWindowId)) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void testcase2() throws InterruptedException {
		/*
		Test case 2 
		go to http://practice.primetech-apps.com/practice/browser-windows
		1. Get the main window ID and store it in a String called mainWindowId, 
		2. Click on the 'New Tab' button
		3. Get window IDs and store it into a Set
		4. Get the first window ID from the Set and Verify it matches with the main window id in step 1.  Then get the second window id and store it in variable called secondWindowId.
		5. Switch to the second window
		6. Verify that there is a button called 'New Tab'
		7. Close the window,  Switch back to the main window, Verify you are on the main window. 
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		//		go to http://practice.primetech-apps.com/practice/browser-windows
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		
		//		1. Get the main window ID and store it in a String called mainWindowId, 
		String mainWindowId = driver.getWindowHandle();
		
		//		2. Click on the 'New Tab' button
		driver.findElement(By.id("newTab")).click();
		Thread.sleep(2000);
		
		//		3. Get window IDs and store it into a Set
		Set<String> windowIds = driver.getWindowHandles();
		
		//		4. Get the first window ID from the Set and Verify it matches with the main window id in step 1.  
		//		Then get the second window id and store it in variable called secondWindowId.
		Iterator<String> ids = windowIds.iterator();
		String firstTab = ids.next();
		if(firstTab.equals(mainWindowId)) {
			System.out.println("First Window Id and Main Window Id Match");
		}
		else {
			System.out.println("First Window Id Main Window Id DO NOT MAtCH");
		}
		
		String secondTab = ids.next();
		
		
		//		5. Switch to the second window
		driver.switchTo().window(secondTab);
		
		//		6. Verify that there is a button called 'New Tab'
		if(driver.findElement(By.id("newTab")).isDisplayed()) {
			System.out.println("There is a button");
		}
		else {
			System.out.println("Button not found");
		}
		
		//		7. Close the window,  
		driver.close();
		
		//			Switch back to the main window, 
		driver.switchTo().window(firstTab);
		
		//			Verify you are on the main window. 
		String currentTab = driver.getWindowHandle();
		if(currentTab.equals(mainWindowId)) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	
}
