package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6HwReview {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
	//	radioButtonHw();
	//	checkboxHw();
		amazonHw();
		
	}
	
	public static void radioButtonHw() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().to("http://practice.primetech-apps.com/practice/radio-button");
		Thread.sleep(2000);
	
		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".form-check-input"));
		
		for(WebElement singleRadio : radioButtons) {
			if(singleRadio.isDisplayed() && singleRadio.isEnabled()) {
				if(singleRadio.isSelected()) {
				System.out.println("Radio Button is selected!");	
				}
				else {
					System.out.println("Radio Button is not selected!");
					Thread.sleep(1000);
					singleRadio.click();
				}
			}
			else {
				System.out.println("Something is not right, either not displayed or enabled.");
			}
			System.out.println("Is radio Button selected? " + singleRadio.isSelected());
		}
	
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void checkboxHw() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().to("http://practice.primetech-apps.com/practice/check-box");
		Thread.sleep(2000);
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[class=form-check-input]"));
		for(WebElement singlecheckBox : checkboxes) {
			if(singlecheckBox.isDisplayed()) {
				System.out.println("Its Displayed");
				if(singlecheckBox.isEnabled()) {
					System.out.println("Its Enabled");
					if(singlecheckBox.isSelected()) {
						System.out.println("It's selected");
					}
					else {
						System.out.println("Its not selected");
						singlecheckBox.click();
					}
				}
				else {
					System.out.println("It is not Enabled");
				}
			}
			else {
				System.out.println("It is not Displayed");
			}
			
			System.out.println("Is checkbox now selected? " + singlecheckBox.isSelected());
		}
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void amazonHw() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().to("http://amazon.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]")).click();
		
		if(driver.findElement(By.xpath("//h1[text()]")).isDisplayed()) {
			System.out.println("You are on the Sign in Page.");
		}
		else {
			System.out.println("You are not on the Sign in page.");
		}
		
		driver.navigate().back();
		driver.navigate().forward();
		
		if(driver.findElement(By.xpath("//h1[text()]")).isDisplayed()) {
			System.out.println("You are on the Sign in Page again.");
		}
		else {
			System.out.println("You are not on the Sign in page.");
		}
		
		driver.findElement(By.id("createAccountSubmit")).click();
		
		WebElement createAccountText = driver.findElement(By.xpath("//h1[contains(text(), \"Create account\")]"));
		
		if(createAccountText.isDisplayed()) {
			System.out.println("You are on the Create Account Page");
		}
		else {
			System.out.println("You are not on the Create Account Page");
		}
		
		driver.navigate().back();
		
		if(driver.findElement(By.xpath("//h1[text()]")).isDisplayed()) {
			System.out.println("You are on the Sign in Page again.");
		}
		else {
			System.out.println("You are not on the Sign in page.");
		}
		
		driver.navigate().forward();
		
		if(createAccountText.isDisplayed()) {
			System.out.println("You are on the Create Account Page again");
		}
		else {
			System.out.println("You are not on the Create Account Page again");
		}
		
		driver.findElement(By.id("continue")).click();
		
		WebElement nameError = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		if(nameError.isDisplayed()) {
			if(nameError.isDisplayed()) {
				if(nameError.getText().equals("Enter your name")) {
					System.out.println("Name Error is Displayed and matches");
				}
				else {
					System.out.println("Name Error does no match");
				}
			}
			else {
				System.out.println("Name Error is not displayed");
			}
		}
		else {
			System.out.println("Name Error is not displayed");
		}
		
		
		WebElement emailError = driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
		if(emailError.isDisplayed()) {
			if(emailError.isDisplayed()) {
				if(emailError.getText().equals("Enter your email or mobile phone number")) {
					System.out.println("Email Error is Displayed and matches");
				}
				else {
					System.out.println("Email Error does no match");
				}
			}
			else {
				System.out.println("Email Error is not displayed");
			}
		}
		else {
			System.out.println("Email Error is not displayed");
		}
		
		
		WebElement passError = driver.findElement(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
		if(passError.isDisplayed()) {
			if(passError.isDisplayed()) {
				if(passError.getText().equals("Minimum 6 characters required")) {
					System.out.println("Password Error is Displayed and matches");
				}
				else {
					System.out.println("Password Error does no match");
				}
			}
			else {
				System.out.println("Password Error is not displayed");
			}
		}
		else {
			System.out.println("Password Error is not displayed");
		}
		
		
		
	}
}
