/* Test Case:
 * Login to vtiger application->
 * click on organizations link->
 * click on create organization lookup image->
 * Enter organisation name,phone number and email->
 * click on save Btn->
 * verify whether the organization is created in Organization Information page 
 * and Logout from the application
 */

package vTigerOrganization;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.LoginPage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "SmokeTest")
	public void createOrganization() throws Throwable {
	//public static void main(String[] args) throws Throwable {

		/*
		 * FileInputStream fis = new FileInputStream("./src/test/resources/DDT.properties");
		 * 
		 * // step2:-create an object to properties class to load all the keys
		 * Properties pro = new Properties(); 
		 * pro.load(fis);
		 * 
		 * // step3:-read the value using getProperty() 
		 * String BROWSER = pro.getProperty("browser"); 
		 * String URL = pro.getProperty("url"); 
		 * String USERNAME = pro.getProperty("username"); 
		 * String PASSWORD = pro.getProperty("password");
		 */
		
		////Using Generic Utility here with File_Utitlity Class--Date-21/03/2025
//		File_Utility flib = new File_Utility();
//		String BROWSER = flib.getKeyAndValuePair("browser");
//		String URL = flib.getKeyAndValuePair("url");
//		String USERNAME = flib.getKeyAndValuePair("username");
//		String PASSWORD = flib.getKeyAndValuePair("password");
//		
//		WebDriver driver;
//
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//
//		//Use of WbDriver Utility here 
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.maximizeWindow(driver);
//		wlib.waitElementToLoad(driver);
//		
//		driver.get(URL);
////		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
////		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
////		driver.findElement(By.id("submitButton")).click();
//		
//		//Using Business Logic via Object_Repo LoginPage.Java
//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		// To avoid Duplicates
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		
		//Using Generic Utility here using Java_Utility Class--Date-21/03/2025
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		// step1:- path connection
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
//		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
//		Sheet sheet = book.getSheet("Organization");

		// step4:- Navigating expected row--->row value starts from 0
//		Row row = sheet.getRow(0);

		// step5:- Navigating expected cell--->cell value starts from 0
//		Cell cell = row.getCell(0);

//		String orgName = cell.getStringCellValue() + ranNum;
//		System.out.println(orgName);
		
		//Using Excel Utility here using Excel_Utility Class--Date-21/03/2025
		Excel_Utility elib = new Excel_Utility();
		String orgName = elib.ReadFromExcelData("Organization", 0, 0);
		
		driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
		// -------------------------------------------------------------------------------------------------------
//		Row row1 = sheet.getRow(1);
//		Cell cell1 = row1.getCell(0);
//		DataFormatter format = new DataFormatter();
//		String phnNum = format.formatCellValue(cell1);
		
		//Using Excel Utility here using Excel_Utility Class--Date-21/03/2025
		String phnNum = elib.ReadFromExcelData("Organization", 1, 0);
		
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		
		
		// -------------------------------------------------------------------------------------------------------
//		Row row2 = sheet.getRow(2);
//		Cell cell2 = row2.getCell(0);
//		DataFormatter format1 = new DataFormatter();
//		String emailId = format1.formatCellValue(cell2);
		
		//Using Excel Utility here using Excel_Utility Class--Date-21/03/2025
		String emailId = elib.ReadFromExcelData("Organization", 2, 0);
		driver.findElement(By.id("email1")).sendKeys(emailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	if(actData.contains(orgName))
	{
		System.out.println("Organization name is created");
	}
	else
	{
		System.out.println("Organization name is not created");
	}
//	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//	driver.findElement(By.linkText("Sign Out")).click();
//	HomePage home = new HomePage(driver);
//	home.signOut();
	
//	driver.close();
	}

}