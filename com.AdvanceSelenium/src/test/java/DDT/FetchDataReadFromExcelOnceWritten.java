package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataReadFromExcelOnceWritten {

	public static void main(String[] args) throws Throwable {

		
				FileInputStream fis = new FileInputStream("./src/test/resources/FlipkartData.xlsx");
				
				//Step 2:- Keeps the workbook/excel file in read mode.
				Workbook book = WorkbookFactory.create(fis);
				
				//Step 3:- Navigate expected sheet
				Sheet sheet = book.getSheet("Sheet2");
				
				int rowNum = sheet.getLastRowNum();
				
				for(int i=0; i<rowNum; i++)
				{
					Row row = sheet.getRow(i);
					Cell cell = row.getCell(0);
					String links = cell.getStringCellValue();
					System.out.println(links);
				}

	}

}
