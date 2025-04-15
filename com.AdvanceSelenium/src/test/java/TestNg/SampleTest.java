package TestNg;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;

public class SampleTest extends BaseClass {

	//@Test (priority = 0) // If priority will not be set then test will run as per alphabetical order by Class Names
	@Test (priority = 1, invocationCount = 3)
	public void createContact()
	{
	//	*
		System.out.println("ContactCreated");
	}
	
	//@Test (priority = 1)
	@Test(dependsOnMethods = "createContact", priority = 0) //Independent Priority will execute first then it will move to dependency + Priority
	public void modifyContact()
	{
		System.out.println("ContactModified");
	}
	
	//@Test (priority = 2)// I have not given here the dependency
	@Test (dependsOnMethods = {"createContact","modifyContact"}, priority = -1)
	public void deleteContact()
	{
		System.out.println("ContactDeleted");
	}
	
	@Test (enabled = false)
	public void CheckToExecute()
	{
		System.out.println("It won't execute as it is marked as False to execute");
	}
}
