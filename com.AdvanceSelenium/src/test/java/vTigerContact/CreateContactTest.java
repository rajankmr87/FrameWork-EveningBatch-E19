package vTigerContact;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.LoginPage;

public class CreateContactTest extends BaseClass {

	@Test(groups = "SanityTest")
	public void createContact() throws Throwable {
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
		
		////Using Utilities here 
//		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		
//		String BROWSER = flib.getKeyAndValuePair("browser");
//		String URL = flib.getKeyAndValuePair("url");
//		String USERNAME = flib.getKeyAndValuePair("username");
//		String PASSWORD = flib.getKeyAndValuePair("password");
//		
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

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();

		WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));

//		Select select = new Select(ele);
//		select.selectByValue("Mrs.");
//or
		// driver.findElement(By.xpath("//option[contains(@value,'Mrs.')]")).click();

		//Here using the WebDriver Utility for DropDown Select
		
		wlib.dropDown(ele, "Mrs.");
		
/*		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excel file in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet("Contact");

		// step4:- Navigating expected row--->row value starts from 0
		Row row = sheet.getRow(0);

		// step5:- Navigating expected cell--->cell value starts from 0
		Cell cell = row.getCell(0);

		String FirstName = cell.getStringCellValue();
		System.out.println(FirstName);
*/		
		String FirstName = elib.ReadFromExcelData("Contact", 0, 0);
		
		
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		
//----------------------------------------------------------------------------------------------------------------------------
/*		
		Row row1 = sheet.getRow(1);

		// step5:- Navigating expected cell--->cell value starts from 0
		Cell cell1 = row1.getCell(0);

		String LastName = cell1.getStringCellValue();
		System.out.println(LastName);
*/		
		String LastName = elib.ReadFromExcelData("Contact", 1, 0);
		

		driver.findElement(By.name("lastname")).sendKeys(LastName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actFirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();

		if (actFirstName.contains(FirstName)) {
			System.out.println("contact first name is created");
		} else {
			System.out.println("contact first name is not created");
		}

		String actLastName = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();

		if (actLastName.contains(LastName)) {
			System.out.println("contact last name is created");
		} else {
			System.out.println("contact last name is not created");
		}

//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
//		HomePage home = new HomePage(driver);
//		home.signOut();
	}

}