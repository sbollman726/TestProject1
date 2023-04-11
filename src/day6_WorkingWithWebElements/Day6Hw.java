package day6_WorkingWithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6Hw {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		Day6Hw tom = new Day6Hw();
		
		tom.testcase2();
	//	tom.testcase3();
	//	tom.testcase4();
	//	tom.testcase5();

		
	}
	
	public void testcase2() throws InterruptedException {

		/*
		Test case 2.
        go to http://practice.primetech-apps.com/practice/radio-button
        Find those available radio buttons.
			
		Check if it's displayed and enabled,  
		if true, check if it's selected, 
		if false select the button and check if it's selected.
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//1.)        go to http://practice.primetech-apps.com/practice/radio-button
		driver.navigate().to("http://practice.primetech-apps.com/practice/radio-button");
		Thread.sleep(2000);
	
//2.)        Find those available radio buttons.
//3.)		Check if it's displayed and enabled,  
//4.)		if true, check if it's selected, 
//5.)		if false select the button and check if it's selected.
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='form-check']"));
		for (int i = 0; i < countries.size(); i++) {
			System.out.println(countries.get(i).getText());
			if(countries.get(i).isDisplayed() && countries.get(i).isEnabled()) {
				if(countries.get(i).isSelected()) {
					System.out.println(countries.get(i).getText() + " is Selected.");
				}
				else {
					countries.get(i).click();
					System.out.println(countries.get(i).getText() + " has been selected.");
				}
			}
			else {
				System.out.println(countries.get(i).getText() + " is either not displayed or enabled.");
			}
		}
		
		
		
		Thread.sleep(1000);
//		driver.quit();
	}
	
	public void testcase3() throws InterruptedException {
		
		/*
		Test case 3.
             go to http://practice.primetech-apps.com/practice/check-box
            find the checkboxes and verify if it's displayed, 
            if true, then verify if it's enabled, if true,        
            verify if it's selected, if false, then check the boxes. 
            Then verify if it's checked.
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//1.)        go to http://practice.primetech-apps.com/practice/check-box
		driver.navigate().to("http://practice.primetech-apps.com/practice/check-box");
		Thread.sleep(2000);

//2.)       find the checkboxes and verify if it's displayed, 
//			if true, then verify if it's enabled, 
//			if true, verify if it's selected,
//			if false, then check the boxes. 
//          Then verify if it's checked.
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='form-check']"));
		List<WebElement> check = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < checkbox.size(); i++) {
			System.out.println(checkbox.get(i).getText());
			if(checkbox.get(i).isDisplayed() && checkbox.get(i).isEnabled()) {
				System.out.println(checkbox.get(i).getText()+" is Displayed and Enabled.");
				if(!checkbox.get(i).isSelected()) {
					check.get(i).click();
					Thread.sleep(1000);
					System.out.println(checkbox.get(i).getText() + " has been selected.");
				}
				else {
					System.out.println(checkbox.get(i).getText() + " is already selected.");
				}
			}
			else {
				System.out.println(checkbox.get(i).getText()+ " is either not Displayed or Enabled.");
			}
		}
		
		
	Thread.sleep(2000);
	driver.quit();	
	}
	
	public void testcase4() throws InterruptedException {
		/*
		Test case / home work
    	go to amazon.com    click on signin 
    	verify that you are on sign in page (either by sign-in text or email field).
    	navigate back, and navigate forward
    	verify that you are on sign in page (either by sign-in text or email field).
    	click on create new account, verify you are on new account create page.
    	navigate back, verify you are on the sign-in page.
    	navigate forward, verify you are on the create account page.
    	click on the Continue button without filling the form
    	verify error messages displayed and get text to verify:
    	Enter your name
    	Enter your email or mobile phone number
    	Minimum 6 characters required
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//1.)	go to amazon.com    click on signin
		driver.navigate().to("http://amazon.com");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']")).click();
		Thread.sleep(2500);
		
//2.)   verify that you are on sign in page (either by sign-in text or email field).
		String signin = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		if(signin.contains("Sign in")) {
			System.out.println("You are on the Sign in page.");
		}
		else {
			System.out.println("You are on the Home Page, Navigation Failed.");
		}

//3.)   navigate back, and navigate forward
		driver.navigate().back();
		driver.navigate().forward();
		
//4.)   verify that you are on sign in page (either by sign-in text or email field).
		String signin2 = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		if(signin2.contains("Sign in")) {
			System.out.println("You are on the Sign in page.");
		}
		else {
			System.out.println("You are on the Home Page, Navigation Failed.");
		}
		
//5.)	click on create new account, verify you are on new account create page.
		driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
		String createnew = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		if(createnew.contains("Create account")) {
			System.out.println("You are on the Create account page.");
		}
		else {
			System.out.println("You are on the Sign in Page, Navigation Failed.");
		}
//6.)   navigate back, verify you are on the sign-in page.
		driver.navigate().back();
		String signin3 = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		if(signin3.contains("Sign in")) {
			System.out.println("You are on the Sign in page.");
		}
		else {
			System.out.println("You are on the Create account Page, Navigation Failed.");
		}
//7.)   navigate forward, verify you are on the create account page.
		driver.navigate().forward();
		String createnew2 = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		if(createnew2.contains("Create account")) {
			System.out.println("You are on the Create account page.");
		}
		else {
			System.out.println("You are on the Sign in Page, Navigation Failed.");
		}
//8.)   click on the Continue button without filling the form
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
//9.)	verify error messages displayed and get text to verify:
	/*	Enter your name
    	Enter your email or mobile phone number
    	Minimum 6 characters required    */
		String nameError = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]")).getText();
		String emailError = driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]")).getText();
		List<WebElement> passError = driver.findElements(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
		
		if (nameError.equals("Enter your name")){
			System.out.println("Name Error Pass");
		}else {
			System.out.println("Name Error Fail");
		}
		if (emailError.equals("Enter your email or mobile phone number")){
			System.out.println("Email Error Pass");
		}else {
			System.out.println("Email Error Fail");
		}
		if (passError.get(0).getText().equals("Minimum 6 characters required")){
			System.out.println("Password Error Pass");
		}else {
			System.out.println("Password Error Fail");
		}
		
		Thread.sleep(1000);
		driver.quit();
	}
	public void testcase5() throws InterruptedException {
		/*
		Test case / home work
    maximize window.
    implicitly wait for 5 seconds.
    go to ebay.com.   
    search coffee mug.
    find all the results and store them in a list of webelements.
    loop through all those and get the prices of each item and print it out. 
    then quit.
		*/
		WebDriver driver = new ChromeDriver();
//1.)		maximize window.    implicitly wait for 5 seconds.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//2.)	    go to ebay.com.   
		driver.navigate().to("http://amazon.com");
		Thread.sleep(1000);
	
//3.)		search coffee mug.
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("coffee mug"+Keys.ENTER);	
		
//4.)   	find all the results and store them in a list of webelements.
		List<WebElement> mug = driver.findElements(By.xpath("//span[@class='a-price']"));
//5.)  		loop through all those and get the prices of each item and print it out. 
		for (int i = 0; i < mug.size(); i++) {
			System.out.println(mug.get(i).getText());

		}
//6.)		then quit.
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	
	
}
