package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	//Executing same test script multiple times with Same set of data's is called Invocation Count.
	
	//Executing same test script multiple times with different set of data's is called DataProvider.
	//With the annotation as @DataProvider.
	
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int traveller) 
	{
		System.out.println("Book Tickets from "+src+" to "+dest+" travelling with "+traveller+" passengers.");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0] = "Delhi";
		objArr[0][1] = "Goa";
		objArr[0][2] = 50;
		
		objArr[1][0] = "Delhi";
		objArr[1][1] = "Mumbai";
		objArr[1][2] = 30;
		
		objArr[2][0] = "Delhi";
		objArr[2][1] = "Jaipur";
		objArr[2][2] = 10;
		
		return objArr;
		
	}

}
