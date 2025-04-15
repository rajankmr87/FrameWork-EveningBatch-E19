package Generic_Utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String ReadFromExcelData(String SheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(SheetName);
		
		Row row1 = sheet.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell1);
		System.out.println(ExcelData);
		return ExcelData;
		
	}
	
	public Object[][] readDataUsingDataProvider(String SheetName ) throws Throwable
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet(SheetName);
	
	int lastRow = sheet.getLastRowNum()+1;
	int lastCell = sheet.getRow(0).getLastCellNum();
	
	Object [][] obj = new  Object[lastRow][lastCell];
	for(int i = 0; i<lastRow; i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			obj[i][j] = sheet.getRow(i).getCell(j).toString();
		}
	}
	
	return obj;
	}
	
}
