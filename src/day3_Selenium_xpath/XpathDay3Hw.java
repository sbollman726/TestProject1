package day3_Selenium_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDay3Hw {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		XpathDay3Hw phil = new XpathDay3Hw();
		phil.testCase1();
	//	phil.testCase2();
	//	phil.testcase3();

	}
	
	public void testCase1() throws InterruptedException{
		/*
		Test case 1 - (Use only Xpath)
     go to facebook.com
     find the Email or phone number field and type Automation
     find the Password field and type Automation
     find the Login button and click on it.
		*/
		String auto = "automation@gmail.com";
		String pass = "automation";

		WebDriver driver = new ChromeDriver();
		
		//1.)	go to facebook.com
		driver.get("http://facebook.com");
		Thread.sleep(2000);
		
		//2.)	find the Email or phone number field and type Automation
		driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']")).sendKeys(auto);
		
		//3.)	find the Password field and type Automation
		driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']")).sendKeys(pass);
		
		//4.)	find the Login button and click on it.
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	public void testCase2() throws InterruptedException {
		/*
		Test case 2 - (Use only Xpath)
     go to facebook.com
     find the Create New Account button and click on it
     find the FirstName,  LastName, Email and Password fields and type Automation
     find the Sign Up button and click on it.
		*/
		String auto = "automation";
		String autoE = "automation@gmail.com";
		String autoP = "automation493";

		
		WebDriver driver = new ChromeDriver();
		
		//1.)	go to facebook.com
		driver.get("http://facebook.com");
		Thread.sleep(2000);
		
		//2.)	find the Create New Account button and click on it
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);

		
		//3.)	find the FirstName,  LastName, Email and Password fields and type Automation
		// First Name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(auto);
		// Last Name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(auto);
		Thread.sleep(2000);
		
		//Email
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(autoE);
		//Email confirmation
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(autoE);
		
		//Password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(autoP);
		
		
		//4.)	find the Sign Up button and click on it.
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(5000);
		
		driver.quit();
		
	}
	
	public void testcase3() throws InterruptedException {
		
		/*
		 Test case 3 - (Use only Xpath) 
1. go to indeed.com
2. get the current URL and store it in a variable called homeURL.
3. get the website title and store it in a variable homeTitle.
4. find the input field for WHAT and type SDET
5. find the input field for where, clear the field first and type washington DC
6. find the Search button and click on it.
get the current URL and store it as a variable searchURL.
7. get the website title and store it in a variable searchTitle.
8. verify that searchURL does not equal to homeURL and contains the search criteria.
9. verify that searchTitle does not equal to homeTitle and has the search criteria.
10. Get Text of the JobsInLocation field, store it in a variable, 
11. then verify if it's equal to your search criteria.
		 */
		String what = "Sdet";
		String where = "Washington, DC";
		WebDriver driver = new ChromeDriver();
		
		//1.)	go to indeed.com
		driver.get("http://indeed.com");
		Thread.sleep(2000);
		
		//2.)	get the current URL and store it in a variable called homeURL.
		String homeUrl = driver.getCurrentUrl();
		
		//3.)	get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
				
		//4.)	find the input field for WHAT and type SDET
		driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys(what);
		
		//5.)	find the input field for where, clear the field first and type washington DC
		WebElement whereField = driver.findElement(By.xpath("//input[@id='text-input-where']"));
		
		whereField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(500);
		whereField.sendKeys(Keys.DELETE);
		whereField.sendKeys(where);
		
		Thread.sleep(1000);
		//6.)	find the Search button and click on it.
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1500);
		//7a.)	get the current URL and store it as a variable searchURL.
		String searchUrl = driver.getCurrentUrl();
		
		//7b.)	get the website title and store it in a variable searchTitle.
		String searchTitle = driver.getTitle();
		
		//8.)	verify that searchURL does not equal to homeURL and contains the search criteria.
		if(!searchUrl.equals(homeUrl) && searchUrl.contains(what)) {
			System.out.println("Search Succesful! You Searched for "+ what+" jobs."+" Current URL: "+ searchUrl);
		}
		else {
			System.out.println("Search has failed! Current URL: "+ searchUrl);
		}

		//9.)	verify that searchTitle does not equal to homeTitle and has the search criteria.
		if(!searchTitle.equals(homeTitle) && searchTitle.contains(what)) {
			System.out.println("Search Successful! You Searched for "+ what+ " jobs. Current Page Title: "+ searchTitle);
		}
		else {
			System.out.println("Search has failed! Current Page Title: "+searchTitle);
		}
		
		//10.)	Get Text of the JobsInLocation field, store it in a variable, 
		String whatCheck = driver.findElement(By.xpath("//h1[@class='jobsearch-SerpTitle i-unmask']")).getText();
		
		
		//11.)	then verify if it's equal to your search criteria.
		if(what.equals(whatCheck.substring(0, what.length()))) {
			System.out.println("Search Successful! Your Search recieved "+ whatCheck);
		}
		else {
			System.out.println("Search has failed! Your Search recieved "+ whatCheck);
		}
		
		driver.quit();
	}
}
