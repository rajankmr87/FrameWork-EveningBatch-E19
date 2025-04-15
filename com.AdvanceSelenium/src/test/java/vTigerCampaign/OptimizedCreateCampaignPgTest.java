/*Automate Test Case:
		 * Login to vtiger application->//use properties file
		 * mouseOverOn more Link-> Use Mouseover Action
		 * click on campaigns->
		 * click on create campaign lookup image->
		 * Enter campaignName-> //look from excel path
		 * click on save Btn->
		 * verify whether the campaign is created in campaign Information page
		 * and Logout from the application 
*/

package vTigerCampaign;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CampLookUpImg;
import Object_Repo.CampValidation;
import Object_Repo.CreateCampPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;

public class OptimizedCreateCampaignPgTest extends BaseClass{

	//public static void main(String[] args) throws Throwable {
	@Test(groups = {"SanityTest","RegressionTest"})
	public void optimizedCreateCampaignPg() throws Throwable {
			////Using Generic Utilities
//			File_Utility flib = new File_Utility();
			WebDriver_Utility wlib = new WebDriver_Utility();
			Excel_Utility elib = new Excel_Utility();
			
//			String BROWSER = flib.getKeyAndValuePair("browser");
//			String URL = flib.getKeyAndValuePair("url");
//			String USERNAME = flib.getKeyAndValuePair("username");
//			String PASSWORD = flib.getKeyAndValuePair("password");
//		
//		WebDriver driver;
		
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
		
//		wlib.maximizeWindow(driver);
//		wlib.waitElementToLoad(driver);
		
//		driver.get(URL);
				
		//Using Business Logic via Object_Repo LoginPage.Java
//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);
		
		//Business Logic implemented here from HomePage.Java object repository.
		Thread.sleep(3000);
			HomePage home = new HomePage(driver);
		home.clickCampLink();
		
		//Use of CampLookUpImg Object Repo
		CampLookUpImg lookUp = new CampLookUpImg(driver);
		lookUp.clickCampLookUp();
		
		String cmpgnPrdName = elib.ReadFromExcelData("Campaign", 0, 0);
			
		//Use of CreateCampPage Object Repo
		CreateCampPage camp = new CreateCampPage(driver);
		camp.enterCampDetails(cmpgnPrdName);
		
		//Use of CampValidation Object Repo
		CampValidation validate = new CampValidation(driver);
		validate.validateCamp(driver, cmpgnPrdName);
		
		Thread.sleep(2000);
	//	home.signOut();
	}

}
