package TestNGpeck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void start() {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://devglow.webnerserver.com/signin");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
		
	}
		 
	@Test(priority=1)
	public void validcredential() {
		driver.findElement(By.id("UserName")).sendKeys("nishu.kumari@webners.com");		
		driver.findElement(By.id("Password")).sendKeys("Wbs@@6767");
		
		driver.findElement(By.id("submitbtn")).click();
		
		
//		
//		String expected=driver.findElement(By.xpath("//span[normalize-space()='Home']")).getText();
//		String actual="Home"	;
//		Assert.assertEquals(actual, expected);
		
		
		
	}
	
	@Test(priority=2)
	public void invalidcredential() {
		driver.findElement(By.id("UserName")).sendKeys("nishu.kumari1@webners.com");		
		driver.findElement(By.id("Password")).sendKeys("Wbs@@6767");
		
		driver.findElement(By.id("submitbtn")).click();
		String actual=driver.findElement(By.id("Error1")).getText();
		String expected ="Email does not exists";
		Assert.assertEquals(actual, expected);
		
	}
	
	@AfterMethod
	public void closure() {
		driver.quit();
	}
	
	
	}
	

	
	
	
