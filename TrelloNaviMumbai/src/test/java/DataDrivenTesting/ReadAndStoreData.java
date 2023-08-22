package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAndStoreData {
public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
	List<String> expectedDayList = new ArrayList<String>();
	List<String> expectedMonthList = new ArrayList<String>();
	List<String> expectedYearList = new ArrayList<String>();
	Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/FbDropdown.xlsx"));
	Sheet sheet = workbook.getSheet("dropdown");
	int firstRowIndex = sheet.getFirstRowNum();
	int lastRowIndex=sheet.getLastRowNum();
	for(int i=firstRowIndex;i<=lastRowIndex;i++) {
		Row consideredRow = sheet.getRow(i);
		short firstCellIndex = consideredRow.getFirstCellNum();
		short lastCellCount= consideredRow.getLastCellNum();
		for(int j=firstCellIndex+1;j<lastCellCount;j++) {
			CellType cellType = consideredRow.getCell(j).getCellType();
			if(String.valueOf(cellType).equals("STRING")) {
				String stringCellValue = consideredRow.getCell(j).getStringCellValue();
				expectedMonthList.add(stringCellValue);
			}else if(String.valueOf(cellType).equals("NUMERIC")) {
				 long numericCellValue = (long)consideredRow.getCell(j).getNumericCellValue();
				 if(consideredRow.getLastCellNum()==32) {
					 expectedDayList.add(String.valueOf(numericCellValue));
				 }else if(consideredRow.getLastCellNum()==120) {
					 expectedYearList.add(String.valueOf(numericCellValue));
				 }
			}
		}
	}
	workbook.close();
	System.out.println(expectedDayList);
	System.out.println(expectedMonthList);
	System.out.println(expectedYearList);
}
}
