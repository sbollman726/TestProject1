package day9_ActionsClass;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day9Hw {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			
		testCase1();
	}
	public static void testCase1() throws InterruptedException {
		/*
		go to "http://practice.primetech-apps.com/practice/drag-and-drop"
	 	Verify Drag And Drop text displays
		drag the Text element to target window
		drag the Textarea element to target window
		drag the Number element to target window
		delete all those dragged items from target window
		*/
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		Actions doSomething = new Actions(driver);
		
		//		 go to "http://practice.primetech-apps.com/practice/drag-and-drop"
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		
		//	 	Verify Drag And Drop text displays
		if(driver.findElement(By.xpath("//h3[contains(text(), 'Drag And Drop')]")).isDisplayed()) {
			System.out.println("Drag and Drop is present");
		}
		else {
			System.out.println("Drag and Drop is present");
		}
		
		//		drag the Text element to target window
		WebElement sourceElement = driver.findElement(By.id("text"));
		WebElement targetElement = driver.findElement(By.id("dropzone"));
		
		doSomething.dragAndDrop(sourceElement, targetElement).build().perform();
		Thread.sleep(1000);
		
		//		drag the Textarea element to target window
		WebElement sourceElement2 = driver.findElement(By.id("textarea"));
		
		doSomething.dragAndDrop(sourceElement2, targetElement).build().perform();
		Thread.sleep(1000);
		
		//		drag the Number element to target window
		WebElement sourceElement3 = driver.findElement(By.id("Number"));
		
		doSomething.dragAndDrop(sourceElement3, targetElement).build().perform();
		Thread.sleep(1000);
		
		//		delete all those dragged items from target window
		List<WebElement> trash = driver.findElements(By.xpath("//i[@class='bi bi-trash']"));
		for (int i = 0; i < trash.size(); i++) {
			trash.get(i).click();
			Thread.sleep(1000);
		}
	
		
		Thread.sleep(2000);
	//	driver.quit();
	}
}
