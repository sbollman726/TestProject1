package day10_FrameWorkDesign;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver;

public class Recycle {

	public static void main(String[] args) throws InterruptedException {

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

			Driver.getDriver().manage().window().maximize();
			Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
			
			Actions doSomething = new Actions(Driver.getDriver());
			
			//		 go to "http://practice.primetech-apps.com/practice/drag-and-drop"
			Driver.getDriver().get("http://practice.primetech-apps.com/practice/drag-and-drop");
			
			//	 	Verify Drag And Drop text displays
			if(Driver.getDriver().findElement(By.xpath("//h3[contains(text(), 'Drag And Drop')]")).isDisplayed()) {
				System.out.println("Drag and Drop is present");
			}
			else {
				System.out.println("Drag and Drop is present");
			}
			
			//		drag the Text element to target window
			WebElement sourceElement = Driver.getDriver().findElement(By.id("text"));
			WebElement targetElement = Driver.getDriver().findElement(By.id("dropzone"));
			
			doSomething.dragAndDrop(sourceElement, targetElement).build().perform();
			Thread.sleep(1000);
			
			//		drag the Textarea element to target window
			WebElement sourceElement2 = Driver.getDriver().findElement(By.id("textarea"));
			
			doSomething.dragAndDrop(sourceElement2, targetElement).build().perform();
			Thread.sleep(1000);
			
			//		drag the Number element to target window
			WebElement sourceElement3 = Driver.getDriver().findElement(By.id("Number"));
			
			doSomething.dragAndDrop(sourceElement3, targetElement).build().perform();
			Thread.sleep(1000);
			
			//		delete all those dragged items from target window
			List<WebElement> trash = Driver.getDriver().findElements(By.xpath("//i[@class='bi bi-trash']"));
			for (int i = 0; i < trash.size(); i++) {
				trash.get(i).click();
				Thread.sleep(1000);
			}
		
			
			Thread.sleep(2000);
			Driver.quitDriver();
		}
	}



