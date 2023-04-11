package day8_popupAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day7HwReview {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
//		testcase1();
		testcase2();
		
	}
	
	public static void testcase2() {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		
		driver.get("http://practice.primetech-apps.com/practice/alerts ");
		
		String text = "PrimeTech";
		
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		
		handle.sendKeys(text);
		handle.accept();
		
		WebElement greetingTextElement = driver.findElement(By.id("demo"));
		wait.until(ExpectedConditions.visibilityOf(greetingTextElement));
		
		String greetingText = greetingTextElement.getText();
		if(greetingText.equals("Hello "+ text + "! How are you today?")) {
			System.out.println("Test Pass!");
		}
		else {
			System.out.println("Test Fail!");
		}
		
		
	}
	
	
	
	public static void testcase1() {
		
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
		//     go to amazon.com
		driver.get("https://amazon.com");
		
		//Verify that you are on the amazon home page. (verify with title)
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		
		if(driver.getTitle().equals(expectedTitle)) {
			System.out.println("We are on the Home page!");
		}
		else {
			System.out.println("We are NOT on the Home page!");
		}
		
		//verify dropdown value is by default "All departments
		String defualtDropdownValue = "All Departments";
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		
		Select letSelect = new Select(dropdown);
		String actualSelectedOption = letSelect.getFirstSelectedOption().getText();
		if(actualSelectedOption.equals(defualtDropdownValue)) {
			System.out.println("Default dropdown value matches");
		}
		else {
			System.out.println("Default dropdown value does NOT matche");
		}
		
		//select department Home & Kitchen, and search coffee mug
		String searchItem = "coffee mug";
		letSelect.selectByVisibleText("Home & Kitchen");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//verify you are on coffee mug search results page (use title)
		String itemPageTitle = driver.getTitle();
		// Amazon.com : Coffee Mug   23 - 10 = 13
		int beginingIndex = itemPageTitle.length() - searchItem.length();
			
		if(itemPageTitle.substring(beginingIndex).equals(searchItem)) {
		System.out.println("Search item title match");	
		}
		else {
			System.out.println("Search item title does not match");
		}
		
		//verify you are in Home & Kitchen department
		WebElement dropdown2 = driver.findElement(By.id("searchDropdownBox"));
		
		Select letSelect2 = new Select(dropdown2);
		String SelectedOption = letSelect2.getFirstSelectedOption().getText();
		if(SelectedOption.equals("Home & Kitchen")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		
		
	//	driver.quit();
	}

}
