package day6_WorkingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysEventPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // waits for page to be load
		driver.manage().window().maximize();
		
		driver.navigate().to("https://google.com");
	//	driver.get("http://google.com");
		Thread.sleep(2000);
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		
		searchbox.sendKeys("Coffee Mug" + Keys.ENTER); // opens a new page
		Thread.sleep(1000);
		
		WebElement newsearchbox = driver.findElement(By.name("q"));
		newsearchbox.clear();
		Thread.sleep(1000);
		
		newsearchbox.sendKeys("Selenium Webdriver" + Keys.ENTER); // opens a new page
		Thread.sleep(1000);
		
		driver.navigate().back(); // opens a new page****
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
}
