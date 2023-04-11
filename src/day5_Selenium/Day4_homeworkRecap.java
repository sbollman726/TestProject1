package day5_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_homeworkRecap {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Samue\\PrimeTechJavaClass\\SeleniumTools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
	//	textBox();
		webTable();
		
		

	}
	public static void textBox() throws InterruptedException{
		
		/*
		Testcase 1: 

		Go to http://practice.primetech-apps.com/practice/text-box
		Find first name, last name, email, password, address fields, and type relevant information. 
		(Create variables for those information and pass the variable to the sendkey() method).
		Then click on submit button. (your inputs displays under user info section).
		Find your inputs and get text of each and store them into variables.
		Then compare your input with the displayed user information if they match.
		*/
		
		String first = "John";
		String last = "Smith";
		String email = "jsmith@gmail.com";
		String pass = "jsmith3356";
		String address = "123 State St, Washington, VA, 20033";


		
		
	WebDriver driver = new ChromeDriver();
	
	
//1.)		Go to http://practice.primetech-apps.com/practice/text-box
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		Thread.sleep(2000);
//2.)		Find first name, last name, email, password, address fields, and type relevant information. 
//3.)		(Create variables for those information and pass the variable to the sendkey() method).
		driver.findElement(By.cssSelector("#firstName")).sendKeys(first);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(last);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(address);
	
//4.)		Then click on submit button. (your inputs displays under user info section).
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
//5.)		Find your inputs and get text of each and store them into variables.
		String firstActual = driver.findElement(By.xpath("//div[text()='"+first+"']")).getText();
		System.out.println("Actual First name is: "+ firstActual);
		
		
		String lastActual = driver.findElement(By.xpath("//div[text()='"+last+"']")).getText();
		System.out.println("Actual Last name is: "+ lastActual);
		
		String emailActual = driver.findElement(By.xpath("//div[text()='"+email+"']")).getText();
		System.out.println("Actual Email is: "+ emailActual);
		
		String passActual = driver.findElement(By.xpath("//div[text()='"+pass+"']")).getText();
		System.out.println("Actual Password is: "+ passActual);
		
		String addressActual = driver.findElement(By.xpath("//div[text()='"+address+"']")).getText();
		System.out.println("Actual Address is: "+ addressActual);
		
//6.)		Then compare your input with the displayed user information if they match.
	
		if(firstActual.equals(first)) {
			System.out.println("First Name Test has Passed!");
		}
		else {
			System.out.println("First Name Test has failed");
		}
		
		if(lastActual.equals(last)) {
			System.out.println("Last Name Test has Passed");
		}
		else {
			System.out.println("Last Name Test has Passed");
		}
		
		if(emailActual.equals(email)) {
			System.out.println("Eamil Test has Passed");
		}
		else {
			System.out.println("Email Test has Passed");
		}
		
		
		if(passActual.equals(pass)) {
			System.out.println("Password Test has Passed");
		}
		else {
			System.out.println("Password Test has Passed");
		}
		
		if(addressActual.equals(address)) {
			System.out.println("Address Test has Passed");
		}
		else {
			System.out.println("Address Test has Passed");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
	public static void webTable() throws InterruptedException {
		/*
		Testcase 2: 

1. Go to http://practice.primetech-apps.com/practice/web-tables
2. Verify that you see Web Tables text
3. Find id, firstname, lastname, salary fields and give a relevant input. (store the information into variables, then pass the variable to sendKeys() method) 
4. Click on Add button
5. Then your inputs will display under the table. (use xpath text() contains() functions to locate those elements. get text and store them into variables)
6. Verify your input under the table match the input you added. 
		*/
		
		WebDriver driver = new ChromeDriver();
		
//1. Go to http://practice.primetech-apps.com/practice/web-tables		
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		Thread.sleep(2000);
		
//2. Verify that you see Web Tables text		
		String webtableHeaderText = driver.findElement(By.xpath("//h3[text()='Web Tables']")).getText();
		if(webtableHeaderText.equals("Web Tables")) {
			System.out.println("We are on the Web Table Page");
		}
		else {
			System.out.println("We are not on the Web Table Page");
		}
		
//3. Find id, firstname, lastname, salary fields and give a relevant input. (store the information into variables, then pass the variable to sendKeys() method) 		
		int id = 123;
		String first = "John";
		String last = "Smith";
		int salary = 120000;
		
		
//4. Click on Add button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

//5. Then your inputs will display under the table. (use xpath text() contains() functions to locate those elements. get text and store them into variables)
		String idActual = driver.findElement(By.xpath("//td[text()='"+id+"'")).getText();
		System.out.println(idActual);
		
		String firstActual = driver.findElement(By.xpath("//td[text()='"+first+"'")).getText();
		System.out.println(firstActual);
		
		String lastActual = driver.findElement(By.xpath("//td[text()='"+last+"'")).getText();
		System.out.println(lastActual);
		
		String salaryActual = driver.findElement(By.xpath("//td[text()='"+salary+"'")).getText();
		System.out.println(salaryActual);
		
//6. Verify your input under the table match the input you added. 
		if (Integer.parseInt(idActual) == id) {
			System.out.println("Id is good, Test Pass");
		}
		else {
			System.out.println("Id is not good, Test Failed");
		}
		
		
		
	}
	
}
