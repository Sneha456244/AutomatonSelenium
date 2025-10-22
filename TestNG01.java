package TestNG01;

import org.testng.annotations.Test;

// Open the application
// Login 
// Logout

public class FirstTestcase {
	
	@Test(priority=1)
	void openapp()
	{
		System.out.println("Open the application....");
	}
	
	@Test(priority=2)
	void login()
	{
		System.out.println("Login to application....");
	}
	
	@Test(priority=3)
	void logout()
	{
		System.out.println("Logout to application....");
	}

}

//1) TestNG execute test methods based on alphabetical order.
//
//2) @Test(priority=numb) controls the order of execution.
//
//3) Once you provide priority to the test methods, then order of methods is not considered.
//
//4) priorities can be random numbers (no need to have consecutive numbers)
//
//5) If you don't provide priority then default value is Zero (0).
//
//6) If the priorities are same then again execute methods in alphabetical order.
//
//7) Negative values are allowed in priority.
//
//8) TestNG execute test methods only if they are having @Test annotation.
