package DDT;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {

		File file = new File("./src/test/resources/Rajan Kumar_BA_Specialist.pdf");
		
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();

		System.out.println(pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);
		System.out.println(readData);
		
		//Incase of multiple page, I want to read only 1 page or specific page only
	/*	pdfData.setStartPage(2);
		pdfData.setEndPage(3);// If you will not give the end page number then it will read the data from start page to end page.
		String readData1 = pdfData.getText(doc);
		System.out.println(readData1);*/
		
	}

}
