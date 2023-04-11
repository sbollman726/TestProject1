package day6_WorkingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonActivity {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

		amazonActivity tom = new amazonActivity();
		
	//	tom.navigate();
		tom.elementStatus();
		
	}
	public  void navigate() throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();

		//declare implicity wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//go to amazon.com
		driver.navigate().to("https://amazon.com");
		
		//Search for coffee mug
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("coffee mug"+ Keys.ENTER);
		
		//Navigate back then search pretty coffee mug
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pretty coffee mug"+ Keys.ENTER);
		
		//Navigate back then navigate forwards
		driver.navigate().back();
		driver.navigate().forward();
		
		//Refresh the page
		driver.navigate().refresh();
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void elementStatus() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//go to indeed.com
		driver.navigate().to("https://indeed.com");
		
		//
		WebElement what = driver.findElement(By.id("text-input-what"));
		WebElement where = driver.findElement(By.id("text-input-where"));
		

		System.out.println(what.isEnabled());
		System.out.println(what.isDisplayed());
		
		System.out.println(where.isEnabled());
		System.out.println(where.isDisplayed());

		if(what.isEnabled() && what.isDisplayed()) {
			System.out.println("What field is enabled and displayed.");
		}
		else {
			System.out.println("What field is either not enabled or displayed.");
		}
		
		if(where.isEnabled() && where.isDisplayed()) {
			System.out.println("Where field is enables and displayed.");
		}
		else {
			System.out.println("Where field is either not enabled or displayed.");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
