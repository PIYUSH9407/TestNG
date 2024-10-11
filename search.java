package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class search {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void start() {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://tutorialsninja.com/demo/");
	}
	
	
	@Test (priority=1)
	public void testsearchfunctionitywithexistingProduct() {
		
		
		WebElement searchboxfield=driver.findElement(By.name("search"));
		searchboxfield.sendKeys("HP");
		/*
		 * search HP product
		 */
		driver.findElement(By.xpath("//*[@class=\"btn btn-default btn-lg\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
		
		driver.quit();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
		
	
	
	@Test(priority=2)
	
	public void testSearchFunctionalitywithNonExistingProduct(){
		
		WebElement searchboxfield=driver.findElement(By.name("search"));
		searchboxfield.sendKeys("Honda");
		
		driver.findElement(By.xpath("//*[@class=\"btn btn-default btn-lg\"]")).click();
		
		// String para="//input[@id=\"button-search\"]/following-sibling::p";
		String actual=driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		String expected="There is no product that matches the search criteria.";
		Assert.assertEquals(actual,expected );
		
		driver.quit();
		
	
	}
	
	@Test(priority=3)
	public void testsearchfunctionlitywithoutenteringanyProduct(){
		
		driver.findElement(By.xpath("//*[@class=\"btn btn-default btn-lg\"]")).click();
		
		String actual=driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		String expected="There is no product that matches the search criteria.";
		Assert.assertEquals(actual,expected );
		
		driver.quit();
		
	}
 		
}
		 
		 
		
