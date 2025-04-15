package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 
{

	@Test(dataProvider = "readContactNames")
	public void createContact(String firstname, String lastname)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] readContactNames()
	{
		Object[][] objArr = new Object[4][2];
		
		objArr[0][0] = "Rajan";
		objArr[0][1] = "Kumar";
		
		objArr[1][0] = "Ashish";
		objArr[1][1] = "Kumar";
		
		objArr[2][0] = "Rajat";
		objArr[2][1] = "Kumar";
		
		objArr[3][0] = "Vishal";
		objArr[3][1] = "Kumar";
		
		return objArr;
	}
	
		
}
