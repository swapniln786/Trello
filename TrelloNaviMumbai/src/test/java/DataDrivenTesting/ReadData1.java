package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData1 {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("src\\test\\resources\\FbDropdown.xlsx");
Workbook workbook =WorkbookFactory.create(fis);
Sheet sheet = workbook.getSheet("dropdown");
int firstRowNum = sheet.getFirstRowNum();
int lastRowNum = sheet.getLastRowNum();
for(int i=firstRowNum;i<=lastRowNum;i++) {
	Row consideredRow = sheet.getRow(i);
	short firstCellNum = consideredRow.getFirstCellNum();
	short lastCellNum = consideredRow.getLastCellNum();
	for(int j=firstCellNum;j<lastCellNum;j++) {
		CellType cellType = consideredRow.getCell(j).getCellType();
		if(String.valueOf(cellType).equals("STRING")) {
			System.out.println( consideredRow.getCell(j).getStringCellValue());
		}else if(String.valueOf(cellType).equals("NUMERIC")) {
			System.out.println((long)consideredRow.getCell(j).getNumericCellValue());
		}	
	}
}
}
}
