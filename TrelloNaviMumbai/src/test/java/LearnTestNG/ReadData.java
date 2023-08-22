package LearnTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.testng.annotations.Test;

public class ReadData {
	static WebDriver driver;
	@Test
	public void readData() throws Throwable {
		List<String> expectedDayList = new ArrayList<String>();
		List<String> expectedMonthList = new ArrayList<String>();
		List<String> expectedYearList = new ArrayList<String>();
		List<String> actualDayList = new ArrayList<String>();
		List<String> actualMonthList = new ArrayList<String>();
		List<String> actualYearList = new ArrayList<String>();

		FileInputStream fis=new FileInputStream("./src\\test\\resources\\FbDropdown.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("dropdown");
		int firstRowIndex = sheet.getFirstRowNum();
		int lastRowIndex = sheet.getLastRowNum();
		for(int i=firstRowIndex;i<=lastRowIndex;i++) {
			Row consideredRow = sheet.getRow(i);
			short firstCellIndex = consideredRow.getFirstCellNum();
			short lastCellCount = consideredRow.getLastCellNum();
			for(int j=firstCellIndex+1;j<lastCellCount;j++) {
				CellType celltype = consideredRow.getCell(j).getCellType();
				if(String.valueOf(celltype).equals("STRING")) {
					String stringCellValue = consideredRow.getCell(j).getStringCellValue();
					expectedMonthList.add(stringCellValue);
				}else if(String.valueOf(celltype).equals("NUMERIC")) {
					long numericCellValue =(long) consideredRow.getCell(j).getNumericCellValue();
					if(i==0) {
						expectedDayList.add(String.valueOf(numericCellValue));
					}
					else if(i==2) {
						expectedYearList.add(String.valueOf(numericCellValue));
					}
				}
			}
		}
//		System.out.println(expectedDayList);
//		System.out.println(expectedMonthList);
//		System.out.println(expectedYearList);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/signup");
		List<WebElement> allDropdowns = driver.findElements(By.tagName("select"));
		for (WebElement dropdown : allDropdowns) {
			if(dropdown.isDisplayed()) {
				Select dropdownSelect=new Select(dropdown);
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					if(dropdown.getAttribute("title").equals("Day")){
					actualDayList.add(option.getText());	
					}
					else if (dropdown.getAttribute("title").equals("Month")) {
						actualMonthList.add(option.getText());
					}else if(dropdown.getAttribute("title").equals("Year")) {
					actualYearList.add(option.getText());
				}
			}
		}}
	if(expectedDayList.equals(actualDayList)) {
		System.out.println("Passed - Order and spelling of day dropdwown is correct");
		System.out.println(expectedDayList);
		System.out.println(actualDayList);
	}else {
		System.out.println("Failed - Order and spelling of day dropdwown is incorrect");
		System.out.println(expectedDayList);
		System.out.println(actualDayList);

	}
	if(expectedMonthList.equals(actualMonthList)) {
		System.out.println("Passed - Order and spelling of month dropdwown is correct");
		System.out.println(expectedMonthList);
		System.out.println(actualMonthList);

	}else {
		System.out.println("Failed - Order and spelling of month dropdwown is incorrect");
		System.out.println(expectedMonthList);
		System.out.println(actualMonthList);
	}
	if(expectedYearList.equals(actualYearList)) {
		System.out.println("Passed - Order and spelling of year dropdwown is correct");
		System.out.println(expectedYearList);
		System.out.println(actualYearList);
	}else {
		System.out.println("Failed - Order and spelling of year dropdwown is incorrect");
		System.out.println(expectedYearList);
		System.out.println(actualYearList);
	}
	
//		System.out.println(actualDayList);
//		System.out.println(actualMonthList);
//		System.out.println(actualYearList);
	driver.manage().window().minimize();
	driver.quit();
	}
	
}
