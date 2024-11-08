package TestNGpeck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homepage {
	
	   WebDriver driver;
	   
	 
	   @BeforeMethod
	   public void start() {
		   driver=new ChromeDriver();
		   driver.get("https://winsurtechglow.com/signin");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
	   }
	
	   
	   @Test(priority=1)
		public void validcredential() {
			driver.findElement(By.id("UserName")).sendKeys("pratham.mittal@webners.com");		
			driver.findElement(By.id("Password")).sendKeys("Wbs@@6767");
			
			driver.findElement(By.id("submitbtn")).click();
        }
	   
	   
	   @Test(priority=2)
	   public void CRM() throws InterruptedException  {
		
		   validcredential();
		   
		   driver.findElement(By.className("nav-text")).click();
		   
		   driver.findElement(By.xpath("//span[normalize-space()='Leads']")).click();
		  
		   driver.findElement(By.xpath("//div[@title='Add Lead']")).click();
		  
		   Thread.sleep(1000);
		  
		   driver.findElement(By.id("Name")).sendKeys("automation lead");   //working
		  
		   WebElement gender=driver.findElement(By.id("Gender"));
		   gender.click();
		   
		   Select drop=new Select(gender);
		   drop.selectByIndex(1);
		  
		   Thread.sleep(1000);
		  
		   WebElement branchdrop = driver.findElement(By.id("LeadBranches"));
		   branchdrop.sendKeys("15987");
		  
		   
		  
		   
		   Thread.sleep(5000);
		   
		   driver.findElement(By.id("Address")).sendKeys("sector 67 mohali");
		   driver.findElement(By.id("Address2")).sendKeys("sector 51 mohali");
		   
		   // state
		   WebElement state = driver.findElement(By.id("state"));
		   state.click();
		   
		   Select drpDwn = new Select(state);
		   drpDwn.selectByVisibleText("Florida");
		   
		   
		   WebElement city = driver.findElement(By.id("city"));
		   city.click();
		   Select drpDwn1 = new Select(city);
		   drpDwn1.selectByIndex(5);
		   
		   driver.findElement(By.xpath("//body/div[@id='AddLeadModal']/div[@class='modal-dialog']/div[@class='modal-content modal-content-lead']/form[@id='LeadForm']/div[@class='mt-3 modal-footer']/button[1]")).click();
		   
		  Assert.assertTrue(true);
	   }
	   
	   @AfterMethod
	   public void close() {
		   
		   driver.quit();
	   }
	   
	   @Test(priority=3)
	   public void oppotunitydetails() throws InterruptedException {
		   
		   validcredential();
		  
		   // click on CRM
		   driver.findElement(By.className("nav-text")).click();
		   
		   // Click on opprtunity
		   
		   driver.findElement(By.xpath("//span[normalize-space()='Opportunities']")).click();
		   
		   // click on opprtunity model
		   driver.findElement(By.xpath("//div[@id='opportunityModalPopup']")).click();
		   
		   //opprtunity section
		   
		  driver.findElement(By.id("lead")).sendKeys("27 sep 2024 ()");
		  driver.findElement(By.id("opportunity")).sendKeys("opp automation");
		  driver.findElement(By.id("premium")).sendKeys("1999");
		  
		  WebElement billingdropdown =driver.findElement(By.id("ParentUserCarrier"));
		  billingdropdown.click();
		  
		  Select drop=new Select(billingdropdown);
		  drop.selectByIndex(5);
		  
		  Thread.sleep(2000);
		  
		  WebElement writingdropdown =driver.findElement(By.id("ChildUserCarrier"));
		  writingdropdown.click();
		  
		  
		  Select writingcarir=new Select(writingdropdown);
		  drop.selectByIndex(5);
		 
		  Thread.sleep(2000);
		  
		  WebElement term_length= driver.findElement(By.id("TermLengthId"));
		  term_length.click();
		  
		  Select term_drop=new Select(billingdropdown);
		  drop.selectByIndex(1);
		  
		  Thread.sleep(2000);
		  
		 WebElement Lobs= driver.findElement(By.id("_LineofBusiness"));
		 Lobs.click();
		 
		 Select Lobs_drop=new Select(billingdropdown);
		 Lobs_drop.selectByIndex(0);
		 
		 
		// cancel the opportunity
		 
		 driver.findElement(By.id("cancel-button")).click();
		 
		 Assert.assertTrue(true);
		 
		 Thread.sleep(2000);
		 
		 
	   }
	   
	   @Test(priority=4)
	   public void ContactInfomation() throws InterruptedException {
		   validcredential();
		  
		   //click on CRM
		   driver.findElement(By.className("nav-text")).click();
		   
		   // click on Contacts
		   driver.findElement(By.xpath("//span[normalize-space()='Contacts']")).click();
		   driver.findElement(By.xpath("//div[@title=\"Add Contact\"]")).click();
		   
		   driver.findElement(By.id("ContactName")).sendKeys("automation contect");
		   driver.findElement(By.id("lead")).sendKeys("27 sep 2024 ()");
		   
		   WebElement ContactGender= driver.findElement(By.id("ContactGender"));
		   ContactGender.click();
		   
		   Select ContactGenderdropdow=new Select(ContactGender);
		   ContactGenderdropdow.selectByVisibleText("Male");
		   
		   WebElement relation=driver.findElement(By.id("Relationship"));
		   relation.click();
		   
		   Select relationdropdown=new Select(relation);
		   relationdropdown.selectByIndex(3);

		   String expected ="Spouse";
		   String actual=driver.findElement(By.xpath("//*[@value=\"Spouse\"]")).getText();
		   
		   Assert.assertEquals(actual, expected);
		   System.out.println(actual);
		   
		   WebElement radioyes =driver.findElement(By.id("Primary"));
		   radioyes.click();
		   
		   System.out.println(radioyes.isSelected()); 
		   
		   driver.findElement(By.id("ContactAddress")).sendKeys("contect adress1");
		   driver.findElement(By.id("ContactAddress2")).sendKeys("contect adress1");
		   
		   WebElement state=driver.findElement(By.id("Contactstate"));
		   state.click();
		   
		   Select statedropdown=new Select(state);
		   statedropdown.selectByIndex(7);
		   
		   WebElement city=driver.findElement(By.id("Contactcity"));
		   city.click();
		   
		   Select citydropdown=new Select(state);
		   citydropdown.selectByIndex(5);
		 
		 
		   driver.findElement(By.id("ContactZipCode")).sendKeys("contect_zipcode");
		   
		   driver.findElement(By.xpath("//form[@id='ContactForm']//button[@type='button']"
				   + "[normalize-space()='Cancel']")).click();
		   
		   Thread.sleep(100);
		   
		 
		
		
	   }
	
}
	    
	   
	   
	   

		   


		   
		   



		   
		   
		   
