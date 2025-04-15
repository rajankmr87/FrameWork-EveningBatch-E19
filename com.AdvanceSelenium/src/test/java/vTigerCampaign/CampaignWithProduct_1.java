package vTigerCampaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
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

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.LoginPage;

public class CampaignWithProduct_1 {

	public static void main(String[] args) throws Throwable {

/*		FileInputStream fis = new FileInputStream("./src/test/resources/DDT.properties");
		
		Properties pro = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");//browser from the written word from the properties file
		String URL = pro.getProperty("url");//URL from the written word from the properties file
		String USERNAME = pro.getProperty("username");//user name from the written word from the properties file
		String PASSWORD = pro.getProperty("password");//password from the written word from the properties file
*/		
				////Using Generic Utility here with File_Utitlity Class--Date-21/03/2025
				File_Utility flib = new File_Utility();
				String BROWSER = flib.getKeyAndValuePair("browser");
				String URL = flib.getKeyAndValuePair("url");
				String USERNAME = flib.getKeyAndValuePair("username");
				String PASSWORD = flib.getKeyAndValuePair("password");
		
		
		WebDriver driver;
		
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
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementToLoad(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//Using Business Logic via Object_Repo LoginPage.Java
		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);
		 
		//MouseHover to More Button
		WebElement moreMouse = driver.findElement(By.xpath("//a[text()='More']"));
		Actions a = new Actions(driver);
		a.moveToElement(moreMouse).perform();
		//Click on Campaign Link
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		//Click on Create button
		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		
		//Read from Excel file for Campaign Product Name
/*		FileInputStream excelData = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(excelData);
		Sheet sheet = book.getSheet("Campaign");
		
		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(0);
		String cmpgnPrdName = cell1.getStringCellValue();
*/		
		//Using Excel Utility here using Excel_Utility Class--Date-21/03/2025
		Excel_Utility elib = new Excel_Utility();
		String cmpgnPrdName = elib.ReadFromExcelData("Campaign", 0, 0);
				
		
		System.out.println(cmpgnPrdName);
		
		
		
		//Insert Campaign Name from Excel file to WebPage text fld. 
		WebElement cmpgnName = driver.findElement(By.name("campaignname"));
		cmpgnName.sendKeys(cmpgnPrdName);
		
		
		//click on the Product + sign to select product from pop up
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
		
		
		//------------------------------------------------------
		Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        // Switch to the child window (the second window)
        String parentHandle = iterator.next();
        String childHandle = iterator.next();

        // Switch to the child window
        driver.switchTo().window(childHandle);

	  //---------------------------------------------------------
		
		//Select the Product from Pop-up
		driver.findElement(By.xpath("//a[@id=\"1\"]")).click();
		
		 driver.switchTo().window(parentHandle);
		
		//Click on Save Button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Get the text visible from the web page after save to match validation
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		//Validation from Excel 
		if(actData.contains(cmpgnPrdName))
		{
			System.out.println("Campaign with Product Name is created");
		}
		else {
			System.out.println("Campaign with Product Name is not created");
		}
		//Click on Sign-out 
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}

}
