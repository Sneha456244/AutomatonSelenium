package TestNG02;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


//Hard assertion if anything failed it directly get excited and after the failed step the remaining will not perform
public class HardVsSoftAssertions 
{
	
	//@Test 
	
	void test_HardAssertions()
	{
		System.out.println("Testing....");
		System.out.println("Testing....");
		
		Assert.assertEquals(1, 2); //hard assertion
		
		System.out.println("Testing....");
		System.out.println("Testing....");
	}
	
	@Test 
	//Eventhough if something fails it execute the remaining steps 
	void test_SoftAssertions()
	{
		System.out.println("Testing....");
		System.out.println("Testing....");
		
		SoftAssert sa=new SoftAssert(); //object 
		
	    sa.assertEquals(1, 2); //Soft assertion
		
		System.out.println("Testing....");
		System.out.println("Testing....");
		
		sa.assertAll();  //mandatory
	}


}

/*2 kinds of assertions

1) Hard assertions

2) Soft assertions

**Hard assertions

we can access from "Assert" class

methods are static

if hard assertion failed then rest of the statements will not be executed.

**software assertion

we can access though "SoftAssert" object

SoftAssert sa=new SoftAssert();

sa.assertTrue()

if soft assertion got failed then rest of the statemetns still execute.*/


