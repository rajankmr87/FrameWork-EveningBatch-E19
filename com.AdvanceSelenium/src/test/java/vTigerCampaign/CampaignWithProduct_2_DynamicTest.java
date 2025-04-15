package vTigerCampaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.LoginPage;

public class CampaignWithProduct_2_DynamicTest extends BaseClass {
		
	@Test
		public void campaignWithProduct_2_Dynamic() throws Throwable {
			////Using Generic Utilities
	//public static void main(String[] args) throws Throwable {
			
			//STEP -1--Add the new Product
		//	FileInputStream fis = new FileInputStream("./src/test/resources/DDT.properties");
			
		//	Properties pro = new Properties();
		//	pro.load(fis);
			
		//	String BROWSER = pro.getProperty("browser");//browser from the written word from the properties file
		//	String URL = pro.getProperty("url");//URL from the written word from the properties file
		//	String USERNAME = pro.getProperty("username");//user name from the written word from the properties file
		//	String PASSWORD = pro.getProperty("password");//password from the written word from the properties file
			
			////Using Generic Utility here with File_Utitlity Class--Date-21/03/2025
//			File_Utility flib = new File_Utility();
//			String BROWSER = flib.getKeyAndValuePair("browser");
//			String URL = flib.getKeyAndValuePair("url");
//			String USERNAME = flib.getKeyAndValuePair("username");
//			String PASSWORD = flib.getKeyAndValuePair("password");			
//			
//			WebDriver driver;
//			
//			if(BROWSER.equalsIgnoreCase("chrome"))
//			{
//				driver = new ChromeDriver();
//			}
//			else if(BROWSER.equalsIgnoreCase("firefox"))
//			{
//				driver = new FirefoxDriver();
//			}
//			else if(BROWSER.equalsIgnoreCase("edge"))
//			{
//				driver = new EdgeDriver();
//			}
//			else
//			{
//				driver=new ChromeDriver();
//			}
//			
//			
			WebDriver_Utility wlib = new WebDriver_Utility();
//			wlib.maximizeWindow(driver);
//			wlib.waitElementToLoad(driver);
//			
//			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			driver.get(URL);

//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
			
			//Using Business Logic via Object_Repo LoginPage.Java
//			LoginPage login = new LoginPage(driver);
//			login.loginIntoApp(USERNAME, PASSWORD);
//			
			
			driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
			driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
			
			//Generate Random number between 1 to 1000.
		//	Random ran = new Random();
		//	int ranNum = ran.nextInt(1000);
			
			//Using Generic Utility here using Jaba_Utility Class--Date-21/03/2025
			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRandomNum();
			
/*			FileInputStream excelData = new FileInputStream("./src/test/resources/TestData.xlsx");
			Workbook book = WorkbookFactory.create(excelData);
			Sheet sheet = book.getSheet("vTigerSheet");
			
			Row row1 = sheet.getRow(1);
			Cell cell1 = row1.getCell(0);
			String product = cell1.getStringCellValue()+ranNum;
*/
			//Using Excel Utility here using Excel_Utility Class--Date-21/03/2025
			Excel_Utility elib = new Excel_Utility();
			String product = elib.ReadFromExcelData("vTigerSheet", 1, 0)+ranNum;
			
			System.out.println(product);

			WebElement prdName = driver.findElement(By.name("productname"));
			prdName.sendKeys(product);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//=========================================================================================================//
			//STEP 2- Add the Campaign and Select the Product
			
			//MouseHover to More Button
			WebElement moreMouse = driver.findElement(By.xpath("//a[text()='More']"));
			Actions a = new Actions(driver);
			a.moveToElement(moreMouse).perform();
			//Click on Campaign Link
			driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
			//Click on Create button
			driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
			//driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
			
			//Read from Excel file for Campaign Product Name
/*			FileInputStream excelData1 = new FileInputStream("./src/test/resources/TestData.xlsx");
			Workbook book1 = WorkbookFactory.create(excelData1);
			Sheet sheet1 = book1.getSheet("Campaign");
			
			Row row2 = sheet1.getRow(0);
			Cell cell2 = row2.getCell(0);
			String cmpgnPrdName = cell2.getStringCellValue()+ranNum;
*/
			
			//Using Excel Utility here using Excel_Utility Class--Date-21/03/2025
			//Excel_Utility elib = new Excel_Utility();
			String cmpgnPrdName = elib.ReadFromExcelData("Campaign", 0, 0)+ranNum;
			System.out.println(cmpgnPrdName);
			
			//Insert Campaign Name from Excel file to WebPage text fld. 
			WebElement cmpgnName = driver.findElement(By.name("campaignname"));
			cmpgnName.sendKeys(cmpgnPrdName);
			
			//click on the Product + sign to select product from pop up
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
			
//			Set<String> allWins = driver.getWindowHandles();
//			Iterator<String> it = allWins.iterator();
//
//			while (it.hasNext()) {
//				String win = it.next();
//				driver.switchTo().window(win);
//				String title = driver.getTitle();
//				if (title.contains("Products&action")) {
//					break;
//				}
//			}

			//Use of WbDriver Utility here 
			
			wlib.windowSwitching(driver, "Products&action");
			
			driver.findElement(By.name("search_text")).sendKeys(product);
			driver.findElement(By.cssSelector("[name=\"search\"]")).click();
			Thread.sleep(3000);
			
			//driver.findElement(By.xpath("//a[text()='Puma']")).click();
			//Instead of Above use Dynamic Xpath
			driver.findElement(By.xpath("//a[text()='" + product + "']")).click();
			//-------------------------------------------------------------------------------------------------
			
//			Set<String> allWins1 = driver.getWindowHandles();
//			Iterator<String> it1 = allWins1.iterator();
//
//			while (it1.hasNext()) {
//				String win1 = it1.next();
//				driver.switchTo().window(win1);
//				String title1 = driver.getTitle();
//				if (title1.contains("Campaigns&action")) {
//					break;
//				}
//			}
			
			//Use of WbDriver Utility here 
			wlib.windowSwitching(driver, "Campaigns&action");
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();

			if (actData.equals(cmpgnPrdName)) {
				System.out.println("Campaign name is created");
			} else {
				System.out.println("Campaign name is not created");
			}
		
			String actPrd = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
			if (actPrd.equals(product)) {
				System.out.println("product name is created");
			} else {
				System.out.println("product name is not created");
			}
			
//			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//			driver.findElement(By.linkText("Sign Out")).click();
			
//			driver.close();

	}

}
