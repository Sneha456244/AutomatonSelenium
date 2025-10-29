package DependencyMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyDemo {
  
  @Test(priority=1)
  public void OpenApp() 
  {
	  Assert.assertTrue(true);
  }
  
  @Test(priority=2,dependsOnMethods= {"OpenApp"}) 
  public void Login()
  {
	  Assert.assertTrue(true);
  }
  
  @Test(priority=3,dependsOnMethods= {"Login"})
  public void Search()
  {
	  Assert.assertTrue(false);
  }
  
  @Test(priority=4,dependsOnMethods= {"Login","Search"})
  public void AdvSearch()
  {
	  Assert.assertTrue(true);
  }
  
  @Test(priority=5,dependsOnMethods= {"AdvSearch"})
  public void LogOut()
  {
	  Assert.assertTrue(true);
  }
}
