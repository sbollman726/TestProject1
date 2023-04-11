package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownSelect {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		
	//	dropdownDemo();
	//	nonSelectDropdown();
		alertDemo();
	
	}
	
	public static void dropdownDemo() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().to("https://amazon.com");
		Thread.sleep(2000);
		
		
		WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
		
		Select choose = new Select(selectElement);
		
		WebElement firstSelectedOption = choose.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
		Thread.sleep(1000);
		
		choose.selectByVisibleText("Home & Kitchen");
		Thread.sleep(1000);
		
		choose.selectByIndex(2);
		Thread.sleep(1000);
		
		choose.selectByValue("search-alias=stripbooks");
		System.out.println(choose.getFirstSelectedOption().getText());
		
		
		List<WebElement>allOptions = choose.getOptions();
		System.out.println("There are " +allOptions.size()+" departments.");
		for (int i = 0; i < allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void nonSelectDropdown() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		//go to website
		driver.navigate().to("https://semantic-ui.com/modules/dropdown.html");
		
		//wait until dropdown element is visable
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='ui fluid selection dropdown'][1]"));
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		//click on element
		dropdown.click();
		
		WebElement mattOption = driver.findElement(By.xpath("//div[@data-value='matt']"));
		wait.until(ExpectedConditions.visibilityOf(mattOption));
		mattOption.click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void alertDemo() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.findElement(By.id("confirm")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		Thread.sleep(1000);
		handle.accept();
		
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle2 = driver.switchTo().alert();
		System.out.println(handle2.getText());
		handle2.sendKeys("Sam");
		handle2.dismiss();
		
	}

}
