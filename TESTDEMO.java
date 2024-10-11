package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TESTDEMO{
	
	
		WebDriver driver ;
		
		@Test
			
		public void verfiedtitle()  {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://omayo.blogspot.com/");
			String actual = driver.getTitle();
			String expected = "omayo (QAFox.com)";
			System.out.println(driver.getTitle());
			if(actual.equalsIgnoreCase(expected)) {
				System.out.println("pass this");
			}
			else {
				System.out.println("fail");
			}
			
			driver.findElement(By.id("ta1")).sendKeys("this is a tasting string");
			
			
			
			
			driver.findElement(By.id("radio1")).click();
		}
}
		
	

