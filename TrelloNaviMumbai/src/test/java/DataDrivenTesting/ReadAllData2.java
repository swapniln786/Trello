package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllData2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/FbDropdown.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("dropdown");
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		//		Row row = sheet.getRow(0);
		//		short firstCellNum = row.getFirstCellNum();
		//		short lastCellNum = row.getLastCellNum();
		for(int i=firstRowNum;i<=lastRowNum;i++) {
			Row consideredRow = sheet.getRow(i);
			short firstCellIndex = consideredRow.getFirstCellNum();
			short lastCellCount = consideredRow.getLastCellNum();
			for(int j=firstCellIndex+1;j<lastCellCount;j++) {
				CellType cellType = consideredRow.getCell(j).getCellType();
				if(String.valueOf(cellType).equals("STRING")) {
					String stringCellvalue = consideredRow.getCell(j).getStringCellValue();
					 System.out.println(stringCellvalue);
					
				}else if(String.valueOf(cellType).equals("NUMERIC")) {
					long numericCellValue = (long)consideredRow.getCell(j).getNumericCellValue();
					System.out.println(numericCellValue);
				}		
			}
		}
	}
}
