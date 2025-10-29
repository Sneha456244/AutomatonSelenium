package GroupingTest;

import org.testng.annotations.Test;

public class SignupTests {
	
	@Test(priority=1,groups= {"regression"})
	  public void signupByEmail() 
	  {
		  System.out.println("This is signup by Email");
	  }
	  
	  @Test(priority=2,groups= {"regression"}) 
	  public void signupByFacebook()
	  {
		  System.out.println("This is signup by Facebook");
	  }
	  
	  @Test(priority=3,groups= {"regression"})
	  public void signupByTwitter()
	  {
		  System.out.println("This is signup by Twitter");
	  }
}
