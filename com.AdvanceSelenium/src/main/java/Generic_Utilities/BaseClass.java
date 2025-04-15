package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Object_Repo.HomePage;
import Object_Repo.LoginPage;
//Pulling froom GitHub Test
public class BaseClass 
{
	public WebDriver driver;
	
	@BeforeSuite(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void beforeSuite()
	{
		System.out.println("DataBase Connection.");
	}
	@BeforeTest(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void beforeTest()
	{
		System.out.println("Parallel Execution.");
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void beforeClass(String BROWSER) throws Throwable
	{
//		File_Utility flib = new File_Utility();
//		String BROWSER = flib.getKeyAndValuePair("browser");
		System.out.println("Launching Browser.");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
	}
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void beforeMethod(String URL, String USERNAME, String PASSWORD) throws Throwable
	{
//		File_Utility flib = new File_Utility();
//		String URL = flib.getKeyAndValuePair("url");
//		String USERNAME = flib.getKeyAndValuePair("username");
//		String PASSWORD = flib.getKeyAndValuePair("password");
//		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementToLoad(driver);
		
		driver.get(URL);
		
		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		System.out.println("Login into the application");
	}
	
	@AfterMethod(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void afterMethod()
	{		
		HomePage home = new HomePage(driver);
		home.signOut();
		System.out.println("Logout from application");
	}
	
	@AfterClass(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void afterClass()
	{
		driver.close();
		System.out.println("Close the browser");
	}
	
	@AfterTest(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void afterTest()
	{
		System.out.println("Close paralle execution");
	}
	
	@AfterSuite(groups = {"SanityTest","RegressionTest","SmokeTest"})
	public void afterSuite()
	{
		System.out.println("Close the DatabBase");
	}
}
