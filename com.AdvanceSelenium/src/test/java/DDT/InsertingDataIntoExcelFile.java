package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertingDataIntoExcelFile {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//Step 2:- Keeps the workbook/excel file in read mode.
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3:- Navigate expected sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//Step 4:- Navigate expected row ----> row value start from 0
		Row row1 = sheet.createRow(0);
		
		//Step 5:- Navigate expected cell----> cell value start from 0
		Cell cell1 = row1.createCell(2);
		
		cell1.setCellValue("PhoneNumber");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		book.write(fos);
		book.close();
		
		System.out.println("Data Printed the "+cell1);
	

	}

}
