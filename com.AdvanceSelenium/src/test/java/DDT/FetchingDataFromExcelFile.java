package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

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
		
		String excelData1 = cell1.getStringCellValue();
		String excelData2 = cell2.getStringCellValue();
		//double excelData2 = cell2.getNumericCellValue(); // It will be wrong as the string can not be used as numeric. 
		//double excelData3 = cell3.getNumericCellValue(); // This is a way to print your number but it will print in double format.
		long excelData3 = (long) cell3.getNumericCellValue(); // we can use the way the number length, accordingly we cantake the variable type to print and cast.
		System.out.println(excelData1);
		System.out.println(excelData2);
		System.out.println(excelData3);
		
	}

}
