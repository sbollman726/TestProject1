package day9_ActionsClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day8HwReview {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		
	//	guru99();
		iFrame();

		
	}
	
	public static void iFrame() throws InterruptedException {
		/*
		Test case 2: 
			go to http://practice.primetech-apps.com/practice/frames
			Verify that there is a page header text as "Frames".
			Find the iFrame element and switch into it
			Find firstname, lastname, address, city, state, and zipcode, and type relative information.
			Click on submit button.
			Verify you see "You have submitted below information:" message.
			Switch back to main frame
			Verify that there is a page header text as "Frames".
			*/
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		//	go to http://practice.primetech-apps.com/practice/frames
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		//			Verify that there is a page header text as "Frames".
		if(driver.findElement(By.xpath("//h3[@class='mb-5']")).isDisplayed()) {
			System.out.println("Frame text present");
		}
		else {
			System.out.println("Frame text is not present");
		}
		
		//			Find the iFrame element and switch into it
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0, 300)", "");
		driver.switchTo().frame(driver.findElement(By.id("iframe1")));
	//	driver.switchTo().frame("iframe1");
		
		//			Find firstname, lastname, address, city, state, and zipcode, and type relative information.
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Smith");
		driver.findElement(By.id("address")).sendKeys("123 King St");
		driver.findElement(By.id("city")).sendKeys("Ringo");
		driver.findElement(By.id("zipCode")).sendKeys("23641");
		
		Select stateSelect = new Select(driver.findElement(By.id("state")));
		stateSelect.selectByVisibleText("Virginia");
		
		
		//			Click on submit button.
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", button);	
		wait.until(ExpectedConditions.elementToBeClickable(button));
		Thread.sleep(2000);
		button.click();
		
		//			Verify you see "You have submitted below information:" message.
		if(driver.findElement(By.xpath("//h3[text()='You have submited below information:']")).isDisplayed()) {
			System.out.println("Info text is there");
		}
		else {
			System.out.println("Info text is not there");
		}
		
		
		//			Switch back to main frame
		driver.switchTo().parentFrame();
		
		//			Verify that there is a page header text as "Frames".
		if(driver.findElement(By.xpath("//h3[@class='mb-5']")).isDisplayed()) {
			System.out.println("Frame text present");
		}
		else {
			System.out.println("Frame text is not present");
		}
		
		
		
	}
	
	
	public static void guru99() {
		/*
		Test case 1
	    	go to http://demo.guru99.com/popup.php
	     	Get title and store it in a variable.
	     	Click on Click Here button and switch over to next window, provide an email click Submit. 
	     	Get text of the user ID and password and store them in variables, print them out. 
	     	Then verify the text "This access is valid only for 20 days."
	     	Close the window.
	     	Go back to main window, and get title then verify it equals to your stored title.
	     	Quite driver.  
			*/
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		//    	go to http://demo.guru99.com/popup.php
		driver.get("http://demo.guru99.com/popup.php");
		
		//	     	Get title and store it in a variable.
		String mainTitle = driver.getTitle();
		String mainID = driver.getWindowHandle();
		
		//	     	Click on Click Here button and switch over to next window, provide an email click Submit. 
//		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> windowIDs = driver.getWindowHandles();
		
		for( String str : windowIDs) {
			if(!str.equals(mainID)) {
				driver.switchTo().window(str);
			}			
		}
			
		driver.findElement(By.name("emailid")).sendKeys("johndoe@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		
		//	     	Get text of the user ID and password and store them in variables, print them out. 
		String userID = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		String pass = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText().trim();
		//Another way to find specified index:  ("//td[@align='center']")[3]
		System.out.println("UserID: "+userID);
		System.out.println("Password: "+pass);
		
		//	     	Then verify the text "This access is valid only for 20 days."
		String message = driver.findElement(By.xpath("//h3[contains(text(), 'This access')]")).getText();
		if(message.equals("This access is valid only for 20 days.")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		//	     	Close the window.
		driver.close();
		
		//	     	Go back to main window, and get title then verify it equals to your stored title.
		driver.switchTo().window(mainID);
		if(driver.getTitle().equals(mainTitle)) {
			System.out.println("We are on the main page");
		}
		else
		{
			System.out.println("We got lost");
		}
		//	     	Quite driver.  
		
		driver.quit();
	}

}
