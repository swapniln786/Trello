package HandlingDropdowns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderAndSpellingCheckOfAllOptions {
	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		List<String> actualDayList = new ArrayList<String>();
		List<String> actualMonthList = new ArrayList<String>();
		List<String> actualYearList = new ArrayList<String>();
		List<String> expectedDayList = new ArrayList<String>();
		List<String> expectedMonthList = new ArrayList<String>();
		List<String> expectedYearList = new ArrayList<String>();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup");
		List<WebElement> allDropdowns = driver.findElements(By.tagName("select"));
		for (WebElement dropdown : allDropdowns) {
			if(dropdown.isDisplayed()) {
				Select dropdownSelect=new Select(dropdown);
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					if(dropdown.getAttribute("title").equals("Day")) {
						String dayOptions = option.getText();
						actualDayList.add(dayOptions);
					}else if(dropdown.getAttribute("title").equals("Month")) {
						String monthOptions = option.getText();
						actualMonthList.add(monthOptions);
					}else if(dropdown.getAttribute("title").equals("Year")) {
						String yearOptions = option.getText();
						actualYearList.add(yearOptions);
					}
				}
			}
		}Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/FbDropdown.xlsx"));
		Sheet sheet = workbook.getSheet("dropdown");
		int firstRowIndex = sheet.getFirstRowNum();
		int lastRowIndex = sheet.getLastRowNum();
		for(int i=firstRowIndex;i<=lastRowIndex;i++) {
			Row considerdRow = sheet.getRow(i);
			short firstCellIndex = considerdRow.getFirstCellNum();
			short lastCellCount = considerdRow.getLastCellNum();
			for(int j=firstCellIndex+1;j<lastCellCount;j++) {
				CellType cellType = considerdRow.getCell(j).getCellType();
				if(String.valueOf(cellType).equals("STRING")) {
					String stringCellValue=considerdRow.getCell(j).getStringCellValue();
					expectedMonthList.add(stringCellValue);
				}else if(String.valueOf(cellType).equals("NUMERIC")) {
					long numericCellValue = (long) considerdRow.getCell(j).getNumericCellValue();
					if(considerdRow.getLastCellNum()==32) {
						expectedDayList.add(String.valueOf(numericCellValue));
					}else if(considerdRow.getLastCellNum()==120) {
						expectedYearList.add(String.valueOf(numericCellValue));
					}
				}
			}
		}
		//comparing the actual and expected data
		if(expectedDayList.equals(actualDayList)) {
			System.out.println("Pass The Day Option order and spelling is correct");
			System.out.println(expectedDayList);
			System.out.println(actualDayList);
		}else {
			System.out.println("Fail The Day Option order and spelling is incorrect");
			System.out.println(expectedDayList);
			System.out.println(actualDayList);
		}
		if(expectedMonthList.equals(actualMonthList)) {
			System.out.println("Pass The Month Option order and spelling is correct");
			System.out.println(expectedMonthList);
			System.out.println(actualMonthList);
		}else {
			System.out.println("Fail The Month Option order and spelling is incorrect");
			System.out.println(expectedMonthList);
			System.out.println(actualMonthList);
		}
		if(expectedYearList.equals(actualYearList)) {
			System.out.println("Pass The Year Option order and spelling is correct");
			System.out.println(expectedYearList);
			System.out.println(actualYearList);
		}else {
			System.out.println("Fail The Year Option order and spelling is incorrect");
			System.out.println(expectedYearList);
			System.out.println(actualYearList);
		}
		workbook.close();
		driver.manage().window().minimize();
		driver.quit();
	}
}
