package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelusingDataFormatter {

	public static void main(String[] args) throws Throwable {
	
		//Step 1:- Path connection
				FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
				
				//Step 2:- Keeps the workbook/excel file in read mode.
				Workbook book = WorkbookFactory.create(fis);
				
				//Step 3:- Navigate expected sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				//Step 4:- Navigate expected row ----> row value start from 0
				Row row1 = sheet.getRow(0);//string
				Row row2 = sheet.getRow(3);//alpha numeric string
				Row row3 = sheet.getRow(1);//number
				
				//Step 5:- Navigate expected cell----> cell value start from 0
				Cell cell1 = row1.getCell(0);
				Cell cell2 = row2.getCell(1);
				Cell cell3 = row3.getCell(2);
				
				DataFormatter format = new DataFormatter();// This is used to print any type of data in the sheet instead of using specific format to print.
				String excelData1 = format.formatCellValue(cell1);
				String excelData2 = format.formatCellValue(cell2);
				String excelData3 = format.formatCellValue(cell3);
				
				System.out.println(excelData1);
				System.out.println(excelData2);
				System.out.println(excelData3);
				

	}

}
