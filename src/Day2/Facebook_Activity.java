package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_Activity {

	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	
		Facebook_Activity fb = new Facebook_Activity();
//		fb.testcase1();
		fb.testcase2();
//		fb.getTextPractice();
		
	}
	
	
	public void	testcase1() throws InterruptedException {
			
		WebDriver driver = new ChromeDriver();
		String auto = "automation";
		

		driver.get("http://facebook.com");
		Thread.sleep(2000);
				
		driver.findElement(By.id("email")).sendKeys(auto);
		
		driver.findElement(By.id("pass")).sendKeys(auto);
		Thread.sleep(2000);
		
		driver.findElement(By.name("login")).click();	
		
		
		Thread.sleep(5000);
		driver.close();	
	}
	
	
	
	public void testcase2() throws InterruptedException {
			
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		Thread.sleep(2000);
		
		String auto = "automation";
		String autoemail = "automation@gmail.com";
				
		
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("firstname")).sendKeys(auto);
		
		driver.findElement(By.name("lastname")).sendKeys(auto);
		Thread.sleep(2000);
		
		driver.findElement(By.name("reg_email__")).sendKeys(autoemail);
		
		driver.findElement(By.name("reg_passwd__")).sendKeys(auto);
		
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(autoemail);
		Thread.sleep(2000);


		driver.findElement(By.name("websubmit")).click();
		
		Thread.sleep(5000);
		driver.close();
	}
	
	
	public void getTextPractice() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		Thread.sleep(2000);
		
		String loginText = driver.findElement(By.name("login")).getText();
		System.out.println("Log in button text is: "+ loginText);
		
		if(loginText.equals("Log In")) {
			System.out.println("Test Pass!");
		}
		else {
			System.out.println("Test Failed!");
		}
		
		Thread.sleep(1000);
		driver.close();
	}
	
	
}
