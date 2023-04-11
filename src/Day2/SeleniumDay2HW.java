package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDay2HW {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	
		SeleniumDay2HW phill = new SeleniumDay2HW();
		
//		phill.testcase1();
		phill.testcase2();
		

	}
////////////////////////////////////////////////////////////////
	public void	testcase1() throws InterruptedException {
	/*	
	1	Go to etsy.com
	2	Find Sign in button and click on it
	3	Find email address field and type "automation"
	4	Find the password field and type "automation"
	5	Find the sign in button and click on it
		
	*/
		WebDriver driver = new ChromeDriver();
		String autoemail = "automation@gmail.com";
		String autopass = "automation";
		
		//1.)	Go to etsy.com
		driver.get("http://etsy.com");
		Thread.sleep(2000);
		
		//2.)	Find Sign in button and click on it
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(2000);
		
		//3.)	Find email address field and type "automation"
		driver.findElement(By.id("join_neu_email_field")).sendKeys(autoemail);
		
		//4.)	Find the password field and type "automation"
		driver.findElement(By.id("join_neu_password_field")).sendKeys(autopass);
		Thread.sleep(2000);
		
		//5.)	Find the sign in button and click on it
		driver.findElement(By.name("submit_attempt")).click();

		Thread.sleep(5000);
		driver.quit();
	}
/////////////////////////////////////////////////////////////////	
	public void	testcase2() throws InterruptedException {
		/*
	1. go to indeed.com
	2. get the current URL and store it in a variable called homeURL.
	3. get the website title and store it in a variable homeTitle.
	4. find the input field for WHAT and type SDET
	5. find the Search button and click on it.
	6. get the current URL and store it a variable searchURL.
	7. get the website title and store it in a variable searchTitle.
	8. verify that searchURL does not equal to homeURL and contains the search criteria.
	9. verify that searchTitle does not equal to homeTitle and has the search criteria.
	10. Get Text of the JobsInLocation field, store it in a variable, then verify if it's equals to your search criteria. 
		*/
		String search = "SDET";
		
		WebDriver driver = new ChromeDriver();
	
		//1.)	go to indeed.com
		driver.get("http://indeed.com");
		Thread.sleep(2000);
		
		//2.)	get the current URL and store it in a variable called homeURL.
		String homeUrl = driver.getCurrentUrl();
		//3.)	get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
		
		//4.)	find the input field for WHAT and type SDET
		driver.findElement(By.id("text-input-what")).sendKeys(search);
		
		//5.)	find the Search button and click on it.
		driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
	
		//6.)	get the current URL and store it a variable searchURL.
		String searchUrl = driver.getCurrentUrl();
		//7.)	get the website title and store it in a variable searchTitle.
		String searchTitle = driver.getTitle().toUpperCase();
		
		//8.)	verify that searchURL does not equal to homeURL and contains the search criteria.
		if(!homeUrl.equals(searchUrl) && searchUrl.contains(search)) {
			System.out.println("Contains search criteria. The new Url is: "+ searchUrl);
		}
		else {
			System.out.println("You are on the same page, URL remains the same, Does not contain search criteria.");
		}
		
		//9.)	verify that searchTitle does not equal to homeTitle and has the search criteria.
		if(!homeTitle.equals(searchTitle) && searchTitle.contains(search)) {
			System.out.println("The New Page Title is: "+ searchTitle);
		}
		else {
			System.out.println("You are on the same page, Page Title remains the same, Does not contain search criteria.");
		}
		
		//	10. Get Text of the JobsInLocation field, store it in a variable, then verify if it's equals to your search criteria. 
		String check = driver.findElement(By.xpath("//h1[@ class]")).getText();
		
		if(search.equals(check.substring(0,search.length()))){
			System.out.println("Search Sucessful! Current Search: "+ search);
		}
		else {
			System.out.println("Search Failed.");
		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}