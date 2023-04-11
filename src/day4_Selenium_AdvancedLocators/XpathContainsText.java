package day4_Selenium_AdvancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathContainsText {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		etsyXpath();
		
	}

	public static void etsyXpath () throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String autoE = "automation@gmail.com";
		String autoN = "automation";
		String autoP = "automation3420";
		
		//go to etsy.com
		driver.get("https://etsy.com");
	
		//find sign in button
	//	driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
		driver.findElement(By.cssSelector(".select-signin")).click();
		Thread.sleep(2000);
		
		//find register button
	//	driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
		driver.findElement(By.cssSelector(".select-register")).click();
		Thread.sleep(1500);
		
		//enter email field
	//	driver.findElement(By.xpath("//input[contains(@id, 'join_neu_email_field')]")).sendKeys(autoE);
		driver.findElement(By.cssSelector("")).click();

		
		//enter first name
		driver.findElement(By.xpath("//input[contains(@id, 'join_neu_first_name_field')]")).sendKeys(autoN);
		
		//enter password
		driver.findElement(By.xpath("//input[contains(@id, 'join_neu_password_field')]")).sendKeys(autoP);
		
		//click register
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();

		
		Thread.sleep(2000);
		String errorMessage = driver.findElement(By.xpath("//div[contains(@id, 'aria-join_neu_email_field-error')]")).getText();
		
		if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
			System.out.println("Test Pass!");
		}
		else {
			System.out.println("Test Fail!");
		}
		
		driver.quit();
	}
	
}
