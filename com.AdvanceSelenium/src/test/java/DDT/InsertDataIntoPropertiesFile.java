package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {

		Properties pro = new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "https://www.google.co.in");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/insertdata.properties");
		pro.store(fos, "New Data Inserted using script in property file");
		
		//-----------------------------------------------------------------------------------------------------------------
		//Fetch the data from properties file and launch the data as per file
		FileInputStream fis = new FileInputStream("./src/test/resources/insertdata.properties");
		
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");//browser from the written word from the properties file
		String URL = pro.getProperty("url");//URL from the written word from the properties file
		
		
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
		driver.get(URL);
		
	}

}
