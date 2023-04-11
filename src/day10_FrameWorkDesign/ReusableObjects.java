package day10_FrameWorkDesign;

import org.openqa.selenium.By;

import pages.FacebookPage;
import utils.DataReader;
import utils.Driver;

public class ReusableObjects {

	public static void main(String[] args) throws InterruptedException  {

		ReusableObjects obj = new ReusableObjects();
		obj.testcase1();
		obj.testcase2();
		obj.getTextPractice();
		
	}
	
	FacebookPage fbPage;
	
	public void	testcase1() throws InterruptedException {
		
		fbPage = new FacebookPage();
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Thread.sleep(2000);
				
		fbPage.FBemailField.sendKeys(DataReader.getProperty("facebookUser"));
		
		fbPage.FBpassField.sendKeys(DataReader.getProperty("facebookPass"));
		Thread.sleep(2000);
		
		fbPage.FBloginField.click();	
		
		
		Thread.sleep(5000);
		Driver.quitDriver();
	}
	
	
	
	public void testcase2() throws InterruptedException {
			
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Thread.sleep(2000);
		
		String auto = "automation";
		String autoemail = "automation@gmail.com";
				
		
		Driver.getDriver().findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		
		Driver.getDriver().findElement(By.name("firstname")).sendKeys(auto);
		
		Driver.getDriver().findElement(By.name("lastname")).sendKeys(auto);
		Thread.sleep(2000);
		
		Driver.getDriver().findElement(By.name("reg_email__")).sendKeys(autoemail);
		
		Driver.getDriver().findElement(By.name("reg_passwd__")).sendKeys(auto);
		
		Driver.getDriver().findElement(By.name("reg_email_confirmation__")).sendKeys(autoemail);
		Thread.sleep(2000);


		Driver.getDriver().findElement(By.name("websubmit")).click();
		
		Thread.sleep(5000);
		Driver.quitDriver();
	}
	
	
	public void getTextPractice() throws InterruptedException {
		
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Thread.sleep(2000);
		
		String loginText = Driver.getDriver().findElement(By.name("login")).getText();
		System.out.println("Log in button text is: "+ loginText);
		
		if(loginText.equals("Log In")) {
			System.out.println("Test Pass!");
		}
		else {
			System.out.println("Test Failed!");
		}
		
		Thread.sleep(1000);
		Driver.quitDriver();
	}
	

}
