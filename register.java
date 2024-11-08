package TestNGpeck;

import org.testng.annotations.Test;

public class register {
	
	@Test(priority=1)
   public void name() {
	   System.out.println("enter name ");
   }
	
	@Test(priority=2)
   
	   public void age() {
		   System.out.println("enter age ");
	   }
	
	@Test(priority=3)
   
	   public void genfer() {
		   System.out.println("enter gender ");
	   }

}
