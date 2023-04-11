package day4_Selenium_AdvancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_homeworkRecap {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
			facebookTestCase();
	//		facebookTestCase2();
	//		indeedTestCase();

			
			
	}
	
	public static void facebookTestCase () throws InterruptedException   {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://Facebook.com");
		Thread.sleep(2000);
		
		String autoE = "automation@gmail.com";
		String autoP = "automation";

		
		
		driver.findElement(By.xpath("//input[@data-testid='royal_emai']")).sendKeys(autoE);
		driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys(autoP);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void facebookTestCase2() throws InterruptedException {
	
	String autoP = "automation";
	String autoE = "automation@gmail.com";
	
	WebDriver driver = new ChromeDriver();
		
		driver.get("https://Facebook.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(autoP);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(autoP);

		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(autoE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(autoE);
		
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(autoP);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		driver.quit();	
	}
	public static void indeedTestCase() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://indeed.com");
		Thread.sleep(2000);
		
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		
		String what = "sdet";
		String where = "Washington DC";
		
		driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys(what);
		
		WebElement tom = driver.findElement(By.xpath("//input[@name='l']"));
		
		
		String locationText = tom.getAttribute("value");
		for (int i = 0; i < locationText.length(); i++) {
			tom.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(325);
		}
		
	/*	another was of deleting the text in a box by looping
	 	tom.sendKeys(Keys.CONTROL + "a");
		tom.sendKeys(Keys.DELETE);
		tom.sendKeys(where);
	*/	
		tom.sendKeys(where);
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();
		
		
		if(!searchURL.equals(homeURL)) {
			System.out.println("Search Successful! New URL: "+ searchURL);
		}
		else {
			System.out.println("Search Failed! URL remains the same.");
		}
		if(!searchTitle.equals(homeTitle)) {
			System.out.println("Search Successful! New Page Title: "+ searchTitle);
		}
		else {
			System.out.println("Search Failed! Page Title remains the same.");
		}
		
		
		String whatSearchText = driver.findElement(By.xpath("//h1[@class='jobsearch-SerpTitle i-unmask']")).getText();
		
		if(what.equals(whatSearchText.substring(0,what.length()))) {
			System.out.println("Search Successful! You search for "+ what + " jobs.");
		}
		else {
			System.out.println("Search Failed! You searched for: "+what +". What came out was: "+ whatSearchText.substring(0,what.length()));
		}

		driver.quit();
	}
}
