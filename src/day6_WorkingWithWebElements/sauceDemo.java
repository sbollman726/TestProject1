package day6_WorkingWithWebElements;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauceDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

		
	//	testCase1();
		testCase2();
		
	}
	
	public static void testCase1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Go to Saucedemo.com
		driver.navigate().to("https://saucedemo.com");
		Thread.sleep(2000);
		
		//login: User-standard_user       Password- secret_sauce
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		
		driver.findElement(By.id("login-button")).click();
		
		
		//Find all the results and get them in a list, and print the size of the list
		List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));
		int listSize = items.size();
		System.out.println(listSize);
		
		
		Thread.sleep(2000);
	//	driver.quit();
	}
	public static void testCase2() throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Go to Saucedemo.com
		driver.navigate().to("https://saucedemo.com");
		Thread.sleep(2000);
		
		//login: User-standard_user       Password- secret_sauce
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		
		driver.findElement(By.id("login-button")).click();
		
		
		List<WebElement> itemPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
		for (int i = 0; i < itemPrices.size(); i++) {
			System.out.println(itemPrices.get(i).getText());	
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
