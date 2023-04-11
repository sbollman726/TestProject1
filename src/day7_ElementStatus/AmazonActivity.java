package day7_ElementStatus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonActivity {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		testCase1();

	}
	
	public static void testCase1() {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		driver.navigate().to("https://amazon.com");
		
		WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
		wait.until(ExpectedConditions.visibilityOf(selectElement));
		
		Select choose = new Select(selectElement);
		
		System.out.println("There are "+ selectElement.getSize() + "departments");
		System.out.println(choose.getOptions());
		
		
		
	}
	public static void testCase2() {
		
		
		//.getTitle
		//getFirstSelectedOption
		
	}

}
