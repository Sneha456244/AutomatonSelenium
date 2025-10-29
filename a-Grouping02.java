package GroupingTest;

import org.testng.annotations.Test;

public class PaymentTests {
	
	
	@Test(priority=1,groups= {"sanity","regression","functional"})
	  public void paymentinRupees() 
	  {
		  System.out.println("Payment in Rupees");
	  }
	  
	  @Test(priority=2,groups= {"sanity","regression","functional"}) 
	  public void paymentinDollars()
	  {
		  System.out.println("Payment in Dollars");
	  }
	  
}
