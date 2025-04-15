package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintFlipkartLinksInExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream("./src/test/resources/FlipkartData.xlsx");
		
		//Step 2:- Keeps the workbook/excel file in read mode.
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3:- Navigate expected sheet
		Sheet sheet = book.getSheet("Sheet2");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for(int i = 0;i<links.size();i++)
		{
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));
			
			
		}

		//FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/FlipkartData.xlsx");
		book.write(fos);
		book.close();
		
		/* This can be used here if in the same code we need to read it from write.
		 * 
		for(int j=0;j<links.size();j++)
		{
		
			Row row1 = sheet.getRow(j);
			Cell cell1 = row1.getCell(0);
			String urllinks = cell1.getStringCellValue();
			System.out.println(urllinks);
		}
		*/
	}

}
