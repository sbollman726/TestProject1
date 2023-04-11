package day3_Selenium_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		xpathDemo phil = new xpathDemo();
		
		phil.etsysearch();
		

	}

	public void etsysearch() throws InterruptedException {
	
		String auto = "automation@gmail.com";
		String pass = "automation";

		
	WebDriver driver = new ChromeDriver();
	
	//go to etsy.com
	driver.get("https://etsy.com");
	Thread.sleep(1000);
	
	//Click on sign in
	driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
	Thread.sleep(1000);

	//Click on register
	driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")).click();
	Thread.sleep(1000);

	//Enter email
	driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys(auto);
	
	//Enter first name
	driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']")).sendKeys(pass);

	//Emter password
	driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys("P@sswomswlw");
	Thread.sleep(1000);
	
	//Click register
	driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full']")).click();
	Thread.sleep(1000);
	
	//Verify error
	String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
	String  actualErrorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
													//*[@id="aria-join_neu_email_field-error"]
	if (actualErrorMessage.equals(expectedErrorMessage)) {
		System.out.println("Test Pass!");
	}
	else {
		System.out.println("Test Fail!");
	}
	Thread.sleep(3000);
//	driver.quit();
	}

	
}

