package day8_popupAlerts;

import java.util.Iterator;
import java.util.List;
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

public class Day8Hw {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
	//	testCase1();
		testCase2();
		
		
	}
	
	public static void testCase1() throws InterruptedException {
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
		String email = "automation@gmail.com";
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		//    	go to http://demo.guru99.com/popup.php
		driver.get("http://demo.guru99.com/popup.php");
		
		//     	Get title and store it in a variable.
		String mainTitle = driver.getTitle();
		String mainID = driver.getWindowHandle();
		System.out.println(mainID);
		
		//     	Click on Click Here button and switch over to next window, provide an email click Submit. 
		driver.findElement(By.xpath("//a[@href='../articles_popup.php']")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> ids = windowIds.iterator();
		
		String firstTab = ids.next();
		String secondTab = ids.next();
		
		System.out.println(firstTab);
		System.out.println(secondTab);
		
		driver.switchTo().window(secondTab);
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//     	Get text of the user ID and password and store them in variables, print them out. 
		List<WebElement>info = driver.findElements(By.xpath("//td[@align='center']"));
	
		String userID = info.get(2).getText();
		System.out.println("User ID: "+ userID);
		
		String pass = info.get(4).getText();
		System.out.println("Password: "+ pass);
		
		//     	Then verify the text "This access is valid only for 20 days."
		String text = info.get(5).getText();
		if(text.equals("This access is valid only for 20 days.")) {
			System.out.println("Text Matches");
		}
		else {
			System.out.println("Text does not match");
		}
		
		//     	Close the window.
		driver.close();
		
		//     	Go back to main window, and get title then verify it equals to your stored title.
		driver.switchTo().window(mainID);
		String currentTitle = driver.getTitle();
		if(currentTitle.equals(mainTitle)) {
			System.out.println("You are on the original page");
		}
		else {
			System.out.println("You are lost");
		}
		
		//     	Quite driver.
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void testCase2() throws InterruptedException {
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
		String name = "Sam";
		String last = "Boll";
		String address = "123 King St";
		String city = "Frog";
		String zip = "12650";
		String state = "Virginia";
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		//		go to http://practice.primetech-apps.com/practice/frames
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		//		Verify that there is a page header text as "Frames".
		if(driver.findElement(By.xpath("//h3[@class='mb-5']")).isDisplayed()) {
			System.out.println("You are on the Frames page");
		}
		else {
			System.out.println("You are not on the frames page");
		}
		
		//		Find the iFrame element and switch into it
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0, 300)", "");
		
		driver.switchTo().frame(0);
		
		//		Find firstname, lastname, address, city, state, and zipcode, and type relative information.
		Thread.sleep(2000);
		
		driver.findElement(By.id("firstName")).sendKeys(name);
		driver.findElement(By.id("lastName")).sendKeys(last);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipCode")).sendKeys(zip);
		
		WebElement selectElement = driver.findElement(By.id("state"));
		Select choose = new Select(selectElement);
		
		choose.selectByVisibleText(state);
		
		Thread.sleep(2000);
	
		//		Click on submit button.
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.elementToBeClickable(button));
		js.executeScript("arguments[0].scrollIntoView();", button);	
		Thread.sleep(2000);
		button.click();		
		//		Verify you see "You have submitted below information:" message.
		if(driver.findElement(By.xpath("//h3[text()='You have submited below information:']")).isDisplayed()) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		
		//		Switch back to main frame
		driver.switchTo().parentFrame();
		
		//		Verify that there is a page header text as "Frames".
		if(driver.findElement(By.xpath("//h3[@class='mb-5']")).isDisplayed()) {
			System.out.println("You are on the Frames page");
		}
		else {
			System.out.println("You are not on the frames page");
		}
		
		
		Thread.sleep(1000);
		driver.quit();
		
	}

}
