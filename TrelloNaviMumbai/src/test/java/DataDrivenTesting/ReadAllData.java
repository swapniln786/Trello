package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/FbDropdown.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("dropdown");
		int fisrtRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		short firstCellNum = row.getFirstCellNum();
		short lastCellNum = row.getLastCellNum();
		for(int i=0;i<=lastRowNum;i++) {
			Row rowI = sheet.getRow(i);
			short lastCellNumOfCurrentRow = rowI.getLastCellNum();
			for(int j=0;j<=lastCellNumOfCurrentRow;j++) {
				System.out.println(rowI.getCell(j));
			}System.out.println();	
		}
	}
}
