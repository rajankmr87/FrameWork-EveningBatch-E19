/*Automate Test Case:
		 * Login to vtiger application-> //use properties file
		 * click on product link->
		 * click on create product lookup image-> 
		 * Enter product name-> //look from excel path
		 * click on save Btn->
		 * verify whether the product is created in product Information page 
		 * and Logout from the application.
*/
package vTigerProduct;

import java.io.FileInputStream;
import java.time.Duration;
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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;

public class productAddTest extends BaseClass {

	@Test(groups = "RegressionTest")
	public void ProductAdd() throws Throwable {
	//public static void main(String[] args) throws Throwable {
/*		
		//STEP -1
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT.properties");
		
		Properties pro = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");//browser from the written word from the properties file
		String URL = pro.getProperty("url");//URL from the written word from the properties file
		String USERNAME = pro.getProperty("username");//user name from the written word from the properties file
		String PASSWORD = pro.getProperty("password");//password from the written word from the properties file
*/		
			////Using Utilities here 
			//File_Utility flib = new File_Utility();
			WebDriver_Utility wlib = new WebDriver_Utility();
			Excel_Utility elib = new Excel_Utility();
		
//			String BROWSER = flib.getKeyAndValuePair("browser");
//			String URL = flib.getKeyAndValuePair("url");
//			String USERNAME = flib.getKeyAndValuePair("username");
//			String PASSWORD = flib.getKeyAndValuePair("password");
//		
//		WebDriver driver;
//		
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
//		
//		wlib.maximizeWindow(driver);
//		wlib.waitElementToLoad(driver);
//		
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get(URL);
////		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
////		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
////		driver.findElement(By.id("submitButton")).click();
//		
//		//Using Business Logic via Object_Repo LoginPage.Java
//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);
//		
		//STEP-2
		driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
		
		//STEP-3
		//driver.findElement(By.xpath("//a[contains(text(),'Create a')]")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
		
/*		//STEP-4
		FileInputStream excelData = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(excelData);
		Sheet sheet = book.getSheet("vTigerSheet");
		
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(0);
		String excelData1 = cell1.getStringCellValue();
		
		System.out.println(excelData1);
*/
		String excelData1 = elib.ReadFromExcelData("vTigerSheet", 1, 0);
		
		WebElement prdName = driver.findElement(By.name("productname"));
		prdName.sendKeys(excelData1);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		if(actData.contains(excelData1))
		{
			System.out.println("Product Name is created");
		}
		else {
			System.out.println("Product Name is not created");
		}
		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
//		HomePage home = new HomePage(driver);
//		home.signOut();
		
	}

}
