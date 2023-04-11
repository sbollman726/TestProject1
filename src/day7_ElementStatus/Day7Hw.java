package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day7Hw {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		
//		testCase1();
//		testCase2();
//		testCase3();
//		testCase4();
//		testCase5();
//		testCase6();
		
	}
	
	public static void testCase1() {
		/*
		Test case 1
    	go to amazon.com 
     	get all the options in the departments select dropdown
    	verify there are total 58 departments. And print them out.
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().to("https://amazon.com");
	
		WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
		
		Select choose = new Select(selectElement);
		
		List<WebElement> allOptions = choose.getOptions();

		System.out.println("Size of list: "+allOptions.size());
		for (int i = 0; i < allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
		
		driver.quit();
	}
	
	
	public static void testCase2() {
		/*
		Test case 2
     go to amazon.com
     verify that you are on the amazon home page. (verify with title). 
     verify dropdown value is by default "All Departments"
     select department Home & Kitchen, and search coffee mug.
     verify you are on coffee mug search results page (use title).
     verify you are in Home & Kitchen department.
		*/
		String obj = "coffe mug";
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
		//     go to amazon.com
		driver.navigate().to("https://amazon.com");
		
		//     verify that you are on the amazon home page. (verify with title). 
		String homeTitle = driver.getTitle();
		if (homeTitle.equals("Amazon.com. Spend less. Smile more.")) {
			System.out.println("You are on " + homeTitle);
		}
		else {
			System.out.println("You are not on the home page");
		}
		
		//     verify dropdown value is by default "All Departments"
		WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
		Select choose = new Select(selectElement);
		
		WebElement alldepart = choose.getFirstSelectedOption();
		if(alldepart.getText().equals("All Departments")) {
			System.out.println("The default value is All Departments");
		}
		else {
			System.out.println("The default value is NOT All Departments");
		}
		
		//     select department Home & Kitchen, and search coffee mug.
		choose.selectByVisibleText("Home & Kitchen");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(obj + Keys.ENTER);
		
		//     verify you are on coffee mug search results page (use title).
		String newTitle = driver.getTitle();
		if(newTitle.contains(obj)) {
			System.out.println("Search Succuessful");
		}
		else {
			System.out.println("Search failed");
		}
		
		//     verify you are in Home & Kitchen department.
		WebElement selectElement2 = driver.findElement(By.id("searchDropdownBox"));
		Select choose2 = new Select(selectElement2);
		
		WebElement currentDepart = choose2.getFirstSelectedOption();
		if(currentDepart.getText().equals("Home & Kitchen")) {
			System.out.println("You are in the Home and Kitchen Department");
		}
		else {
			System.out.println("You are NOt in the Home and Kitchen Department");
		}
		
		
		driver.quit();
	}
	
	
	public static void testCase3() {
		/*
	Test case 1
		go to http://practice.primetech-apps.com/practice/alerts
		Click on the 'Alert'  button and Accept the alert. 
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver,5);
	
		//		go to http://practice.primetech-apps.com/practice/alerts
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		//		Click on the 'Alert'  button and Accept the alert. 
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.quit();
	}
	
	
	public static void testCase4() {
		/*
	Test case 2 
		go to http://practice.primetech-apps.com/practice/alerts 
		Click on the 'Confirm Alert' button and Get the text of it. 
		Then verify if the text equals to "Do you wish to continue or cancel?" 
		Then Accept the alert.  
		If not, cancel the Alert
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver,5);
	
		//		go to http://practice.primetech-apps.com/practice/alerts
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		//		Click on the 'Confirm Alert' button and Get the text of it.
		driver.findElement(By.id("confirm")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String errorMess = alert.getText();
		
		//		Then verify if the text equals to "Do you wish to continue or cancel?"
		//		Then Accept the alert.  
		//		If not, cancel the Alert
		if(errorMess.equals("Do you wish to continue or cancel?")) {
			System.out.println("Message is equal");
			alert.accept();
		}
		else {
			System.out.println("Message does not match");
			alert.dismiss();
		}
		
		
		driver.quit();
	}

	
	public static void testCase5() {
		/*
	Test case 3
		go to http://practice.primetech-apps.com/practice/alerts 
		Click on the 'Prompt Alert' button and type PrimeTech
		Then accept the Alert. Verify that a greeting message displays as
		"Hello <your input>! How are you today?".
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver,5);
	
		//		go to http://practice.primetech-apps.com/practice/alerts
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		//		Click on the 'Prompt Alert' button and type PrimeTech
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='prompt']")));
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("PrimeTech");
		
		//		Then accept the Alert. Verify that a greeting message displays as
		//		"Hello <your input>! How are you today?".
		alert.accept();
		
		String mess = driver.findElement(By.id("demp")).getText();
		if(mess.equals("Hello PrimeTech! How are you today?")) {
			System.out.println("Your message is: "+ mess);
		}
		else
			System.out.println("Test Failed");
			
		driver.quit();
	}
	
	
	public static void testCase6() {
		/*
	Test case 4
		go to http://practice.primetech-apps.com/practice/alerts 
		Click on the 'Prompt Alert' button and type PrimeTech. Then dismiss the Alert.
		Verify that "User cancelled the prompt." text displays.
		*/
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver,5);
	
		//		go to http://practice.primetech-apps.com/practice/alerts
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		//		Click on the 'Prompt Alert' button and type PrimeTech. Then dismiss the Alert.
		WebElement button = driver.findElement(By.xpath("//button[@id='prompt']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)", "");
	//	js.executeScript("arguments[0].scrollIntoView();", button);		
		wait.until(ExpectedConditions.elementToBeClickable(button));
		button.click();
		//		Verify that "User cancelled the prompt." text displays.
		
		
		
	}
	
	
}
