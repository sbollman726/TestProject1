package Day1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_setUp {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		// Stops the jvm for the given number of mili seconds
		
		System.out.println("Home Page title is: "+ driver.getTitle());
		System.out.println("Home Page URL is: "+ driver.getCurrentUrl() );
		
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee Mug");
		// If a function returns something, we can either store that returned
		// data in a variable, or we can do a chain reaction
		
	/*	// chain action
		String str = "Hello World!";
		str.substring(3).trim().concat("I love Java");
	*/	
		// If the return type is void, we can not do any action after because
		// there is no return data
		
		
		//find by Id
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(1000);

		// Find by name
//		driver.findElement(By.name("q")).sendKeys("software test engineer");
		
		// Find by linkText
		driver.findElement(By.linkText("Customer Service")).click();


		
	}
	
}
